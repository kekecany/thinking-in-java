package bean;

import database.Constraints;
import database.DBTable;
import database.SQLInteger;
import database.SQLString;

/**
 * Created by yangyang on 2017/3/24 22:20.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;
    static int memberCount;
    public String getHandle() {
        return handle;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return handle;
    }
}
