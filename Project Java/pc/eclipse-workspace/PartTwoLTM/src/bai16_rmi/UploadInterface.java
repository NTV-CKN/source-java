package bai16_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UploadInterface extends Remote {
	public boolean upload(byte[] buff, int byteReaded, int start) throws RemoteException;
	public void resetPath(String path) throws RemoteException;
	public void closeFos() throws RemoteException;
}
