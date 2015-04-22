package cl.intelidata.amicar;

import static cl.intelidata.amicar.conf.Configuracion.logger;
import cl.intelidata.amicar.componente.Procesa;
import cl.intelidata.amicar.conf.Configuracion;

public class CargaDatosAmicar {

	/**
	 * @param args
	 */
	public static void main(String... args) {
		try {
			Configuracion.configLog4();
			if (args.length != 3) {
				logger.error("Los argumentos no son validos... debe ingresar [RUTA_ENTRADA] [RUTA_SALIDA] [ARCHIVO]");
				System.exit(1);
			}

			logger.info("Iniciando proceso de carga");
			Procesa procesa = new Procesa(args[0], args[1], args[2]);
			procesa.cargaData();
			logger.info("Proceso finalizado");

		} catch (Exception e) {
			logger.info("Error: {}", e);
			System.exit(1);
		}
	}
}