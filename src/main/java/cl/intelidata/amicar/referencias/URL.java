package cl.intelidata.amicar.referencias;

import cl.intelidata.amicar.beans.MCrypt;
import cl.intelidata.conf.Configuracion;
import cl.intelidata.amicar.beans.MessageUtils;
import java.util.HashMap;
import java.util.Map.Entry;

public class URL {

	public static final String AMICAR = "http://www.amicar.cl";

	public static String cliente(String strProceso, String strCliente) {
		String respuesta = AMICAR;
		String dominioClick = Configuracion.getInstance().getInitParameter("dominioClick");

		if ((strProceso != null)) {
			try {
				MCrypt mcrypt = new MCrypt();

				HashMap<String, String> params = new java.util.HashMap<String, String>();
				params.put(Texto.CLIENTE, MCrypt.bytesToHex(mcrypt.encrypt(strCliente)));
				params.put(Texto.COTIZACION, MCrypt.bytesToHex(mcrypt.encrypt(strProceso)));

				MessageUtils.info("Generando URL click");
				respuesta = fullURL(dominioClick, params);
			} catch (Exception e) {
				MessageUtils.error("Error URL cliente: " + e.getMessage());
			}
		}
		return respuesta;
	}

	public static String clienteLectura(String strProceso, String strCliente) {
		String respuesta = AMICAR;
		String dominio = Configuracion.getInstance().getInitParameter("dominioLectura");

		if ((strProceso != null)) {
			try {
				MCrypt mcrypt = new MCrypt();

				HashMap<String, String> params = new java.util.HashMap<String, String>();
				params.put(Texto.CLIENTE, MCrypt.bytesToHex(mcrypt.encrypt(strCliente)));
				params.put(Texto.COTIZACION, MCrypt.bytesToHex(mcrypt.encrypt(strProceso)));

				MessageUtils.info("Generando URL lectura");
				respuesta = fullURL(dominio, params);
			} catch (Exception e) {
				MessageUtils.error("Error URL clienteLectura: " + e.getMessage());
			}
		}
		return respuesta;
	}

	public static String fullURL(String urlBase, HashMap<String, String> params) {
		if (!urlBase.endsWith("?")) {
			urlBase = urlBase.concat("?");
		}

		for (Entry<String, String> entry : params.entrySet()) {
			String param = entry.getKey().toString() + "=" + entry.getValue() + "&";
			urlBase = urlBase.concat(param);
		}

		if (urlBase.endsWith("&")) {
			urlBase = urlBase.substring(0, urlBase.length() - 1);
		}

		return urlBase;
	}
}
