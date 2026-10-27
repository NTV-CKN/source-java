package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private Connection conn;

	public ProductDao() throws SQLException, ClassNotFoundException {
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\THI_1_TCP.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public boolean checkIdSp(int idSp) {
		String sql = "SELECT * FROM products WHERE idsp = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, idSp);
			try (ResultSet rs = ps.executeQuery();) {
				return rs.next();
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public int add(int idsp, String name, int count, double price) {
		if (checkIdSp(idsp))
			return 0;
		String sql = "INSERT INTO products (idsp, name, count, price) VALUES (?, ?, ?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, idsp);
			ps.setString(2, name);
			ps.setInt(3, count);
			ps.setDouble(4, price);

			int rows = ps.executeUpdate();
			return rows;
		} catch (Exception e) {
			return 0;
		}
	}

	public int edit(int idsp, String name, int count, double price) {
		String sql = "UPDATE products SET name = ?, count = ?, price = ? WHERE idsp = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(4, idsp);
			ps.setString(1, name);
			ps.setInt(2, count);
			ps.setDouble(3, price);
			int rows = ps.executeUpdate();
			return rows;
		} catch (Exception e) {
			return 0;
		}
	}

	public List<Product> view(String name) {
		List<Product> lst = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE name LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, "%" + name + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					lst.add(new Product(rs.getInt("idsp"), rs.getString("name"), rs.getInt("count"),
							rs.getDouble("price")));
				}
				return lst;
			} catch (Exception e) {
				return lst;
			}
		} catch (Exception e) {
			return lst;
		}
	}

	public int remove(List<Integer> ids) {
		if (ids.isEmpty())
			return 0;
		String holders = "?";
		for (int i = 0; i < ids.size() - 1; i++) {
			holders += ", ?";
		}
		String sql = "DELETE FROM products WHERE idsp IN ( " + holders + " )";
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			for (int i = 0; i < ids.size(); i++) {
				ps.setInt(i + 1, ids.get(i));
			}
			int rows = ps.executeUpdate();
			return rows;
		} catch (Exception e) {
			return 0;
		}
	}
}
