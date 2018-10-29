package chap11;


import java.lang.reflect.Method;

public class ExecutionFramework {

    public static void execute(Executor toExecute) {

        Method method = null;
        try {
            method = toExecute.getClass().getMethod("execute");
            Log log = method.getAnnotation(Log.class);
            if (log != null && log.value()) {
                if (log.logTiming() == LogTiming.BEFORE_INVOCATION || log.logTiming() == LogTiming.BOTH ) {
                    System.out.println("Before invocation of " + toExecute.getClass().getName());
                }
            }

            toExecute.execute();

            if (log != null && log.value()) {
                if (log.logTiming() == LogTiming.AFTER_INVOCATION || log.logTiming() == LogTiming.BOTH) {
                    System.out.println("After invocation of " + toExecute.getClass().getName());
                }
            }

        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No such method ", e);
        }
    }

    public static void main(String... args) {
        ExecutionFramework.execute(new MyExecutor());
    }
}
