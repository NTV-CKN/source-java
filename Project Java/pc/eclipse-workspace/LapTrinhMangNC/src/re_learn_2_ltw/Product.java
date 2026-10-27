package re_learn_2_ltw;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class Product {
	int idProduct, warrantyPeriod, stock, status, isFeatured;
	String name, subtitle, description, createDate, updateDate;
	double minPrice, maxPrice;

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return idProduct + "\t" + name + "\t" + warrantyPeriod + "\t" + subtitle + "\t" + description + "\t" + minPrice
				+ "\t" + maxPrice + "\t" + status + "\t" + stock + "\t" + createDate + "\t" + updateDate + "\t"
				+ isFeatured;
	}

	/*
	 * productId: Int name: String warrantyPeriod: Int subtitle: String description:
	 * String minPrice: Double maxPrice: Double stock: Int status: Int createDate:
	 * String updateDate: String (Default "null") isFetured: Int
	 */
	public boolean writeToTextFile(RandomAccessFile raf, PrintWriter pw) {
		try {
			idProduct = raf.readInt();
			name = raf.readUTF();
			warrantyPeriod = raf.readInt();
			subtitle = raf.readUTF();
			description = raf.readUTF();
			minPrice = raf.readDouble();
			maxPrice = raf.readDouble();
			stock = raf.readInt();
			status = raf.readInt();
			createDate = raf.readUTF();
			updateDate = raf.readUTF();
			isFeatured = raf.readInt();

			pw.println(toString());
			pw.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
	}
}
