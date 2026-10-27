package bai18_rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private Connection conn;

	public StudentDao() throws SQLException, ClassNotFoundException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\TH18_RMI.accdb";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		conn.setAutoCommit(false);
	}

	public Student findById(int id) throws SQLException {
		String sql = "SELECT * FROM students WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		boolean isValid = rs.next();
		Student st = null;
		if (isValid) {
			st = new Student(rs.getInt("id"), rs.getString("name"), rs.getDouble("grade"));
		}
		rs.close();
		ps.close();
		return st;
	}

	public boolean checkById(int id) throws SQLException {
		String sql = "SELECT * FROM students WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		boolean isValid = rs.next();
		rs.close();
		ps.close();
		return isValid;
	}

	public List<Student> findByName(String name) throws SQLException {
		String sql = "SELECT * FROM students WHERE name LIKE ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "% " + name);
		ResultSet rs = ps.executeQuery();
		List<Student> lst = new ArrayList<Student>();
		while (rs.next()) {
			lst.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getDouble("grade")));
		}
		rs.close();
		ps.close();
		return lst;
	}

	public boolean updateSt(int id, String name, double grade) {
		String sql = "SELECT * FROM students WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);) {
			if (!checkById(id))
				return false;
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				boolean isValid = rs.next();
				if (!isValid)
					return false;

				// update
				rs.updateString("name", name);
				rs.updateDouble("grade", grade);
				rs.updateRow();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteSt(int id) {
		String sql = "SELECT * FROM students WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);) {
			if (!checkById(id))
				return false;
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				boolean isValid = rs.next();
				if (!isValid)
					return false;

				rs.deleteRow();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				return false;
			}
			return !checkById(id);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addSt(int id, String name, double grade) {
		String sql = "SELECT * FROM students";
		try (PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);) {
			try (ResultSet rs = ps.executeQuery();) {
				rs.moveToInsertRow();
				// add
				rs.updateInt("id", id);
				rs.updateString("name", name);
				rs.updateDouble("grade", grade);
				rs.insertRow();
				rs.moveToCurrentRow();

				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				return false;
			}
			return checkById(id);
		} catch (Exception e) {
			return false;
		}
	}

	public void closeConnect() throws SQLException {
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

	}
}
