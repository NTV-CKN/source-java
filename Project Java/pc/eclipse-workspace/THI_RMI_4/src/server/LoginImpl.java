package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginImpl extends UnicastRemoteObject implements ILogin {
	private UserDao dao;

	protected LoginImpl() throws RemoteException {
		super();
		try {
			dao = new UserDao();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean checkUsername(String username) throws RemoteException {
		try {
			return dao.checkUsername(username);
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public IManagerFile login(String username, String password) throws RemoteException {
		try {
			return dao.login(username, password) ? new ManagerFileImpl() : null;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void close() throws RemoteException {
		try {
			dao.close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

}
