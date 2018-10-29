package chap11;

public class MyExecutor implements Executor {

    @Log()
    //@Log(value=false, logTiming=LogTiming.BOTH)
    //@Log(value=true, logTiming=LogTiming.BEFORE_INVOCATION)
    //@Log(logTiming=LogTiming.BEFORE_INVOCATION)
    //@Log(value=true, logTiming=LogTiming.AFTER_INVOCATION)
    public void execute() {
        System.out.println("Invoking MyExecutor");
    }
}
