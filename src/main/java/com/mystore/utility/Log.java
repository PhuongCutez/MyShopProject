package com.mystore.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    // Khởi tạo Log4j
    public static Logger log = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName) {
        log.info("**********************************************" + sTestCaseName + "TEST START **********************************************");
    }

    public static void endTestCase(String sTestCaseName) {
        log.info("**********************************************" + sTestCaseName + "TEST END **********************************************");
    }

    // Tạo các phương thức để gọi
    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }
}