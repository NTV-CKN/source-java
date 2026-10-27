package bai18_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote{
	public CRUDStudentInterface login(String username, String password) throws RemoteException;
	public boolean checkUsername(String username) throws RemoteException;
}
