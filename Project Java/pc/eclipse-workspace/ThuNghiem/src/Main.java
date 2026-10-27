import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\ok.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url);
		System.out.println(byIndex(conn, 0));
		
		conn.close();
	}
	
	public static User byIndex(Connection conn, int index) throws SQLException {
		String sql = "SELECT * FROM users";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = ps.executeQuery();
		boolean ok = rs.absolute(index);

		User user = null;
		System.out.println(ok + " get row: "  + rs.getRow() + " " + rs.isBeforeFirst());
		if(ok) {
			user= new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
		}
		rs.close();
		ps.close();
		return user;
	}
}
