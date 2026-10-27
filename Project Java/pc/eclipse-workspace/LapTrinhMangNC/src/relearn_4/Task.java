package relearn_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Task {
	public static void pack(String folder, String packedFile) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(packedFile, "rw");
		List<Long> posHeader = new ArrayList<Long>();
		File folderS = new File(folder);
		File[] files = folderS.listFiles();
		if (files == null)
			return;
		raf.writeInt(0);

		// duyet lan 1(ghi header)
		for (File file : files) {
			if (file.isFile()) {
				posHeader.add(raf.getFilePointer());
				raf.writeLong(0);
				raf.writeLong(file.length());
				raf.writeUTF(file.getName());
			}
		}
		int index = 0;
		// duyet lan 2 (ghi data)
		for (File file : files) {
			if (file.isFile()) {
				FileInputStream fis = new FileInputStream(file);
				long posData = raf.getFilePointer();
				raf.seek(posHeader.get(index));
				raf.writeLong(posData);
				long lenFile = raf.readLong();
				raf.seek(posData);
				copy(raf, file, lenFile);

				index++;
				fis.close();
			}
		}

		raf.seek(0);
		raf.writeInt(posHeader.size());
		raf.close();
	}

	private static void copy(RandomAccessFile raf, File file, long lenFile) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		long counter = lenFile;
		int byteMustRead;
		byte[] bff = new byte[102400];
		while (counter > 0) {
			byteMustRead = (int) (bff.length > counter ? counter : bff.length);
			int byteReaded = fis.read(bff, 0, byteMustRead);
			counter -= byteReaded;
			raf.write(bff, 0, byteReaded);
		}
		fis.close();
	}
	
	private static void copy(RandomAccessFile raf, long lenFile, String destFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(destFile);
		long counter = lenFile;
		int byteMustRead;
		byte[] bff = new byte[102400];
		while (counter > 0) {
			byteMustRead = (int) (bff.length > counter ? counter : bff.length);
			int byteReaded = raf.read(bff, 0, byteMustRead);
			counter -= byteReaded;
			fos.write(bff, 0, byteReaded);
		}
		fos.close();
	}

	public static void unpack(String packedFile, String extractFile, String destFile) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(packedFile, "r");
		int numFile = raf.readInt();
		for (int i = 0; i < numFile; i++) {
			long pos = raf.readLong();
			long lenFile = raf.readLong();
			String name = raf.readUTF();
			if(name.equalsIgnoreCase(extractFile)) {
				raf.seek(pos);
				copy(raf, lenFile, destFile);
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
	//	pack("C:\\Users\\pc\\Downloads\\Newfolder", "C:\\Users\\pc\\Downloads\\data.dat");
		unpack("C:\\Users\\pc\\Downloads\\data.dat", "DOC.png", "C:\\Users\\pc\\Downloads\\copy1.png");
	}
}
