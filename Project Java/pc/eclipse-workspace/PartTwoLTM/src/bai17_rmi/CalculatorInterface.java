package bai17_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInterface extends Remote {
	public double plus(double a, double b) throws RemoteException;

	public double minus(double a, double b) throws RemoteException;

	public double multiply(double a, double b) throws RemoteException;

	public double divide(double a, double b) throws RemoteException;
}
