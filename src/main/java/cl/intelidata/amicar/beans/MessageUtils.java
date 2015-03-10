package cl.intelidata.amicar.beans;

import cl.intelidata.amicar.referencias.Texto;
/**
 * @author Maze
 */
public class MessageUtils {

	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(cl.intelidata.amicar.CargaDatosAmicar.class.getName());

	public MessageUtils() {
		initializeLogger();
	}

	public static void initializeLogger() {
		java.util.Properties logProperties = new java.util.Properties();
		try {
			logProperties.load(new java.io.FileInputStream(Texto.LOG_PROPERTIES_FILE));
			org.apache.log4j.PropertyConfigurator.configure(logProperties);
			LOGGER.info("LOGGING INITIALIZED.");
		} catch (java.io.IOException e) {
			throw new RuntimeException("UNABLE TO LOAD LOGGING PROPERTY " + Texto.LOG_PROPERTIES_FILE);
		}
	}

	public static void info(String message) {
		LOGGER.info(message);
	}

	public static void debug(String message) {
		LOGGER.debug(message);
	}

	public static void trace(String message) {
		LOGGER.trace(message);
	}

	public static void warm(String message) {
		LOGGER.warn(message);
	}

	public static void error(String message) {
		LOGGER.error(message);
	}

	public static void fatal(String message) {
		LOGGER.fatal(message);
	}
}
