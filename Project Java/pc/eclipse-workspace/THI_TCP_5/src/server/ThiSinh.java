package server;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ThiSinh {
	int id;
	String name;// 25
	String birthDate;// 10
	String address;// 25

	public void addTs(int lenByteName, int lenByteDate, int lenByAddress, RandomAccessFile raf) throws IOException {
		raf.writeByte(0);
		raf.writeInt(id);
		convertStrToChars(raf, name, lenByteName);
		convertStrToChars(raf, birthDate, lenByteDate);
		convertStrToChars(raf, address, lenByAddress);
	}

	private void convertStrToChars(RandomAccessFile raf, String name2, int lenByteName) throws IOException {
		for (int i = 0; i < lenByteName / 2; i++) {
			char ch = 0;
			if (i < name2.length())
				ch = name2.charAt(i);
			raf.writeChar(ch);
		}
	}

	public ThiSinh(int id, String name, String birthDate, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}
}
