package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class ProductManagerImpl extends UnicastRemoteObject implements IProductManager {
	private ProductDao dao;

	protected ProductManagerImpl() throws RemoteException {
		super();
		try {
			this.dao = new ProductDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Product prod) throws RemoteException {
		return dao.add(prod);
	}

	@Override
	public boolean edit(Product prod) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.edit(prod);
	}

	@Override
	public int remove(List<Integer> ids) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.remove(ids);
	}

	@Override
	public List<Product> view(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.view(name);
	}

	@Override
	public void close() throws RemoteException {
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
	}
}
