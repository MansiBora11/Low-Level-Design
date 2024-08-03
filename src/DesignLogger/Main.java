package DesignLogger;

//Chain of responsibility principle
/*This pattern allows a request to pass through a chain of handlers until one of them handles it.
In this case, the request is a log message that needs to be processed by different log processors (Info, Debug, Error).*/
public class Main {
    public static void main(String[] args) {
        LogProcessor logObject=new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObject.log(LogProcessor.ERROR, "Exception message.");
        logObject.log(LogProcessor.DEBUG, "This needs to be debugged.");
        logObject.log(LogProcessor.INFO, "Just for info.");

    }
}
