package server;

import java.rmi.RemoteException;
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
		String url = "jdbc:ucanaccess://C:\\Users\\pc\\Downloads\\THI_2_RMI.accdb";
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public List<Product> view(String name) throws RemoteException {
		List<Product> prods = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE name LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + name + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					prods.add(new Product(rs.getInt("idsp"), rs.getString("name"), rs.getInt("count"),
							rs.getDouble("price")));
				}
				return prods;
			} catch (Exception e) {
				throw new RemoteException(e.getMessage());
			}
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public boolean add(Product prod) throws RemoteException {
		String sql = "INSERT INTO products(idsp, name, count, price) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, prod.idsp);
			ps.setString(2, prod.name);
			ps.setInt(3, prod.count);
			ps.setDouble(4, prod.price);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public boolean edit(Product prod) throws RemoteException {
		String sql = "UPDATE products SET name = ?, count = ?, price = ? WHERE idsp = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(4, prod.idsp);
			ps.setString(1, prod.name);
			ps.setInt(2, prod.count);
			ps.setDouble(3, prod.price);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public int remove(List<Integer> ids) throws RemoteException {
		if (ids.isEmpty())
			return 0;
		String holders = "?";
		for (int i = 0; i < ids.size() - 1; i++)
			holders += ", ?";
		String sql = "DELETE FROM products WHERE idsp IN(" + holders + ")";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			for (int i = 0; i < ids.size(); i++)
				ps.setInt(i + 1, ids.get(i));
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public void close() throws SQLException {
		conn.close();
	}
}
