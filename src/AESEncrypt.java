import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AESEncrypt {

	public static void main(String[] args) {
		String msg = "hahaha";
		String key1 = "1234567812345678";
		byte[] key2 = key1.getBytes();
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		SecretKeySpec secret = new SecretKeySpec(key2, "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);
			byte[] encrypted = cipher.doFinal(msg
					.getBytes(StandardCharsets.UTF_8));
			String text = DatatypeConverter.printBase64Binary(encrypted);
			System.out.println("Encrypted info: " + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}