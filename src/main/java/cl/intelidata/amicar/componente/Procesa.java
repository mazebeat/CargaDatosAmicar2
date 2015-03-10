package cl.intelidata.amicar.componente;

import cl.intelidata.amicar.bd.*;
import cl.intelidata.amicar.beans.Archivo;
import cl.intelidata.amicar.beans.Datos;
import cl.intelidata.amicar.beans.MessageUtils;
import cl.intelidata.amicar.referencias.Texto;
import cl.intelidata.conf.Configuracion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import cl.intelidata.amicar.db.ConsultasDB;

public class Procesa {

	/*******************************************************************************************************/
	/**
	 * ******************************************* Atributos *********************************************
	 */
	// Log
	private static Logger logger = LoggerFactory.getLogger(Procesa.class);
	/**
	 * ***************************************************************************************************
	 */

	protected String strRutaEntrada;
	protected String strRutaSalida;
	protected String strNombreArchivoEntrada;
	protected boolean esArchivoDiario  = false;
	protected boolean esArchivoMensual = false;
	protected Timestamp fechaActual;
	protected List<Proceso> procesosEnvio = new ArrayList<Proceso>();

	/*******************************************************************************************************/
	/******************************************** Constructores ********************************************/
	/**
	 * ***************************************************************************************************
	 */

	public Procesa(String strRutaEntrada, String strRutaSalida, String strNombreArchivoEntrada) {
		this.strRutaEntrada = strRutaEntrada;
		this.strRutaSalida = strRutaSalida;
		this.strNombreArchivoEntrada = strNombreArchivoEntrada;
	}

	/*******************************************************************************************************/
	/*********************************************** Metodos ***********************************************/
	/**
	 * ***************************************************************************************************
	 */

