package cl.intelidata.amicar.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class ConsultasDB {

	public ConsultasDB() {

	}

	/*******************************************************************************************************/
	/************************************* Metodos de Consulta *********************************************/
	/*******************************************************************************************************/

	public Proceso procesoActivo(int iProcesoID) {
		Proceso proceso = new Proceso();
		try {
			ProcesoDAO procesoDao = new ProcesoDAO();
			proceso = procesoDao.findById(iProcesoID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return proceso;
	}

	/*******************************************************************************************************/

	public void updateProceso(Proceso proceso) {
		try {
			ProcesoDAO procesoDAO = new ProcesoDAO();
			EntityManagerHelper.beginTransaction();
			procesoDAO.update(proceso);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	public void saveProceso(Proceso proceso) {
		try {
			ProcesoDAO procesoDAO = new ProcesoDAO();
			EntityManagerHelper.beginTransaction();
			procesoDAO.save(proceso);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/

	public void saveLocal(Locales local) {
		try {
			LocalesDAO localesDAO = new LocalesDAO();
			EntityManagerHelper.beginTransaction();
			localesDAO.save(local);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/*******************************************************************************************************/

	public Locales buscarLocalPorDescripcion(String strDescripcion) {
		Locales local = null;
		try {
			LocalesDAO localesDAO = new LocalesDAO();
			List<Locales> locales = localesDAO
					.findByNombreLocal(strDescripcion);
			for (Locales l : locales) {
				local = l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return local;
	}

	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/

	public void saveEjecutivo(Ejecutivos ejecutivo) {
		try {
			EjecutivosDAO ejecutivosDAO = new EjecutivosDAO();
			EntityManagerHelper.beginTransaction();
			ejecutivosDAO.save(ejecutivo);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	public void updateEjecutivo(Ejecutivos ejecutivo) {
		try {
			EjecutivosDAO ejecutivosDAO = new EjecutivosDAO();
			EntityManagerHelper.beginTransaction();
			ejecutivosDAO.update(ejecutivo);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	public Ejecutivos buscarEjecutivoPorEmail(String strDescripcion) {
		Ejecutivos ejecutivo = null;
		try {
			EjecutivosDAO ejecutivosDAO = new EjecutivosDAO();
			List<Ejecutivos> ejecutivos = ejecutivosDAO
					.findByCorreoEjecutivo(strDescripcion);
			for (Ejecutivos e : ejecutivos) {
				ejecutivo = e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return ejecutivo;
	}

	@SuppressWarnings("unchecked")
	public Ejecutivos buscarEjecutivoVigentePorLocal(String strDescripcion) {
		Ejecutivos ejecutivo = null;
		try {
			List<Ejecutivos> ejecutivos = new ArrayList<Ejecutivos>();
			Query query = EntityManagerHelper
					.createQuery("SELECT e FROM Ejecutivos e WHERE e.locales.nombreLocal = :strLocal");
			query.setParameter("strLocal", strDescripcion);
			ejecutivos = query.getResultList();
			for (Ejecutivos e : ejecutivos) {
				ejecutivo = e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return ejecutivo;
	}

	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/

	public void saveCliente(Clientesdiario clienteDiario) {
		try {
			ClientesdiarioDAO clientesDiarioDAO = new ClientesdiarioDAO();
			EntityManagerHelper.beginTransaction();
			clientesDiarioDAO.save(clienteDiario);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	public Clientesdiario buscarClientePorRut(String strDescripcion) {
		Clientesdiario clienteDiario = null;
		try {
			ClientesdiarioDAO clientesDiarioDAO = new ClientesdiarioDAO();
			List<Clientesdiario> clientesDiario = clientesDiarioDAO
					.findByRutCliente(strDescripcion);
			for (Clientesdiario c : clientesDiario) {
				clienteDiario = c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return clienteDiario;
	}

	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/

	public void saveVendedor(Vendedores vendedor) {
		try {
			VendedoresDAO vendedoresDAO = new VendedoresDAO();
			EntityManagerHelper.beginTransaction();
			vendedoresDAO.save(vendedor);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Vendedores buscarVendedorPorRut(String strDescripcion) {
		Vendedores vendedor = null;
		try {
			VendedoresDAO vendedoresDAO = new VendedoresDAO();
			List<Vendedores> vendedores = vendedoresDAO
					.findByRutVendedor(strDescripcion);
			for (Vendedores v : vendedores) {
				vendedor = v;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return vendedor;
	}

}
