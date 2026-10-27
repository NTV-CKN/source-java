package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginImpl extends UnicastRemoteObject implements ILogin {
	private UserDao dao;

	protected LoginImpl() throws RemoteException {
		super();
		try {
			this.dao = new UserDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkUsername(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.checkUsername(username);
	}

	@Override
	public IProductManager login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.login(username, password) ? new ProductManagerImpl() : null;
	}

	@Override
	public void close() throws RemoteException {
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}
}
