package utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for managing test execution logging.
 * This class provides centralized logging functionality for test automation,
 * including test case start/end markers and general information logging.
 **/
public class Logs {
    private static final Logger log = LoggerFactory.getLogger(Logs.class);
    public static void startTestCase(String testCaseName) {
        log.info("****************************************************************************************");
        log.info("****************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$$$                 " + testCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("****************************************************************************************");
        log.info("****************************************************************************************");
    }

    public static void endTestCase() {
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
    }
    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }
}
