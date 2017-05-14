package database;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.DeclarationVisitors;
import com.sun.mirror.util.SimpleDeclarationVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by yangyang on 2017/4/3 13:29.
 */
public class TableCreationProcessorFactory implements AnnotationProcessorFactory{

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList("annotations.database.DBTable", "annotations.database.Constraints",
                "annotations.database.SQLString","annotations.database.SQLInteger");
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return new TableCreationProcessor(env);
    }

    private static class TableCreationProcessor implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;
        private String sql = "";
        public TableCreationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }
        @Override
        public void process() {
            for (TypeDeclaration typeDecl: env.getSpecifiedTypeDeclarations()) {
                typeDecl.accept(DeclarationVisitors.getDeclarationScanner(new TableCreationVisitor(),
                        DeclarationVisitors.NO_OP));
                sql = sql.substring(0, sql.length() - 1) + ");";
                System.out.println("creation SQL is :\n" + sql);
                sql = "";
            }
        }

        private class TableCreationVisitor extends SimpleDeclarationVisitor {
            @Override
            public void visitClassDeclaration(ClassDeclaration d) {
                DBTable dbTable = d.getAnnotation(DBTable.class);
                if (dbTable != null) {
                    sql += "CREATE TABLE ";
                    sql += (dbTable.name().length() < 1) ? d.getSimpleName().toUpperCase() : dbTable.name();
                    sql += " (";
                }
            }

            @Override
            public void visitFieldDeclaration(FieldDeclaration d) {
                String columName = "";
                if (d.getAnnotation(SQLInteger.class) != null) {
                    SQLInteger sInt = d.getAnnotation(SQLInteger.class);
                    if (sInt.name().length() < 1) {
                        columName = d.getSimpleName().toUpperCase();
                    }else {
                        columName = sInt.name();
                    }
                    sql += "\n  " + columName + " INT" + getConstraints(sInt.constraints());
                }
                if (d.getAnnotation(SQLString.class) != null) {
                    SQLString sString = d.getAnnotation(SQLString.class);
                    if (sString.name().length() < 1) {
                        columName = d.getSimpleName().toUpperCase();
                    }else {
                        columName = sString.name();
                    }
                    sql += "\n  " + columName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints());
                }
            }

            private String getConstraints(Constraints con) {
                String constraints = "";
                if (!con.allowNull()) {
                    constraints += " NOT NULL";
                }
                if (con.primaryKey()) {
                    constraints += " PRIMARY KEY";
                }
                if (con.unique()) {
                    constraints += " UNIQUE";
                }
                return constraints;
            }
        }
    }

}
