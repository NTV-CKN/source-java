import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MaHoaBatDoiXung {
	public void genKeyPair(String source) throws IOException, NoSuchAlgorithmException {
		File xx = new File(source);
		if (!xx.exists() || xx.isFile())
			return;
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = generator.generateKeyPair();
		PublicKey pub = keyPair.getPublic();
		PrivateKey priv = keyPair.getPrivate();
		writeFile(pub.getEncoded(), source + "\\public-key.xx");
		writeFile(priv.getEncoded(), source + "\\private-key.xx");
	}

	private void writeFile(byte[] bytes, String source) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(source));
		dos.write(bytes);
		dos.close();
	}

	private byte[] readFileKey(String source) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(source));
		byte[] result = dis.readAllBytes();
		dis.close();
		return result;
	}

	public SecretKey genKey(String name, int keySize) throws NoSuchAlgorithmException {
		KeyGenerator generator = KeyGenerator.getInstance(name);
		generator.init(keySize);
		return generator.generateKey();
	}

	public void encryptFile(String src, String dest, String name, int keySize, String publicKeyPath)
			throws IOException, Exception {
		byte[] ivBytes = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(ivBytes);
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		StringTokenizer st = new StringTokenizer(name, "/");
		SecretKey secretKey = genKey(st.nextToken(), keySize);// secret key chi nhan DES
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(dest));
		dos.writeInt(keySize);
		dos.writeUTF(name);

		PublicKey pubKey = getPublicKeyFromBytes(readFileKey(publicKeyPath));
		Cipher rsa = Cipher.getInstance("RSA");
		rsa.init(Cipher.ENCRYPT_MODE, pubKey);
		String xx = Base64.getEncoder().encodeToString(rsa.doFinal(secretKey.getEncoded()));
		dos.writeUTF(xx);

		dos.writeUTF(Base64.getEncoder().encodeToString(ivSpec.getIV()));
		// xong header

		// ma hoa file
		Cipher maHoaFile = Cipher.getInstance(name);
		maHoaFile.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);// ecb k dung iv
		FileInputStream fis = new FileInputStream(src);
		BufferedInputStream bis = new BufferedInputStream(fis);
		CipherInputStream cis = new CipherInputStream(bis, maHoaFile);
		byte[] buff = new byte[102400];
		int byteReaded;
		while ((byteReaded = cis.read(buff)) != -1) {
			dos.write(buff, 0, byteReaded);
		}
		// ghi xong data
		cis.close();
		dos.close();
		
	}

	public void decryptFile(String src, String dest, String privateKeyPath) throws IOException, Exception {
		PrivateKey privKey = getPrivateKeyFromBytes(readFileKey(privateKeyPath));

		DataInputStream dis = new DataInputStream(new FileInputStream(new File(src)));
		int keySize = dis.readInt();
		String name = dis.readUTF();
		Cipher rsa = Cipher.getInstance("RSA");
		rsa.init(Cipher.DECRYPT_MODE, privKey);
//		String xx = Base64.getEncoder().encodeToString(rsa.doFinal(secretKey.getEncoded()));
//		dos.writeUTF(xx);
		
		byte[] secretKeyBytes = rsa.doFinal(
				Base64.getDecoder().decode(dis.readUTF())
				);
		StringTokenizer st = new StringTokenizer(name, "/");
		SecretKey secretKey = new SecretKeySpec(secretKeyBytes, st.nextToken());
		IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(dis.readUTF()));
		// xong header

		// ma hoa file
		Cipher giaiHoaFile = Cipher.getInstance(name);
		giaiHoaFile.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
		FileOutputStream fos = new FileOutputStream(dest);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		CipherOutputStream cos = new CipherOutputStream(bos, giaiHoaFile);
		byte[] buff = new byte[102400];
		int byteReaded;
		while ((byteReaded = dis.read(buff)) != -1) {
			cos.write(buff, 0, byteReaded);
		}
		// ghi xong data

		cos.close();
		dis.close();
	}

	public PublicKey getPublicKeyFromBytes(byte[] keyBytes) throws Exception {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public PrivateKey getPrivateKeyFromBytes(byte[] keyBytes) throws Exception {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	public static void main(String[] args) throws Exception {
		MaHoaBatDoiXung bdx = new MaHoaBatDoiXung();
//		 bdx.genKeyPair("C:\\Users\\pc\\Downloads");
		bdx.encryptFile("C:\\Users\\pc\\Downloads\\_Ch4 Req Eng.pptx", "C:\\Users\\pc\\Downloads\\encrypt.pptx",
				"DES/CBC/PKCS5Padding", 56, "C:\\Users\\pc\\Downloads\\public-key.xx");

		bdx.decryptFile("C:\\Users\\pc\\Downloads\\encrypt.pptx", "C:\\Users\\pc\\Downloads\\decrypt.pptx",
				"C:\\Users\\pc\\Downloads\\private-key.xx");
	}
}
