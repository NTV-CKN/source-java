package bai16_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UploadFactory extends Remote{
	public UploadInterface getUploader(String path) throws RemoteException;
}
