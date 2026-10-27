package server;

import java.io.Serializable;

public class DownloadWrap implements Serializable {
	long fileSize;
	byte[] buff;
	int byteReaded;

	public DownloadWrap(long fileSize, byte[] buff, int byteReaded) {
		super();
		this.fileSize = fileSize;
		this.buff = buff;
		this.byteReaded = byteReaded;
	}

	public long getFileSize() {
		return fileSize;
	}

	public byte[] getBuff() {
		return buff;
	}

	public int getByteReaded() {
		return byteReaded;
	}
}
