import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFactory extends Remote{
	public ISearch login(String username, String password) throws RemoteException; 
}
