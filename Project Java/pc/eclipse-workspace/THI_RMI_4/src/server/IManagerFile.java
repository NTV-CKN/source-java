package server;

import java.io.DataInputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManagerFile extends Remote {
	public void send(String path, byte[] buff, int start, int end) throws RemoteException;

	public long getSize(String path) throws RemoteException;

	public DownloadWrap get(String path, int sizeBuff) throws RemoteException;
	
	public void closeFis() throws RemoteException;
}
