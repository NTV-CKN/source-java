package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ManagerFileImpl extends UnicastRemoteObject implements IManagerFile {
	private FileInputStream fis;

	protected ManagerFileImpl() throws RemoteException {
		super();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String path, byte[] buff, int start, int end) throws RemoteException {
		try {
			File file = new File(path);
			if (file.isDirectory())
				throw new Exception("File khong ton tai hoac no la thu muc");
			FileOutputStream fos = new FileOutputStream(file, true);
			fos.write(buff, start, end);
			fos.close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public long getSize(String path) throws RemoteException {
		try {
			File file = new File(path);
			if (!file.exists() || file.isDirectory())
				throw new Exception("File khong ton tai hoac no la thu muc");
			return file.length();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public DownloadWrap get(String path, int sizeBuff) throws RemoteException {
		try {
			if (fis == null)
				fis = new FileInputStream(path);
			byte[] buff = new byte[sizeBuff];
			long length = getSize(path);
			int byteReaded = fis.read(buff, 0, sizeBuff);
			return new DownloadWrap(length, buff, byteReaded);
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeFis() throws RemoteException {
		// TODO Auto-generated method stub
		if (fis != null) {
			try {
				fis.close();
				fis = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RemoteException(e.getMessage());
			}

		}
	}

}
