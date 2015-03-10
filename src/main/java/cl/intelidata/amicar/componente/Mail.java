package cl.intelidata.amicar.componente;

import cl.intelidata.amicar.bd.Proceso;
import cl.intelidata.amicar.beans.Archivo;
import cl.intelidata.amicar.beans.MessageUtils;
import cl.intelidata.amicar.referencias.Texto;
import cl.intelidata.amicar.referencias.URL;

import java.util.ArrayList;
import java.util.List;

public class Mail {
	/*******************************************************************************************************/
	/********************************************** Atributos **********************************************/
	/**
	 * ***************************************************************************************************
	 */

	private String rutaSalida;

	/*******************************************************************************************************/
	/******************************************** Constructores ********************************************/
	/**
	 * ***************************************************************************************************
	 */

	public Mail(String rutaSalida) {
		this.setRutaSalida(rutaSalida);
	}

	/*******************************************************************************************************/
	/*********************************************** Metodos ***********************************************/
	/**
	 * ***************************************************************************************************
	 */

	public void clientes(List<Proceso> procesos) {
		List<String> lista = new ArrayList<String>();
		for (Proceso p : procesos) {
			lista.add(procesaLinea(p));
		}
		this.guardarArchivoMail(lista);
	}

	/**
	 * ***************************************************************************************************
	 */

	private void guardarArchivoMail(List<String> lista) {
		Archivo archivo = new Archivo(this.getRutaSalida());
		archivo.guardarLista(lista, "Clientes", "txt");
	}

	/**
	 * ***************************************************************************************************
	 */

	private String procesaLinea(Proceso proceso) {
		String linea = "";
		MessageUtils.info("ID Proceso: " + proceso.getIdProceso().toString());
		linea = Texto.LLAVE_INICIO + "|" + proceso.getClientesdiario().getEmailCliente() + "|" + proceso.getClientesdiario().getRutCliente() + "|" + URL.cliente(proceso.getIdProceso().toString(), String.valueOf(proceso.getClientesdiario().getIdCliente())) + "|" + proceso.getFechaEnvio() + "|" + URL.clienteLectura(proceso.getIdProceso().toString(), String.valueOf(proceso.getClientesdiario().getIdCliente())) + "|";
		return linea;
	}

	/*******************************************************************************************************/
	/****************************************** Getters y Setters ******************************************/
	/**
	 * ***************************************************************************************************
	 */

	public String getRutaSalida() {
		return rutaSalida;
	}

	public void setRutaSalida(String rutaSalida) {
		this.rutaSalida = rutaSalida;
	}

}
