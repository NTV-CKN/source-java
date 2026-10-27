package bai18_tcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao {
	private Connection conn;

	public StudentDao() throws ClassNotFoundException, SQLException {
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\TH18.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		conn.setAutoCommit(false);
	}

	public boolean checkUsername(String username) throws SQLException {
		String sql = "SELECT * FROM users WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		boolean isValid = rs.next();
		rs.close();
		ps.close();
		return isValid;
	}

	public boolean login(String username, String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		boolean isValid = rs.next();
		rs.close();
		ps.close();
		return isValid;
	}

	public Student findStById(int id) throws SQLException {
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

	public List<Student> findStByName(String name) throws SQLException {
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

	public boolean update(int id, Student st) throws SQLException {
		try {
			if (!checkIdStudent(id))
				return false;
			String sql = "SELECT * FROM students WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			boolean isValid = rs.first();
			if (!isValid)
				return false;
			rs.updateInt("id", st.id);
			rs.updateString("name", st.name);
			rs.updateDouble("grade", st.grade);
			rs.updateRow();
			conn.commit();

			rs.close();
			ps.close();
			return true;
		} catch (Exception e) {
			conn.rollback();
			return false;
		}
	}

	public boolean addStudent(Student st) throws SQLException {
		try {
			String sql = "SELECT * FROM students";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			rs.moveToInsertRow();
			rs.updateInt("id", st.id);
			rs.updateString("name", st.name);
			rs.updateDouble("grade", st.grade);
			rs.insertRow();
			rs.moveToCurrentRow();
			conn.commit();

			rs.close();
			ps.close();
			return checkIdStudent(st.id);
		} catch (Exception e) {
			conn.rollback();
			return false;
		}
	}

	public boolean deleteStudent(int id) throws SQLException {
		try {
			if(!checkIdStudent(id)) return false;
			String sql = "SELECT * FROM students WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			boolean isValid = rs.next();
			if (isValid)
				rs.deleteRow();
			
			conn.commit();

			rs.close();
			ps.close();
			return !checkIdStudent(id);
		} catch (Exception e) {
			conn.rollback();
			return false;
		}
	}

	public boolean checkIdStudent(int id) throws SQLException {
		String sql = "SELECT * FROM students WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		boolean isValid = rs.next();
		rs.close();
		ps.close();
		return isValid;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDao dao = new StudentDao();
		System.out.println(dao.login("admin", "123"));
		System.out.println(dao.login("admin", "1223"));
		System.out.println(dao.findStById(2));
		System.out.println(Arrays.toString(dao.findStByName("Hoàng Vũ").toArray()));
	}
}
