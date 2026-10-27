import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws IOException {
		Registry regis = LocateRegistry.createRegistry(54321);
		regis.rebind("factory", new Factory());
	}
}
