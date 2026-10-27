package server;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws AccessException, RemoteException {
		LocateRegistry.createRegistry(7000).rebind("login", new LoginImpl());
	}
}
