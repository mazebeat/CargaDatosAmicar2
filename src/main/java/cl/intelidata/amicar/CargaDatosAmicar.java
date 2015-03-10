package cl.intelidata.amicar;

import cl.intelidata.amicar.beans.MessageUtils;
import cl.intelidata.amicar.componente.Procesa;

public class CargaDatosAmicar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length == 3) {
				// Lee la ubicacion del archivo
				Procesa procesa = new Procesa(args[0], args[1], args[2]);
				procesa.cargaData();
			} else {
				MessageUtils.error("Los argumentos no son validos... debe ingresar  <ruta de entrada> <Ruta de salida> y <Nombre del archivo>");
			}

		} catch (Exception e) {
			System.exit(1);
		}
	}
}
