package re_learn_2_ltw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * header: + NumRec;
 * 
 * data: productId: Int
 * 			name: String
 * 			warrantyPeriod: Int
 * 			subtitle: String
 * 			description: String
 * 			minPrice: Double
 * 			maxPrice: Double
 * 			stock: Int
 * 			status: Int
 * 			createDate: String
 * 			updateDate: String (Default "null")
 *				isFetured: Int
 */
public class ProcessFileProduct {
	public final static String PATH_PRODUCT_DATA = "C:\\Users\\pc\\Downloads\\Newfolder\\products.dat";
	public final static String PATH_TO_EXPORT_CSV = "C:\\Users\\pc\\Downloads\\Newfolder\\products.csv";
	
	public static String writeData(Scanner sc, RandomAccessFile raf) throws IOException {
		int numRec = 0;
		if (raf.length() == 0) {
			raf.writeInt(numRec);
		} else {
			numRec = raf.readInt();
		}	
		numRec++;
		raf.seek(raf.length());
		// Xuong cuoi data
		int prodId = numRec;
		System.out.println("Name product:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Warranty Period:");
		int warrantyPeriod = sc.nextInt();
		System.out.println("Subtitle (If u want to new line -> \\n for each line:");
		sc.nextLine();
		String subtitle = sc.nextLine();
		System.out.println("Description (If u want to new line -> \\n for each line:");
		String descript =sc.nextLine();
		System.out.println("minPrice");
		double minPrice = sc.nextDouble();
		System.out.println("maxPrice");
		double maxPrice = sc.nextDouble();
		int stock = 1;
		int status = 1;
		String createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String updateDate = "null";
		int isFeatured = 0;

		raf.writeInt(prodId);
		raf.writeUTF(name);
		raf.writeInt(warrantyPeriod);
		raf.writeUTF(subtitle);
		raf.writeUTF(descript);
		raf.writeDouble(minPrice);
		raf.writeDouble(maxPrice);
		raf.writeInt(stock);
		raf.writeInt(status);
		raf.writeUTF(createDate);
		raf.writeUTF(updateDate);
		raf.writeInt(isFeatured);
		
		raf.seek(0);
		raf.writeInt(numRec);
		return "add product success";
	}
	
	public static String exportFileToCsv(RandomAccessFile raf, String charset, String dest) throws IOException {
		File file = new File(dest);
		if(raf.length() == 0) return "Not contain data";
		PrintWriter pw = new PrintWriter(file, charset);
		int numRec = raf.readInt();
		pw.print("ProductId\t");
		pw.print("Name\t");
		pw.print("Warranty Period\t");
		pw.print("Subtitle\t");
		pw.print("Description\t");
		pw.print("Min Price\t");
		pw.print("Max Price\t");
		pw.print("Status\t");
		pw.print("Stock\t");
		pw.print("Create Date\t");
		pw.print("Update Date\t");
		pw.print("Is Featured");
		pw.println();
		for(int i = 0; i < numRec; i++) {
			Product p = new Product();
			if(!p.writeToTextFile(raf, pw)) return "Error load data record into file csv";
		}
		pw.close();
		return "Success";
	}

	private static String preprocessNewLine(String str) {
		StringTokenizer st = new StringTokenizer(str, "\\n");
		if (st.countTokens() < 1)
			return str;
		String res = st.nextToken();
		while (st.hasMoreTokens()) {
			res += "\n" + st.nextToken();
		}
		 
		return res;
	}
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(PATH_PRODUCT_DATA), "rw");
		Scanner sc = new Scanner(System.in);
		int choose=-1;
		try {
			do {
				System.out.println("Press0 to exit\nPress1 to add product\nPress2 to export to csv");
				choose = sc.nextInt();
				switch (choose) {
				case 1: {
					raf.seek(0);
					writeData(sc, raf);
					break;
				}case 2: {
					raf.seek(0);
					exportFileToCsv(raf, StandardCharsets.UTF_8.displayName(), PATH_TO_EXPORT_CSV);
					break;
				}
				default:
					System.err.println("Khong co lenh nay");
				}
			} while (choose != 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		raf.close();
	}
}
