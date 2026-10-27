package bai18_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class CRUDStudentImpl extends UnicastRemoteObject implements CRUDStudentInterface{
	private StudentDao dao;
	protected CRUDStudentImpl() throws RemoteException {
		super();
		try {
			this.dao = new StudentDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addStudent(int id, String name, double grade) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.addSt(id, name, grade);
	}

	@Override
	public boolean updateStudent(int id, String name, double grade) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.updateSt(id, name, grade);
	}

	@Override
	public boolean deleteStudent(int id) throws RemoteException {
		return dao.deleteSt(id);
	}

	@Override
	public Student findById(int id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public List<Student> findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			return dao.findByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeDao() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			dao.closeConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException(e.getMessage());
		}
	}

}
