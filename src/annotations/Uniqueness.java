package annotations;

import database.Constraints;

/**
 * Created by yangyang on 2017/3/24 22:16.
 */
public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique=true);
}
