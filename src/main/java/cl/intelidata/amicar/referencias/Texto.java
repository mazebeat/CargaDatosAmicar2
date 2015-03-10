package cl.intelidata.amicar.referencias;

public class Texto {
	// Cabeceras
	public static final String CABECERA_ARCHIVO_DIARIO  = "RUT_CLIENTE|EMAIL_CLIENTE|NOMBRE_CLIENTE|SEXO_CLIENTE|FONO_CLIENTE|AUTOMOVIL_CLIENTE|NOMBRE_LOCAL|NOMBRE_VENDEDOR|RUT_VENDEDOR";
	public static final String CABECERA_ARCHIVO_MENSUAL = "LOCAL|EJECUTIVO|CORREO";

	// Posiciones de los datos Mensuales
	public static final int A_M_LOCAL            = 0;
	public static final int A_M_EJECUTIVO        = 1;
	public static final int A_M_CORREO_EJECUTIVO = 2;

	// Posiciones de los datos Diarios
	public static final int A_D_RUT_CLIENTE       = 0;
	public static final int A_D_CORREO_CLIENTE    = 1;
	public static final int A_D_NOMBRE_CLIENTE    = 2;
	public static final int A_D_SEXO_CLIENTE      = 3;
	public static final int A_D_FONO_CLIENTE      = 4;
	public static final int A_D_AUTOMOVIL_CLIENTE = 5;
	public static final int A_D_NOMBRE_LOCAL      = 6;
	public static final int A_D_NOMBRE_VENDEDOR   = 7;
	public static final int A_D_RUT_VENDEDOR      = 8;

	// Mails
	public static final String COTIZACION   = "cotizacion";
	public static final String CLIENTE      = "cliente";
	public static final String CAMPANA      = "campana";
	public static final String LLAVE_INICIO = "001";
	public static final String LLAVE        = "amicarCotizantes";

	/**
	 *  MCrypt params Encrypt/Decrypt
	 */
	public static final String KEY = "amicarCotizantes";
	public static final String IV  = "a1m2i3c4a5r6C7o8";

	//	LOG4J
	public final static String LOG_PROPERTIES_FILE = "resources/log4j.properties";
}
