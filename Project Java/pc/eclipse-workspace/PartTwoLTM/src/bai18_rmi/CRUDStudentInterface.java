package bai18_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CRUDStudentInterface extends Remote {
	public boolean addStudent(int id, String name, double grade) throws RemoteException;

	public boolean updateStudent(int id, String name, double grade) throws RemoteException;

	public boolean deleteStudent(int id) throws RemoteException;

	public Student findById(int id) throws RemoteException;

	public List<Student> findByName(String name) throws RemoteException;
	
	public void closeDao() throws RemoteException;
}
