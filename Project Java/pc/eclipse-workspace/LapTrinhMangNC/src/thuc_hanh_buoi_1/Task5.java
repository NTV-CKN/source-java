package thuc_hanh_buoi_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task5 {
	public static void packFirstHeader(String folder, String packedF) throws IOException {
		File folderSrc = new File(folder);
		File packedFile = new File(packedF);
		if (!folderSrc.exists())
			return;
		if (folderSrc.isFile())
			return;
		File[] arrFile = folderSrc.listFiles();
		if (arrFile == null)
			return;
		RandomAccessFile raf = new RandomAccessFile(packedFile, "rw");
		int numFile = 0;
		raf.writeInt(0); // placeholder size
		for (File item : arrFile) {
			if (item.isFile()) {
				raf.writeUTF(item.getName());
				raf.writeLong(item.length());
				readDataFileFirstHeader(raf, item);
				numFile++;
			}
		}
		raf.seek(0);
		raf.writeInt(numFile);
		raf.close();
	}

	private static void readDataFileFirstHeader(RandomAccessFile raf, File item) throws IOException {
		byte[] buffer = new byte[102400];
		long counter = item.length();
		int byteMustRead = 0;
		FileInputStream fis = new FileInputStream(item);

		while (counter > 0) {
			byteMustRead = (int) (counter > buffer.length ? buffer.length : counter);
			int byteReaded = fis.read(buffer, 0 , byteMustRead);
			raf.write(buffer, 0, byteReaded);
			counter -= byteReaded;
		}
		fis.close();
	}

	public static void unpackFirstHeader(String packedFile, String extractFile, String destFile) throws IOException {
		File pack = new File(packedFile);
		File dest = new File(destFile);
		RandomAccessFile raf = new RandomAccessFile(pack, "r");
		FileOutputStream fos = new FileOutputStream(dest);

		int numFile = raf.readInt();
		for (int i = 0; i < numFile; i++) {
			String name = raf.readUTF();
			System.out.println(name);
			System.out.println(extractFile);
			if (name.equals(extractFile)) {
				long counter = raf.readLong();
				byte[] buffer = new byte[102400];
				int byteMustRead;
				while(counter > 0) {
					byteMustRead = (int)(counter > buffer.length?buffer.length: counter);
					int byteReaded = raf.read(buffer, 0, byteMustRead);
					counter -= byteReaded;
					fos.write(buffer, 0,byteReaded);
				}
				break;
			} else {
				long size = raf.readLong();
				long pos = raf.getFilePointer();
				raf.seek(size + pos);
			}
		}
		raf.close();
		fos.close();
	}

	public static void packLastHeader(String folder, String filePack) throws IOException {
		//data
		//long:Pos String:Name long:Length
		File folderSrc = new  File(folder);
		if(!folderSrc.exists() || folderSrc.isFile()) return;
		File filePackSrc = new File(filePack);
		
		File[] arrFile = folderSrc.listFiles();
		if(arrFile == null) return;
		RandomAccessFile raf =new RandomAccessFile(filePackSrc, "rw");
		int numFile = 0;
		long lengthTotalData = 8;
		raf.writeLong(lengthTotalData);
		for(File item: arrFile) {
			if(item.isFile()) {
				copy(raf, item, item.length());
				lengthTotalData+=item.length();
				numFile++;
			}
		}		
		long headerPointer = raf.getFilePointer(); //cuoi data
		System.out.println(headerPointer+ "va"+lengthTotalData);
		raf.seek(0);
		raf.writeLong(lengthTotalData);
		long dataPointer = raf.getFilePointer();//byte thu 8
		raf.seek(headerPointer);
		System.out.println(numFile);
		raf.writeInt(numFile); //nhay len 4 bytes
		System.out.println(raf.getFilePointer());
		headerPointer = raf.getFilePointer();
		for(File item: arrFile) {
			if(item.isFile()) {
				raf.writeLong(dataPointer);//pos
				raf.writeUTF(item.getName());//name
				raf.writeLong(item.length());//length
				headerPointer = raf.getFilePointer();//cap nhat headerPointer
				raf.seek(dataPointer + item.length());
				dataPointer = raf.getFilePointer();//cap nhat dataPointer
				raf.seek(headerPointer);
			}
		}
		raf.close();
	}
	
	private static void copy(RandomAccessFile raf, File item, long length) throws IOException {
		FileInputStream fis = new FileInputStream(item);
		byte[] buffer = new byte[102400];
		int byteMustRead;
		long counter = length;
		while(counter > 0) {
			byteMustRead = (int) (counter > buffer.length?buffer.length:counter);
			int byteReaded = fis.read(buffer, 0, byteMustRead);
			counter -= byteReaded;
			raf.write(buffer, 0, byteReaded);
		}
		fis.close();
	}

	public static void unpckLastHeader(String pack, String nameExtract, String dest) throws IOException {
		File file = new File(pack);
		FileOutputStream fos = new FileOutputStream(new File(dest));
		RandomAccessFile raf = new  RandomAccessFile(file, "r");
		long headerPointer = raf.readLong();
		raf.seek(headerPointer);
		int numFile = raf.readInt();
	System.out.println(numFile);
		for(int i = 0; i<numFile; i++) {
			long pos = raf.readLong();
			String name = raf.readUTF();
			long len = raf.readLong();
			System.out.println(name);
			if(name.equalsIgnoreCase(nameExtract)) {
				raf.seek(pos);
				byte[] buffer = new byte[102400];
				int byteMustRead;
				long counter = len;
				while(counter > 0) {
					byteMustRead = (int)(counter > buffer.length ? buffer.length:counter);
					int byteReaded = raf.read(buffer, 0, byteMustRead);
					counter -= byteReaded;
					fos.write(buffer, 0, byteReaded);
				}
				break;
			}
		}
		fos.close();
		raf.close();
	}
	
	public static void main(String[] args) {
		try {
		packLastHeader("C:\\Users\\pc\\Downloads\\New folder", "C:\\Users\\pc\\Downloads\\New folder\\abc.pack");
		unpckLastHeader("C:\\Users\\pc\\Downloads\\New folder\\abc.pack","customer_2.webp" , "C:\\Users\\pc\\Downloads\\New folder\\copy.webp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
