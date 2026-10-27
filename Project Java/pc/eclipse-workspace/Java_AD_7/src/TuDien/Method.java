package TuDien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Method implements Serializable {
	public static void start() {
		Scanner sc = new Scanner(System.in);
		int choose;
		Map<String, String> tuDien = new HashMap<String, String>();
		LinkedHashMap<String, String> sortedHashMap = new LinkedHashMap<>();
		try {
			do {
				System.out.println("PRESS 1 TO ADD\nPRESS 2 TO DELETE A WORD\nPRESS 3 TO SORT\n"
						+ "PRESS 4 TO PRINT LIST RAW\nPRESS 6 TO SEARCH\nPRESS 7 TO WRITE\n" + "PRESS 8 TO READ");
				choose = sc.nextInt();
				if (choose == 1) {
					String tu = Regex.suitableWord();
					String nghia = Regex.suitableN();
//				sc.nextLine();
					tuDien.put(tu, nghia);
				} else if (choose == 2) {
					System.out.println("Nhap tu muon xoa");
					sc.nextLine();
					String tu = sc.nextLine();
					Set<String> keys = tuDien.keySet();
					for (String string : keys) {
						if (tu.equals(string)) {
							tuDien.remove(string);
							break;
						}
					}
				} else if (choose == 4) {
					for (Map.Entry<String, String> gets : tuDien.entrySet()) {
						String keys = gets.getKey();
						String values = gets.getValue();
						System.out.println("Tu: " + keys + ", nghia: " + values);
					}
				} else if (choose == 3) {
					List<Map.Entry<String, String>> entryList = new ArrayList<>(tuDien.entrySet());
					Collections.sort(entryList, new Comparator<Map.Entry<String, String>>() {
						public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
							return entry1.getKey().compareTo(entry2.getKey());
						}
					});
					sortedHashMap = new LinkedHashMap<>();
					for (Map.Entry<String, String> entry : entryList) {
						sortedHashMap.put(entry.getKey(), entry.getValue());
					}
					for (Map.Entry<String, String> entry : sortedHashMap.entrySet()) {
						System.out.println("Tu: " + entry.getKey() + ", nghia: " + entry.getValue());
					}
				} else if (choose == 6) {
					System.out.println("Nhap 1 tu muon tim kiem");
					sc.nextLine();
					String str = sc.nextLine();
					for (Map.Entry<String, String> e : tuDien.entrySet()) {
						if (e.getKey().equals(str)) {
							System.out.println("Tu " + e.getKey() + "co nghia la: " + e.getValue());
						}
					}
				} else if (choose == 7) {
					File file = new File("D:\\File\\tudien.txt");
					file.createNewFile();
					FileWriter fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
					if (sortedHashMap != null) {
						for (Map.Entry<String, String> element : sortedHashMap.entrySet()) {
							bw.write(element.getKey() + ", ");
							bw.write(element.getValue());
							bw.newLine();
							bw.flush();
						}
						bw.close();
					} else {
						System.err.println("Ban chua sort");
					}
				} else if (choose == 8) {
					File file = new File("D:\\File\\tudien.txt");
					if (file.exists()) {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						while (true) {
							String str = br.readLine();
							if (str != null) {
								System.out.println(str);
							}
						}
					}
				}
			} while (choose >= 1 && choose <= 8);
		} catch (Exception e) {
			System.err.println("LOI!");
		}

	}
}