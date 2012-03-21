/**
 * 
 */
package era.foss.tracing.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Requirement {

    String reqid();

    String reqtype() default "design";

    String[] reviewers();

    // int currentRevision() default 1;
}
