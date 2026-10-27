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
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\THI_6_TCP.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public Product findById(int idsp) throws Exception {
		String sql = "SELECT * FROM products WHERE idsp = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idsp);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return new Product(rs.getInt("idsp"), rs.getString("name"), rs.getInt("count"),
							rs.getDouble("price"));
				return null;
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean add(Product newProd) throws Exception {
		if (findById(newProd.idsp) != null)
			return false;
		String sql = "INSERT INTO products (idsp, name, count, price) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, newProd.idsp);
			ps.setString(2, newProd.name);
			ps.setInt(3, newProd.count);
			ps.setDouble(4, newProd.price);

			return ps.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean buy(List<Integer> ids) throws Exception {
		if (ids.isEmpty())
			return false;
		for (Integer id : ids) {
			Product prod = findById(id);
			if (prod == null)
				return false;
			if (prod.count == 0)
				return false;
		}
		String holders = "?";
		for (int i = 0; i < ids.size() - 1; i++)
			holders += ", ?";

		String sql = "UPDATE products SET count = count - 1 WHERE idsp IN(" + holders + ")";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			for (int i = 0; i < ids.size(); i++)
				ps.setInt(i + 1, ids.get(i));

			return ps.executeUpdate() == ids.size() ? true : false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Product> price(double fromPrice, double toPrice) throws Exception {
		List<Product> res = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE price BETWEEN ? AND ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, fromPrice);
			ps.setDouble(2, toPrice);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					res.add(new Product(rs.getInt("idsp"), rs.getString("name"), rs.getInt("count"),
							rs.getDouble("price")));
				}
				return res;
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Product> name(String name) throws Exception {
		List<Product> res = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE LOWER(name) LIKE LOWER(?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + name + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					res.add(new Product(rs.getInt("idsp"), rs.getString("name"), rs.getInt("count"),
							rs.getDouble("price")));
				}
				return res;
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
