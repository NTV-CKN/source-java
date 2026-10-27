import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class ProductManagerImpl extends UnicastRemoteObject implements IProductManager {
	private ProductDao productDao;

	protected ProductManagerImpl() throws RemoteException {
		super();
		try {
			productDao = new ProductDao();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean add(Product prod) throws RemoteException {
		try {
			return productDao.add(prod);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public List<Product> view(String name) throws RemoteException {
		try {
			return productDao.view(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean edit(Product prod) throws RemoteException {
		try {
			return productDao.edit(prod);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public int remove(List<Integer> ids) throws RemoteException {
		try {
			return productDao.remove(ids);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void close() throws RemoteException {
		try {
			productDao.close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
}
