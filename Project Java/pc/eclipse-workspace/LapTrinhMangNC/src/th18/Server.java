package th18;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.List;

public class Server {
	public static final String USER_NAME = "admin", PASS_WORD = "123";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		List<Students> students = Ucanaccess.connectAndGetListStudent();
		ServerSocket serverSocket = new ServerSocket(54321);
		while(true) {
			new ServerThread(serverSocket.accept(), students).start();
		}
	}
}
