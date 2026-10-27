package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote {
	public boolean checkUsername(String username) throws RemoteException;

	public IManagerFile login(String username, String password) throws RemoteException;

	public void close() throws RemoteException;
}
