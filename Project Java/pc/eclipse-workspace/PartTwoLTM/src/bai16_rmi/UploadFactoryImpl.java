package bai16_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UploadFactoryImpl extends UnicastRemoteObject implements UploadFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadFactoryImpl() throws RemoteException {
		super();
	}

	@Override
	public UploadInterface getUploader(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return (UploadInterface) new UploadImpl(path);
	}
}
