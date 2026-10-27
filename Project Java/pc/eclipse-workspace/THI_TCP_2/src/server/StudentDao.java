package server;

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
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\THI_2_TCP.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public Student findById(int id) {
		String sql = "SELECT * FROM students WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return new Student(rs.getInt("id"), rs.getString("name"), rs.getDouble("grade"));
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean add(Student st) {
		String sql = "INSERT INTO students(id, name, grade) VALUES(?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, st.id);
			ps.setString(2, st.name);
			ps.setDouble(3, st.grade);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean edit(Student st) {
		String sql = "UPDATE students SET name = ?, grade = ? WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(3, st.id);
			ps.setString(1, st.name);
			ps.setDouble(2, st.grade);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int remove(List<Integer> ids) {
		if (ids.isEmpty())
			return 0;
		String holders = "?";
		for (int i = 0; i < ids.size() - 1; i++)
			holders += ", ?";
		String sql = "DELETE FROM students WHERE id IN (" + holders + ")";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			for (int i = 0; i < ids.size(); i++)
				ps.setInt(i + 1, ids.get(i));

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Student> findByName(String name) {
		List<Student> res = new ArrayList<Student>();
		String sql = "SELECT * FROM students WHERE name LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + name + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					res.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getDouble("grade")));
				return res;
			} catch (Exception e) {
				e.printStackTrace();
				return res;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
	}

	public void close() throws SQLException {
		conn.close();
	}
}
