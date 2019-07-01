package utilities;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;

public class Log4j {

    //Initialize Log4j instance
    private static Logger Log = Logger.getLogger(DisplayName.class);
//TODO listappender, how to get medhod name,how to work override and how can use

    public void givenObject_whenGetEnclosingMethod_thenFindMethod() {
        String methodName = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
    }
    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (String testClassName){
        new Object(){}.getClass().getEnclosingMethod().getName();
        Log.info("Test Passed");
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}