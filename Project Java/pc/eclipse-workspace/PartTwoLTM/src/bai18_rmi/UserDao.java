package bai18_rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private Connection conn;

	public UserDao() throws SQLException, ClassNotFoundException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\TH18_RMI.accdb";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		conn.setAutoCommit(false);
	}

	public boolean checkUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery();) {
				return rs.next();
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean login(String username, String pass) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, username);
			ps.setString(2, pass);
			try (ResultSet rs = ps.executeQuery();) {
				return rs.next();
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
