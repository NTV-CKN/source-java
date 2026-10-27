package bai17_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {

	protected CalculatorImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double plus(double a, double b) throws RemoteException {
		return a + b;
	}

	@Override
	public double minus(double a, double b) throws RemoteException {
		return a - b;
	}

	@Override
	public double multiply(double a, double b) throws RemoteException {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double divide(double a, double b) throws RemoteException {
		if (Double.isInfinite(a / b))
			throw new RemoteException("Loi chia 0");
		return a / b;
	}
}
