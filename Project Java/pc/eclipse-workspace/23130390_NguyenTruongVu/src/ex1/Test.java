package ex1;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String pathNameFrom = "D:\\esclipse\\Project Java\\pc\\eclipse-workspace"
				+ "\\23130390_NguyenTruongVu\\src\\ex1\\text";
		String pathNameEncrypt = "D:\\esclipse\\Project Java\\pc\\eclipse-workspace"
				+ "\\23130390_NguyenTruongVu\\src\\ex1\\text_encrypted";
		String pathNameDecrypt = "D:\\esclipse\\Project Java\\pc\\eclipse-workspace"
				+ "\\23130390_NguyenTruongVu\\src\\ex1\\text_decrypted";
		CryptFile.encryptFile(pathNameFrom, pathNameEncrypt, 3, true);
		CryptFile.encryptFile(pathNameEncrypt, pathNameDecrypt, 3, false);
	}
}
