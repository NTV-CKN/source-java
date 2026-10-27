package bai16_rmi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UploadImpl extends UnicastRemoteObject implements UploadInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dest;
	private FileOutputStream fos;
	protected UploadImpl(String dest) throws RemoteException {
		super();
		this.dest = dest;
		try {
			fos = new FileOutputStream(new File(dest), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean upload(byte[] buff, int byteReaded, int start) throws RemoteException {
		try {
			fos.write(buff, start, byteReaded);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		return false;
		}
		return true;
	}

	@Override
	public void resetPath(String path) throws RemoteException {
		this.dest = path;
		try {
			this.fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
		try {
			fos = new FileOutputStream(new File(this.dest), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeFos() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}
}