	public void cargaData() {
		Archivo archivo = new Archivo(this.strRutaEntrada, this.strRutaSalida);
		System.out.println("Leyendo el archivo " + this.strNombreArchivoEntrada);
		List<String> datos = archivo.leer(this.strNombreArchivoEntrada, null);
		this.fijarTipoArchivo(archivo.getStrPrimeraLinea());
		if (this.esArchivoDiario) {
			this.cargarArchivoDiario(datos);
		} else if (this.esArchivoMensual) {
			this.cargarArchivoMensual(datos);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void cargarArchivoMensual(List<String> datos) {
		try {
			MessageUtils.info("Procesando archivo mensual...");
			for (String s : datos) {
				if (this.lineaValida(s, false)) {
					MessageUtils.info("Procesando: " + s);
					this.setFechaActual();
					Datos dato = new Datos(s);
					// Local
					Locales local = this.crearLocal(dato.extraer(Texto.A_M_LOCAL));
					// Ejecutivos
					this.crearEjecutivo(dato, local);
				}
			}
			MessageUtils.info("Archivo mensual procesado con exito...");
			System.out.println("**********************************************************************************************");
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void cargarArchivoDiario(List<String> datos) {
		try {
			MessageUtils.info("Procesando archivo diario...");
			for (String s : datos) {
				if (this.lineaValida(s, true)) {
//					System.out.println("Procesando: " + s);
					Datos dato = new Datos(s);
					Clientesdiario clienteDiario = this.crearClienteDiario(dato);
					Vendedores vendedor = this.crearVendedor(dato);
				}
			}

			EntityManagerFactory factory;
			factory = Persistence.createEntityManagerFactory("CargaDatosAmicar2");
			EntityManager em = factory.createEntityManager();
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("ADD_BODY_MAIL_AMICAR");
			storedProcedure.execute();

			for (String s : datos) {
				if (this.lineaValida(s, true)) {
					MessageUtils.info("Procesando: " + s);
					Datos dato = new Datos(s);
					Clientesdiario clienteDiario = this.crearClienteDiario(dato);
					Vendedores vendedor = this.crearVendedor(dato);
					if (this.existeLocal(dato.extraer(Texto.A_D_NOMBRE_LOCAL))) {
						this.asignarProceso(clienteDiario, vendedor);
					}
				}
			}

			MessageUtils.info("Archivo diario procesado con exito...");
			System.out.println("**********************************************************************************************");
			MessageUtils.info("Generando archivo emmesaging...");
			Mail mails = new Mail(Configuracion.getInstance().getInitParameter("SalidaEmmesaging"));
			mails.clientes(this.procesosEnvio);
			MessageUtils.info("Archivo emmesaging generado existosamente...");

		} catch (Exception e) {
			this.error(e);
		}
	}

	/*******************************************************************************************************/

	/**
	 * Verifica el tipo de archivo que se esta manipulando, segun la primera
	 * linea de este
	 *
	 * @param strPrimeraLinea Primera linea del archivo.
	 */
	private void fijarTipoArchivo(String strPrimeraLinea) {
		try {
			if (strPrimeraLinea.toLowerCase().equals(
					Texto.CABECERA_ARCHIVO_DIARIO.toLowerCase()
			)) {
				this.esArchivoDiario = true;
			} else if (strPrimeraLinea.toLowerCase().equals(
					Texto.CABECERA_ARCHIVO_MENSUAL.toLowerCase()
			)) {
				this.esArchivoMensual = true;
			} else {
				MessageUtils.error("El archivo ingresado no es valido.");
				System.exit(1);
			}
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void guardarLocal(Locales local) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveLocal(local);
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void guardarEjecutivo(Ejecutivos ejecutivo) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveEjecutivo(ejecutivo);
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void guardarCliente(Clientesdiario clienteDiario) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveCliente(clienteDiario);
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void guardarVendedor(Vendedores vendedor) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveVendedor(vendedor);
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private void asignarProceso(Clientesdiario clienteDiario, Vendedores vendedor) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			Proceso proceso = new Proceso();
			this.setFechaActual();
			Ejecutivos ejecutivo = consultasDB.buscarEjecutivoVigentePorLocal(vendedor.getLocales().getNombreLocal());
			proceso.setClientesdiario(clienteDiario);
			proceso.setVendedores(vendedor);
			proceso.setFechaEnvio(this.fechaActual);
			if (ejecutivo != null) {
				proceso.setEjecutivos(ejecutivo);
				consultasDB.saveProceso(proceso);
				this.procesosEnvio.add(proceso);
				MessageUtils.info("Mail id: " + proceso.getIdProceso() + " cliente id: " + proceso.getClientesdiario().getRutCliente() + " ejecutivo id: " + proceso.getEjecutivos().getIdEjecutivo() + "  vendedor id: " + proceso.getVendedores().getIdVendedor() + " fecha envio: " + proceso.getFechaEnvio());
			}
		} catch (Exception e) {
			this.error(e);
			MessageUtils.info("Error al enviar el email\n Causado por:\n" + e.getMessage());
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private Locales crearLocal(String strLocal) {
		Locales local = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			local = consultasDB.buscarLocalPorDescripcion(strLocal);
			if (local == null) {
				local = new Locales();
				local.setNombreLocal(strLocal);
				this.guardarLocal(local);
			}

		} catch (Exception e) {
			this.error(e);
		}

		return local;
	}

	/**
	 * ***************************************************************************************************
	 */

	private void crearEjecutivo(Datos dato, Locales local) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			Ejecutivos ejecutivo = consultasDB.buscarEjecutivoPorEmail(
					dato.extraer(Texto.A_M_CORREO_EJECUTIVO)
			);
			if (ejecutivo == null) {
				ejecutivo = new Ejecutivos();
				ejecutivo.setNombreEjecutivo(dato.extraer(Texto.A_M_EJECUTIVO));
				ejecutivo.setCorreoEjecutivo(
						dato.extraer(Texto.A_M_CORREO_EJECUTIVO)
				);
				ejecutivo.setLocales(local);
				ejecutivo.setFechaIngreso(this.fechaActual);
				this.guardarEjecutivo(ejecutivo);
			}
		} catch (Exception e) {
			this.error(e);
		}
	}

	/**
	 * ***************************************************************************************************
	 */

	private Clientesdiario crearClienteDiario(Datos dato) {
		Clientesdiario clienteDiario = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			clienteDiario = consultasDB.buscarClientePorRut(
					dato.extraer(Texto.A_D_RUT_CLIENTE)
			);
			if (clienteDiario == null) {
				clienteDiario = new Clientesdiario();
				clienteDiario.setRutCliente(dato.extraer(Texto.A_D_RUT_CLIENTE));
				clienteDiario.setEmailCliente(
						dato.extraer(Texto.A_D_CORREO_CLIENTE)
				);
				clienteDiario.setNombreCliente(
						dato.extraer(Texto.A_D_NOMBRE_CLIENTE)
				);
				clienteDiario.setSexoCliente(
						dato.extraer(Texto.A_D_SEXO_CLIENTE)
				);
				clienteDiario.setFonoCliente(
						dato.extraer(Texto.A_D_FONO_CLIENTE)
				);
				clienteDiario.setAutomovilCliente(
						dato.extraer(Texto.A_D_AUTOMOVIL_CLIENTE)
				);
				clienteDiario.setIdGrupo(null);
				clienteDiario.setIdBody(null);
				clienteDiario.setFecha(fechaActual);
				clienteDiario.setNombreJrn(this.strNombreArchivoEntrada);
				this.guardarCliente(clienteDiario);
			}
		} catch (Exception e) {
			this.error(e);
		}
		return clienteDiario;
	}

	/**
	 * ***************************************************************************************************
	 */

	private Vendedores crearVendedor(Datos dato) {
		Vendedores vendedor = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			vendedor = consultasDB.buscarVendedorPorRut(
					dato.extraer(Texto.A_D_RUT_VENDEDOR)
			);
			if (vendedor == null) {
				vendedor = new Vendedores();
				vendedor.setNombreVendedor(
						dato.extraer(Texto.A_D_NOMBRE_VENDEDOR)
				);
				vendedor.setRutVendedor(dato.extraer(Texto.A_D_RUT_VENDEDOR));
				vendedor.setLocales(
						this.crearLocal(
								dato.extraer(Texto.A_D_NOMBRE_LOCAL)
						)
				);
				this.guardarVendedor(vendedor);
			}
		} catch (Exception e) {
			this.error(e);
		}
		return vendedor;
	}

	/**
	 * ***************************************************************************************************
	 */
	private boolean existeLocal(String strLocal) {
		boolean respuesta = false;
		ConsultasDB consultasDB = new ConsultasDB();
		Locales local = consultasDB.buscarLocalPorDescripcion(strLocal);
		if (local != null) {
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * ***************************************************************************************************
	 */
	private boolean lineaValida(String strLinea, boolean esDiario) {
		boolean respuesta = false;
		Datos datos = new Datos(strLinea);
		String s = "";
		if (esDiario) {
			s = datos.extraer(Texto.A_D_CORREO_CLIENTE);
		} else {
			s = datos.extraer(Texto.A_M_CORREO_EJECUTIVO);
		}
		if (s.contains("@") && s.contains(".") && (s.length() > 8)) {
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * ***************************************************************************************************
	 */

	private void error(Exception e) {
		MessageUtils.error(e.getMessage());
		System.exit(1);
	}

	/**
	 * ***************************************************************************************************
	 */

	private void setFechaActual() {
		Date date = new Date();
		this.fechaActual = new Timestamp(date.getTime());
	}
	/*******************************************************************************************************/

}
