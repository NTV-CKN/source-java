import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbDao {
	private Connection conn;

	public DbDao() throws ClassNotFoundException, SQLException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\Database1.accdb";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public List<Student> findStudentByName(String nameT) {
		try {
			String sql = "SELECT * FROM students WHERE fullName LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "% " + nameT);
			List<Student> lst = new ArrayList<Student>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String name = rs.getString("fullName");
				double avgGrade = rs.getDouble("avgGrade");

				lst.add(new Student(id, name, avgGrade));
			}
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Student findStudentById(int idT) {
		try {
			String sql = "SELECT * FROM students WHERE studentId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idT);
			ResultSet rs = ps.executeQuery();
			if (!rs.next())
				return null;
			int id = rs.getInt("studentId");
			String name = rs.getString("fullName");
			double avgGrade = rs.getDouble("avgGrade");

			return new Student(id, name, avgGrade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean login(String username, String passwd) {
		try {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			return ps.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbDao dao = new DbDao();
		System.out.println(dao.login("admin", "123"));
		System.out.println(dao.findStudentById(1));
		System.out.println(Arrays.toString(dao.findStudentByName("Vũ").toArray()));
	}
}
