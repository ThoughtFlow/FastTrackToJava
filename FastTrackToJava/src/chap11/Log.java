package chap11;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    public boolean value() default true;

    public LogTiming logTiming() default LogTiming.AFTER_INVOCATION;
}
