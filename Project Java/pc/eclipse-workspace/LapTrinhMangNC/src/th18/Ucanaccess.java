package th18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ucanaccess {
	public static List<Students> connectAndGetListStudent() throws ClassNotFoundException, SQLException {
		List<Students> students = new ArrayList<Students>();
		String url = "jdbc:ucanaccess://" + "C:\\Users\\pc\\Downloads\\Database1.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		Connection connec = DriverManager.getConnection(url);
		String sql = "SELECT * FROM Students";
		ResultSet st = connec.prepareStatement(sql).executeQuery();
		while(st.next()) {
			students.add(new Students(st.getInt("studentId"), st.getString("fullName"), st.getDouble("avgGrade")));
		}
		
		st.close();
		connec.close();
		return students;
	}
}
