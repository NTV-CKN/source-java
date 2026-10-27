package bai16_rmi;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws AccessException, RemoteException {
		Registry regis = LocateRegistry.createRegistry(12345);
		regis.rebind("factory", new UploadFactoryImpl());
	}
}
