import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISearch extends Remote {
	public Student getStById(int id) throws RemoteException;
	public List<Student> getStByName(String name) throws RemoteException;
}
