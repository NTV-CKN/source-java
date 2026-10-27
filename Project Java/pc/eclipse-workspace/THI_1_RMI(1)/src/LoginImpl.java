import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginImpl extends UnicastRemoteObject implements ILogin {
	private UserDao userDao;

	protected LoginImpl() throws RemoteException {
		super();
		try {
			userDao = new UserDao();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean checkUsername(String username) throws RemoteException {
		try {
			return userDao.checkUsername(username);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public IProductManager login(String username, String password) throws RemoteException {
		try {
			return userDao.login(username, password) ? new ProductManagerImpl() : null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void close() throws RemoteException {
		try {
			userDao.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RemoteException(e.getMessage());
		}
	}
}
