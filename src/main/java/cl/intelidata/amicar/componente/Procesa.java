package cl.intelidata.amicar.componente;

import static cl.intelidata.amicar.conf.Configuracion.logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import cl.intelidata.amicar.bd.Clientesdiario;
import cl.intelidata.amicar.bd.Ejecutivos;
import cl.intelidata.amicar.bd.Locales;
import cl.intelidata.amicar.bd.Proceso;
import cl.intelidata.amicar.bd.Vendedores;
import cl.intelidata.amicar.beans.Archivo;
import cl.intelidata.amicar.beans.ConsultasDB;
import cl.intelidata.amicar.beans.Datos;
import cl.intelidata.amicar.conf.Configuracion;
import cl.intelidata.amicar.conf.EntityHelper;
import cl.intelidata.amicar.referencias.Texto;

public class Procesa {

	protected String strRutaEntrada;
	protected String strRutaSalida;
	protected String strNombreArchivoEntrada;
	protected boolean esArchivoDiario = false;
	protected boolean esArchivoMensual = false;
	protected Timestamp fechaActual;
	protected List<Proceso> procesosEnvio = new ArrayList<Proceso>();

	// public static Logger logger =
	// LoggerFactory.getLogger(Configuracion.class);

	public Procesa(String strRutaEntrada, String strRutaSalida,
			String strNombreArchivoEntrada) {
		this.strRutaEntrada = strRutaEntrada;
		this.strRutaSalida = strRutaSalida;
		this.strNombreArchivoEntrada = strNombreArchivoEntrada;		
	}

	public void cargaData() {
		Archivo archivo = new Archivo(this.strRutaEntrada, this.strRutaSalida);
		logger.info("Leyendo el archivo " + this.strNombreArchivoEntrada);
		List<String> datos = archivo.leer(this.strNombreArchivoEntrada, null);
		this.fijarTipoArchivo(archivo.getStrPrimeraLinea());
		if (this.esArchivoDiario) {
			this.cargarArchivoDiario(datos);
		} else if (this.esArchivoMensual) {
			this.cargarArchivoMensual(datos);
		}
	}

