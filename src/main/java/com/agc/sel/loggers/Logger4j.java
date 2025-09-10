
package com.agc.sel.loggers;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Logger4j class provides a wrapper around the SLF4J Logger to simplify
 * logging operations. It includes methods for logging messages at different
 * levels such as INFO, WARN, ERROR, and DEBUG.
 */
public class Logger4j {

	// Logger instance for logging messages
	private static final Logger logger = LoggerFactory.getLogger(Logger4j.class);
	public static WebDriver exceptionDriver;

	/**
	 * Logs an informational message.
	 *
	 * @param message The message to be logged at the INFO level.
	 */
	public static void info(String message) {
		logger.info(message);
	}

	/**
	 * Logs a warning message.
	 *
	 * @param message The message to be logged at the WARN level.
	 */
	public static void warn(String message) {
		logger.warn(message);
	}

	/**
	 * Logs an error message.
	 *
	 * @param message The message to be logged at the ERROR level.
	 */
	public static void error(String message) {
		logger.error(message);
	}

	/**
	 * Logs an error message along with a throwable (exception or error).
	 *
	 * @param message   The message to be logged at the ERROR level.
	 * @param throwable The throwable to be logged with the error message.
	 */
	public static void error(String message, Throwable throwable) {
		logger.error(message, throwable);
	}

	/**
	 * Logs a debug message.
	 *
	 * @param message The message to be logged at the DEBUG level.
	 */
	public static void debug(String message) {
		logger.debug(message);
	}
}
