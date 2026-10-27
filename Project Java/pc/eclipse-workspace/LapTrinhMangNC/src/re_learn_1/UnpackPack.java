package re_learn_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class UnpackPack {
	public static void pack(String folder, String packedFile) throws IOException {
		List<File> files = new ArrayList<File>();
		List<Long> posDataOfFile = new ArrayList<Long>();
		processFolder(folder, files);
		RandomAccessFile raf = new RandomAccessFile(new File(packedFile), "rw");
		raf.writeInt(files.size());
		// Xu li header
		for (int i = 0; i < files.size(); i++) {
			posDataOfFile.add(raf.getFilePointer());
			long pos = posDataOfFile.get(i);
			long sizeFile = files.get(i).length();
			String nameFile = files.get(i).getName();

			raf.writeLong(pos);
			raf.writeLong(sizeFile);
			raf.writeUTF(nameFile);
		}

		// Xu li data
		for (int i = 0; i < files.size(); i++) {
			long posData = raf.getFilePointer();
			long posHeader = posDataOfFile.get(i);
			raf.seek(posHeader);
			raf.writeLong(posData);
			raf.seek(posData);

			copy(raf, files.get(i));
		}
	}

	private static void copy(RandomAccessFile raf, File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		long counter = file.length();
		int byteMustRead;
		byte[] buff = new byte[102400];
		while (counter > 0) {
			byteMustRead = (int) (counter > buff.length ? buff.length : counter);
			int byteReaded = fis.read(buff, 0, byteMustRead);
			counter -= byteReaded;
			raf.write(buff, 0, byteReaded);
		}
		fis.close();
	}
	
	private static void copy(RandomAccessFile raf, long size, String destFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(destFile);
		long counter = size;
		int byteMustRead;
		byte[] buff = new byte[102400];
		while (counter > 0) {
			byteMustRead = (int) (counter > buff.length ? buff.length : counter);
			int byteReaded = raf.read(buff, 0, byteMustRead);
			counter -= byteReaded;
			fos.write(buff, 0, byteReaded);
		}
		fos.close();
	}

	private static void processFolder(String folder, List<File> files) {
		File folderSrc = new File(folder);
		if (!folderSrc.exists() || folderSrc.isFile())
			return;
		File[] listFile = folderSrc.listFiles();
		for (File tmp : listFile) {
			if (tmp.isFile()) {
				files.add(tmp);
			}
		}

		for (File tmp : listFile) {
			if (tmp.isDirectory()) {
				processFolder(tmp.getAbsolutePath(), files);
			}
		}
	}

	public static void unpack(String packedFile, String extractFile, String destFile) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(packedFile), "r");
		int numFile = raf.readInt();
		for(int i = 0; i< numFile; i++) {
			long pos = raf.readLong();
			long sizeFile = raf.readLong();
			String nameFile = raf.readUTF();
			
			if(nameFile.equalsIgnoreCase(extractFile)) {
				raf.seek(pos);
				copy(raf, sizeFile, destFile); 
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		pack("C:\\Users\\pc\\Downloads\\Newfolder", "C:\\Users\\pc\\Downloads\\Newfolder\\pack.pack");
	unpack("C:\\Users\\pc\\Downloads\\Newfolder\\pack.pack", "text.txt", "C:\\Users\\pc\\Downloads\\Newfolder\\ahihi2.txt");
	}
}
