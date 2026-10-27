package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private Connection conn;

	public UserDao() throws SQLException, ClassNotFoundException {
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\THI_TCP_3.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public boolean checkUsername(String username) throws Exception {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean login(String username, String password) throws Exception {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void close() throws SQLException {
		conn.close();
	}
}
