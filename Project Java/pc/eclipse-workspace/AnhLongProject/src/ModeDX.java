import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class ModeDX {
	public static class DES {
		private SecretKey key;

		public SecretKey genKey() throws NoSuchAlgorithmException {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(56);
			key = generator.generateKey();

			return key;
		}

		public void loadKey(SecretKey key) {
			this.key = key;
		}

		public String encryptString(String text) throws NoSuchAlgorithmException, NoSuchPaddingException,
				IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] textToBytes = text.getBytes(StandardCharsets.UTF_8);
			byte[] textC = cipher.doFinal(textToBytes);

			return Base64.getEncoder().encodeToString(textC);
		}

		public String decryptString(String text) throws InvalidKeyException, NoSuchAlgorithmException,
				NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] bytesC = Base64.getDecoder().decode(text);
			byte[] bytesP = cipher.doFinal(bytesC);

			return new String(bytesP, StandardCharsets.UTF_8);
		}

		public void encryptFile(String src, String dest)
				throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
			File srcTmp = new File(src);
			if (!srcTmp.exists() || srcTmp.isDirectory())
				return;

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			FileInputStream fis = new FileInputStream(srcTmp);
			FileOutputStream fos = new FileOutputStream(dest);

			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherInputStream cis = new CipherInputStream(bis, cipher);
			int byteReaded;
			byte[] buff = new byte[102400];
			while ((byteReaded = cis.read(buff)) != -1) {
				fos.write(buff, 0, byteReaded);
			}
			cis.close();
			bis.close();
			fis.close();
			fos.close();
		}

		public void decryptFile(String src, String dest)
				throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
			File srcTmp = new File(src);
			if (!srcTmp.exists() || srcTmp.isDirectory())
				return;
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			FileInputStream fis = new FileInputStream(srcTmp);
			FileOutputStream fos = new FileOutputStream(dest);
			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);

			int byteReaded;
			byte[] buff = new byte[102400];
			while ((byteReaded = fis.read(buff)) != -1) {
				cos.write(buff, 0, byteReaded);
			}
			cos.close();
			bis.close();
			fis.close();
			fos.close();
		}
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		String data = "Không còn là tuyến đường tự do, eo biển Hormuz giờ đây chỉ mở cửa "
				+ "Kể từ khi xung đột Iran bùng nổ cuối tháng 2, lưu lượng giao thông...";
		DES des = new DES();
		des.genKey();
		String cipher = des.encryptString(data);
		String plaintext = des.decryptString(cipher);
		System.out.println(cipher);
		System.out.println(plaintext);
		System.out.println("==================================================");
		des.encryptFile("C:\\Users\\pc\\Downloads\\My Documents [22-04-2026 18_05].zip",
				"C:\\Users\\pc\\Downloads\\encrypt.zip");
		
		des.decryptFile("C:\\Users\\pc\\Downloads\\encrypt.zip",
				"C:\\Users\\pc\\Downloads\\decrypt.zip");
	}
}
