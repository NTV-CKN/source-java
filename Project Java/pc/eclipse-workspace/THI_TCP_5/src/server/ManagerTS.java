package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ManagerTS {
	private RandomAccessFile raf;

	public ManagerTS() throws FileNotFoundException {
		raf = new RandomAccessFile("D:\\esclipse\\Project Java\\pc\\eclipse-workspace\\THI_TCP_5\\DATA\\thisinh.dat",
				"rw");
	}

	public boolean addTs(ThiSinh ts, DataInputStream dis, long length) throws IOException {
		raf.seek(0);
		int lenTs = 0;
		if (raf.length() == 0) {
			raf.writeInt(lenTs);
		} else {
			lenTs = raf.readInt();
		}
		raf.seek(4 + lenTs * (4 + 50 + 20 + 50 + 100000 + 1));
		ts.addTs(50, 20, 50, raf);
		long remainder = 100000 - length;
		long counter = length;
		byte[] buff = new byte[102400];
		int byteMustRead;
		while (counter > 0) {
			byteMustRead = (int) (buff.length > counter ? counter : buff.length);
			int byteReaded = dis.read(buff, 0, byteMustRead);
			counter -= byteReaded;
			raf.write(buff, 0, byteReaded);
			System.out.println("LIEU NHAN GIAN");
		}
		if (remainder > 0)
			raf.write(new byte[(int) remainder]);

		raf.seek(0);
		raf.writeInt(lenTs + 1);
		return true;
	}

	public boolean remove(int id) throws IOException {
		raf.seek(0);
		if (raf.length() == 0)
			return false;
		int numTs = raf.readInt();
		for (int i = 0; i < numTs; i++) {
			int index = 4 + i * (4 + 1 + 50 + 20 + 50 + 100000);
			raf.seek(index);
			long posDelete = raf.getFilePointer();
			byte deleted = raf.readByte();
			int idTs = raf.readInt();
			if (idTs == id) {
				if (deleted == 1)
					return false;
				raf.seek(posDelete);
				raf.writeByte(1);
				return true;
			}
		}
		return false;
	}

	public boolean findById(int id) throws IOException {
		raf.seek(0);
		if (raf.length() == 0)
			return false;
		int numTs = raf.readInt();
		for (int i = 0; i < numTs; i++) {
			int index = 4 + i * (4 + 1 + 50 + 20 + 50 + 100000);
			raf.seek(index);
			byte deleted = raf.readByte();
			int idTs = raf.readInt();
			if (idTs == id) {
				if (deleted == 1)
					return false;
				return true;
			}
		}
		return false;
	}

	public boolean getImgTs(int id, DataOutputStream dos) throws IOException {
		raf.seek(0);
		if (raf.length() == 0)
			return false;
		int numTs = raf.readInt();
		for (int i = 0; i < numTs; i++) {
			int index = 4 + i * (4 + 1 + 50 + 20 + 50 + 100000);
			raf.seek(index);
			byte deleted = raf.readByte();
			int idTs = raf.readInt();
			if (idTs == id) {
				if (deleted == 1)
					return false;
				convertCharsToStr(raf, 50);
				convertCharsToStr(raf, 20);
				convertCharsToStr(raf, 50);

				long counter = 100000;
				int byteMustRead;
				byte[] buff = new byte[102400];
				while (counter > 0) {
					byteMustRead = (int) (counter > buff.length ? buff.length : counter);
					int byteReaded = raf.read(buff, 0, byteMustRead);
					counter -= byteReaded;
					dos.write(buff, 0, byteReaded);
				}
				return true;
			}
		}
		return false;
	}

	private String convertCharsToStr(RandomAccessFile raf, int lenByteName) throws IOException {
		String res = "";
		for (int i = 0; i < lenByteName / 2; i++) {
			char ch = raf.readChar();
			if (ch != 0)
				res += ch;
		}
		return res;
	}

	public void close() throws IOException {
		raf.close();
	}
}
