package lab09.fin;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {

	public boolean value() default false;
	
	public CommitType commitType() default CommitType.ONE_PHASE;
}
