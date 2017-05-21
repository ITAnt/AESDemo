import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AESDecrypt {

	public static void main(String[] args) {
		String data = "c4o7Cuzz/uDZ2nQnv1LB+w==";

		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		String key1 = "1234567812345678";
		byte[] key2 = key1.getBytes();
		SecretKeySpec secret = new SecretKeySpec(key2, "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secret, ivspec);
			byte[] encrypted = DatatypeConverter.parseBase64Binary(data);
			byte[] decrypted = cipher.doFinal(encrypted);

			System.out.println("Decrypted Info: "
					+ new String(decrypted, StandardCharsets.UTF_8));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}