	private void cargarArchivoMensual(List<String> datos) {
		try {
			logger.info("Procesando archivo mensual...");
			for (String s : datos) {
				if (this.lineaValida(s, false)) {
					logger.info("Procesando: " + s);
					this.setFechaActual();
					Datos dato = new Datos(s);
					// Local
					Locales local = this.crearLocal(dato
							.extraer(Texto.A_M_LOCAL));
					// Ejecutivos
					this.crearEjecutivo(dato, local);
				}
			}
			logger.info("Archivo mensual procesado con exito...");
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void cargarArchivoDiario(List<String> datos) {
		try {
			logger.info("Procesando archivo diario...");
			for (String s : datos) {
				if (this.lineaValida(s, true)) {
					logger.info("Procesando: " + s);
					Datos dato = new Datos(s);
					Clientesdiario clienteDiario = this
							.crearClienteDiario(dato);
					Vendedores vendedor = this.crearVendedor(dato);
				}
			}

			EntityManager em = null;
			try {
				em = EntityHelper.getInstance().getEntityManager();
				StoredProcedureQuery storedProcedure = em
						.createStoredProcedureQuery("ADD_BODY_MAIL_AMICAR");
				storedProcedure.execute();
			} catch (Exception e) {
				throw new Exception("Error en consulta ", e);
			} finally {
				if (em != null && em.isOpen()) {
					if (em.getTransaction().isActive()) {
						em.getTransaction().rollback();
					}
					em.close();
				}
			}

			for (String s : datos) {
				if (this.lineaValida(s, true)) {
					logger.info("Procesando: " + s);
					Datos dato = new Datos(s);
					Clientesdiario clienteDiario = this
							.crearClienteDiario(dato);
					Vendedores vendedor = this.crearVendedor(dato);
					if (this.existeLocal(dato.extraer(Texto.A_D_NOMBRE_LOCAL))) {
						this.asignarProceso(clienteDiario, vendedor);
					}
				}
			}

			logger.info("Archivo diario procesado con exito...");
			logger.info("Generando archivo emmesaging...");
			
//			Mail mails = new Mail(Configuracion.getInstance().getInitParameter("salidaemmesaging"));
			Mail mails = new Mail(this.strRutaSalida);
			mails.clientes(this.procesosEnvio);
			logger.info("Archivo emmesaging generado existosamente...");

		} catch (Exception e) {
			this.error(e);
		}
	}

	private void fijarTipoArchivo(String strPrimeraLinea) {
		try {
			if (strPrimeraLinea.toLowerCase().equals(
					Texto.CABECERA_ARCHIVO_DIARIO.toLowerCase())) {
				this.esArchivoDiario = true;
			} else if (strPrimeraLinea.toLowerCase().equals(
					Texto.CABECERA_ARCHIVO_MENSUAL.toLowerCase())) {
				this.esArchivoMensual = true;
			} else {
				logger.info("El archivo ingresado no es valido.");
				System.exit(1);
			}
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void guardarLocal(Locales local) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveLocal(local);
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void guardarEjecutivo(Ejecutivos ejecutivo) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveEjecutivo(ejecutivo);
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void guardarCliente(Clientesdiario clienteDiario) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveCliente(clienteDiario);
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void guardarVendedor(Vendedores vendedor) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			consultasDB.saveVendedor(vendedor);
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void asignarProceso(Clientesdiario clienteDiario,
			Vendedores vendedor) {
		try {
			this.setFechaActual();
			ConsultasDB consultasDB = new ConsultasDB();
			Proceso proceso = new Proceso();
			proceso.setClientesdiario(clienteDiario);
			proceso.setVendedores(vendedor);
			proceso.setFechaEnvio(this.fechaActual);
			Ejecutivos ejecutivo = consultasDB.buscarEjecutivoVigentePorLocal(vendedor.getLocales().getNombreLocal());
			if (ejecutivo != null) {
				proceso.setEjecutivos(ejecutivo);
				consultasDB.saveProceso(proceso);
				this.procesosEnvio.add(proceso);
				logger.info("Mail id: " + proceso.getIdProceso()
						+ " cliente id: "
						+ proceso.getClientesdiario().getRutCliente()
						+ " ejecutivo id: "
						+ proceso.getEjecutivos().getIdEjecutivo()
						+ "  vendedor id: "
						+ proceso.getVendedores().getIdVendedor()
						+ " fecha envio: " + proceso.getFechaEnvio());
			} else {
				logger.info("Ejecutivo no encontrado.");
			}
		} catch (Exception e) {
			logger.info("Error al enviar el email\n Causado por: {}", e.getMessage());
		}
	}

	private Locales crearLocal(String strLocal) {
		Locales local = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			local = consultasDB.buscarLocalPorDescripcion(strLocal);
			if (local == null) {
				local = new Locales();
				local.setNombreLocal(strLocal);
				this.guardarLocal(local);
			} else {
				logger.info("Local encontrado: {}", local.getIdLocal());
			}

		} catch (Exception e) {
			this.error(e);
		}

		return local;
	}

	private void crearEjecutivo(Datos dato, Locales local) {
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			Ejecutivos ejecutivo = consultasDB.buscarEjecutivoPorEmail(dato
					.extraer(Texto.A_M_CORREO_EJECUTIVO));
			if (ejecutivo == null) {
				ejecutivo = new Ejecutivos();
				ejecutivo.setNombreEjecutivo(dato.extraer(Texto.A_M_EJECUTIVO));
				ejecutivo.setCorreoEjecutivo(dato
						.extraer(Texto.A_M_CORREO_EJECUTIVO));
				ejecutivo.setLocales(local);
				ejecutivo.setFechaIngreso(this.fechaActual);
				this.guardarEjecutivo(ejecutivo);
			} else {
				logger.info("Ejecutivo encontrado: {}",
						ejecutivo.getIdEjecutivo());
			}
		} catch (Exception e) {
			this.error(e);
		}
	}

	private Clientesdiario crearClienteDiario(Datos dato) {
		Clientesdiario clienteDiario = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			String rut = dato.extraer(Texto.A_D_RUT_CLIENTE);
			clienteDiario = consultasDB.getClienteD(rut);

			if (clienteDiario == null) {
				logger.info("Creando nuevo Cliente Diario");
				clienteDiario = new Clientesdiario();
				clienteDiario
						.setRutCliente(dato.extraer(Texto.A_D_RUT_CLIENTE));
				clienteDiario.setEmailCliente(dato
						.extraer(Texto.A_D_CORREO_CLIENTE));
				clienteDiario.setNombreCliente(dato
						.extraer(Texto.A_D_NOMBRE_CLIENTE));
				clienteDiario.setFonoCelular(dato
						.extraer(Texto.A_D_FONO_CELULAR));
				clienteDiario.setFonoComercial(dato
						.extraer(Texto.A_D_FONO_COMERCIAL));
				clienteDiario.setFonoParticular(dato
						.extraer(Texto.A_D_FONO_PARTICULAR));
				clienteDiario.setMarcaAuto(dato
						.extraer(Texto.A_D_MARCA_VEHICULO));
				clienteDiario.setModeloAuto(dato
						.extraer(Texto.A_D_MODELO_VEHICULO));
				clienteDiario.setValorAuto(dato
						.extraer(Texto.A_D_VALOR_VEHICULO));
				clienteDiario.setIdGrupo(null);
				clienteDiario.setIdBody(null);
				clienteDiario.setFecha(fechaActual);
				clienteDiario.setNombreJrn(this.strNombreArchivoEntrada);
				this.guardarCliente(clienteDiario);
			} else {
				logger.info("Cliente Diario encontrado: {}",
						clienteDiario.getIdCliente());
			}
		} catch (Exception e) {
			this.error(e);
		}
		return clienteDiario;
	}

	private Vendedores crearVendedor(Datos dato) {
		Vendedores vendedor = null;
		try {
			ConsultasDB consultasDB = new ConsultasDB();
			vendedor = consultasDB.buscarVendedorPorRut(dato
					.extraer(Texto.A_D_RUT_VENDEDOR));
			if (vendedor == null) {
				vendedor = new Vendedores();
				vendedor.setNombreVendedor(dato
						.extraer(Texto.A_D_NOMBRE_VENDEDOR));
				vendedor.setRutVendedor(dato.extraer(Texto.A_D_RUT_VENDEDOR));
				vendedor.setLocales(this.crearLocal(dato
						.extraer(Texto.A_D_NOMBRE_LOCAL)));
				this.guardarVendedor(vendedor);
			} else {
				logger.info("Vendedor encontrado: {}",
						vendedor.getIdVendedor());
			}
		} catch (Exception e) {
			this.error(e);
		}
		return vendedor;
	}

	private boolean existeLocal(String strLocal) {
		boolean respuesta = false;
		ConsultasDB consultasDB = new ConsultasDB();
		Locales local = consultasDB.buscarLocalPorDescripcion(strLocal);
		if (local != null) {
			respuesta = true;
		} else {
			logger.info("El local ya existe: {}", strLocal);
		}
		return respuesta;
	}

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

	private void error(Exception e) {
		logger.error("Error: {}", e);
		System.exit(1);
	}

	private void setFechaActual() {
		Date date = new Date();
		this.fechaActual = new Timestamp(date.getTime());
	}

}
