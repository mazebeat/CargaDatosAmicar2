package cl.intelidata.amicar.beans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

// import sun.misc.BASE64Encoder;

public class Cifrador {

	private static byte[] SALT_BYTES = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };

	private static int ITERATION_COUNT = 19;

	public static String encriptar(String strProceso) {
		String encrypted = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = strProceso.getBytes();

            digest.reset();
            digest.update(passwordBytes);
            byte[] message = digest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < message.length; i++) {
                hexString.append(Integer.toHexString(
                        0xFF & message[i]));
            }
            encrypted = hexString.toString();
        }
        catch (Exception e) {
        }
        return encrypted;
	}

	public static String desencriptar(String passPhrase, String str) {
		Cipher dcipher = null;

		try {
			// Crear la key
			KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			dcipher = Cipher.getInstance(key.getAlgorithm());

			// Preparar los parametros para los ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);

			// Crear los ciphers
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			// Decodear base64 y obtener bytes
			// byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			byte[] dec = Base64.decodeBase64(str);

			// Desencriptar
			byte[] utf8 = dcipher.doFinal(dec);

			// Decodear usando utf-8
			return new String(utf8, "UTF8");

		} catch (Exception e) {
			return null;
		}
	}

	public static String cif(String text) throws UnsupportedEncodingException {
		String enc = Cifrador.encriptar( text);
		// Se codifica para url
		enc = URLEncoder.encode(enc, "UTF-8");
		return enc;
	}

	public static void main(String args[]) throws IOException {

		// Se encripa cadena con datos delimitados por coma
		String id = "14220";
		System.out.println("id " + id + ": " + cif(id));

	}


}