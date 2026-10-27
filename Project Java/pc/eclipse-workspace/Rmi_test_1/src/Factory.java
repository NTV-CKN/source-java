import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class Factory extends UnicastRemoteObject implements IFactory {
	private DbDao dao;
	public Factory() throws RemoteException {
		try {
			dao = new DbDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public ISearch login(String username, String password) throws RemoteException {
		boolean isLogin = dao.login(username, password);
		return isLogin?new Search():null;
	}

}
