import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class Search extends UnicastRemoteObject implements ISearch{
	private DbDao dao;
	protected Search() throws RemoteException {
		super();
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
	public Student getStById(int id) throws RemoteException {
		return dao.findStudentById(id);
	}

	@Override
	public List<Student> getStByName(String name) throws RemoteException {
		return dao.findStudentByName(name);
	}

}
