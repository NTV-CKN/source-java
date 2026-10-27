import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProductManager extends Remote {
	public boolean add(Product prod) throws RemoteException;

	public List<Product> view(String name) throws RemoteException;

	public boolean edit(Product prod) throws RemoteException;

	public int remove(List<Integer> ids) throws RemoteException;

	public void close() throws RemoteException;

}
