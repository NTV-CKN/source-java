package bai18_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginImpl extends UnicastRemoteObject implements LoginInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected LoginImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CRUDStudentInterface login(String username, String password) throws RemoteException {
		try {
			UserDao dao = new UserDao();
			boolean isValid = dao.login(username, password);
			return isValid ? new CRUDStudentImpl() : null;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean checkUsername(String username) throws RemoteException {
		try {
			UserDao dao = new UserDao();
			boolean isValid = dao.checkUsername(username);
			return isValid;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

}
