package cl.intelidata.amicar.beans;

public class Datos {
	/*******************************************************************************************************/
	/********************************************** Atributos **********************************************/
	/*******************************************************************************************************/
	private String strLinea = "";

	/*******************************************************************************************************/
	/******************************************** Constructores ********************************************/
	/*******************************************************************************************************/

	public Datos(String strLinea) {
		this.strLinea = strLinea;
	}

	/*******************************************************************************************************/
	/*********************************************** Metodos ***********************************************/
	/*******************************************************************************************************/
	public String extraer(int iPosicion) {
		String string = "";
		if (this.strLinea != null) {
			String[] array = separarColumnas(this.strLinea);
			string = array[iPosicion];
		}
		return string;
	}

	/**
	 * Separa la linea en columnas, segun el separador que tenga
	 * 
	 * @param strLinea
	 *            Linea a separar
	 * @return Devuelve un arreglo con la linea separada
	 */
	private String[] separarColumnas(String strLinea) {
		String separador = asignarSeparador(strLinea);
		if (!strLinea.endsWith(separador)) {
			strLinea = strLinea + separador;
		}
		strLinea = strLinea.replace(separador + separador, separador + " " + separador);
		strLinea = strLinea.replace(separador + separador, separador + " " + separador);
		String[] string = strLinea.split(separador);
		return string;
	}

	/**
	 * Asigna el tipo de separador que utiliza el archivo
	 * 
	 * @param strLinea
	 *            Linea a analizar
	 * @return Devuelve el separador
	 */
	private String asignarSeparador(String strLinea) {
		String string = "\\|";
		if (strLinea.contains("\\|")) {
			string = "\\|";
		} else if (strLinea.contains(";")) {
			string = ";";
		}
		return string;
	}
}
