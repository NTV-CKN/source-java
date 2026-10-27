package relearn_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
	public static void pack(String folder, String packedFile) throws IOException {
		File folderT = new File(folder);
		List<File> lstF = new ArrayList<File>();
		List<Long> posHeaders = new ArrayList<Long>();
		RandomAccessFile raf = new RandomAccessFile(packedFile, "rw");
		raf.writeInt(0);
		int numFile = processRec(folderT.getAbsolutePath(), raf, lstF, posHeaders);

		// ghi data
		for (int i = 0; i < lstF.size(); i++) {
			long posData = raf.getFilePointer();
			// seek den pos header
			raf.seek(posHeaders.get(i));
			raf.writeLong(posData);
			long fileLen = raf.readLong();
			raf.seek(posData);
			// ghi du lieu
			copy(raf, lstF.get(i), fileLen);
		}
		raf.seek(0);
		raf.writeInt(numFile);
		raf.close();
	}

	private static void copy(RandomAccessFile raf, File file, long fileLen) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		long counter = fileLen;
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

	public static void unpack(String packedFile, String extractName, String destFile) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(packedFile, "r");
		int numFile = raf.readInt();
		int count = 1;
		long nextHeader = 4;
		for (int i = 0; i < numFile; i++) {
			raf.seek(nextHeader);
			long pos = raf.readLong();
			long lenFile = raf.readLong();
			String name = raf.readUTF();
			nextHeader = raf.getFilePointer();
			if (extractName.equalsIgnoreCase(name)) {
				raf.seek(pos);
				String nameFile = "(" + count++ + ")" + name;
				FileOutputStream fos = new FileOutputStream(destFile+"\\" + nameFile);
				long counter = lenFile;
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
		}
		raf.close();
	}

	private static int processRec(String path, RandomAccessFile raf, List<File> lstF, List<Long> posHeaders)
			throws IOException {
		int count = 0;
		File xx = new File(path);
		File[] files = xx.listFiles();
		for (File yy : files) {
			if (yy.isFile()) {
				lstF.add(yy);
				long pos = raf.getFilePointer();
				raf.writeLong(0);// ghi position
				raf.writeLong(yy.length());
				raf.writeUTF(yy.getName());
				posHeaders.add(pos);
				count++;
			}
			if (yy.isDirectory()) {
				count += processRec(yy.getAbsolutePath(), raf, lstF, posHeaders);
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		pack("C:\\Users\\pc\\Downloads\\Newfolder", "C:\\Users\\pc\\Downloads\\Newfolder\\data.dat");
		unpack("C:\\Users\\pc\\Downloads\\Newfolder\\data.dat", "copy1.pdf", "C:\\Users\\pc\\Downloads\\Newfolder2");
	}
}
