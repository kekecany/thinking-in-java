package apt.factory;

import apt.InterfaceExtractorProcessor;
import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.xml.internal.xsom.parser.AnnotationParser;
import com.sun.xml.internal.xsom.parser.AnnotationParserFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by yangyang on 2017/3/29 21:14.
 */
public class InterfaceExtractorProcessorFactory implements AnnotationParserFactory{

    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds,
                                               AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }

    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }

    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
    @Override
    public AnnotationParser create() {
        return null;
    }
}
