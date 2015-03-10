package cl.intelidata.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Configuracion {

	public static  Logger        logger = LoggerFactory.getLogger(Configuracion.class);
	private static Configuracion conf   = null;
	private HashMap<String, String> datos = new HashMap<String, String>();
	private String nameFileConf;

	private Configuracion(String nameFileConf) throws IOException {
		this.nameFileConf = nameFileConf;

		BufferedReader br = new BufferedReader(new FileReader(this.nameFileConf));
		String linea;
		while ((linea = br.readLine()) != null) {
			if (!linea.trim().isEmpty()) {
				String[] dat = linea.split("=");
				datos.put(dat[0].trim().toLowerCase(), dat[1].trim());
			}
		}
		br.close();

	}

	/**
	 * Para ser utilizado dentro de una app stadnalone
	 *
	 * @return
	 */
	public static Configuracion getInstance() {
		if (conf == null) {
			try {
				String archConf = "/apps/Amicar/config/cotizanteAmicar.properties";

				if (!System.getProperty("file.separator").equals("/")) {
					archConf = System.getProperty("disco", "c:") + archConf;
				}

				conf = new Configuracion(archConf);

				logger.info("Leyendo archivo de configuracion: " + archConf);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
		return conf;
	}

	public String getInitParameter(String name) {

		if (!datos.containsKey(name.toLowerCase())) {
			logger.error(String.format("GRAVE Error en configuracion llave %s no definida en archivo %s", name, nameFileConf));
			return null;
		}
		String valor = datos.get(name.toLowerCase());
		logger.info(String.format("%s=%s", name, valor));
		return valor;
	}
}
