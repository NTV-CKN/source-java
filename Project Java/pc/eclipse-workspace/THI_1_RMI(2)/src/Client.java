import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Client {
	private String command, param, username = null;
	private ILogin login;
	private IProductManager manager;
	private boolean isLogin = false;
	private boolean isContinue = true;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Client() throws RemoteException, NotBoundException {
		Registry regis = LocateRegistry.getRegistry(6969);
		login = (ILogin) regis.lookup("login");
	}

	public void process() {
		System.out.println("WELCOME");
		try {
			while (isContinue) {
				String cmd = br.readLine();
				processCmd(cmd);
				String res = performCmd();
				System.out.println(res);
			}
			manager.close();
			login.close();
		} catch (RemoteException re) {
			re.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String performCmd() {
		if (isLogin) {
			switch (command) {
			case "add": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());

				try {
					return manager.add(new Product(idsp, name, count, price)) ? "OK" : "ERROR";
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
				
					return "ERROR";
				}
			}
			case "remove": {
				List<Integer> ids = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(param, "\t");
				while (st.hasMoreTokens())
					ids.add(Integer.parseInt(st.nextToken()));

				try {
					return "ROW EFFECTS: " + manager.remove(ids);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
				return "ERROR";
				}
			}
			case "view": {
				List<Product> res;
				try {
					res = manager.view(param);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
				return "ERROR";
				}
				if (res.isEmpty())
					return "NOT FOUND PRODUCT";
				for (Product tmp : res)
					System.out.println(tmp.toString());
				return "THE END";
			}
			case "edit": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());

				try {
					return manager.edit(new Product(idsp, name, count, price)) ? "OK" : "CAN NOT UPDATE";
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					return "ERROR";
				}
			}
			case "quit": {

				isContinue = false;
				return "BYE";
			}
			default:
				return "COMMAND NOT FOUND";
			}
		} else {
			switch (command) {
			case "user": {
				boolean isValid;
				try {
					isValid = login.checkUsername(param);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
				return "ERROR";
				}
				username = param;

				return isValid ? "OK" : "FALSE";
			}
			case "pass": {
				if (username == null)
					return "PLEASE INPUT USERNAME BEFORE";
				try {
					manager = login.login(username, param);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					return "ERROR";
				}
				if (manager != null)
					isLogin = true;

				return (manager != null) ? "OK" : "FALSE";
			}
			case "exit": {

				isContinue = false;
				return "BYE";
			}
			default:
				return "PLEASE LOGIN";
			}
		}
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, "\t");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).trim();
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		new Client().process();
	}
}
