package labre_learn_3;
//"C:\Users\pc\Downloads\diem.txt"

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Task {
	public List<Student> loadData(String stFile, String diemFile, String charset) throws IOException {
		List<Student> lst = new ArrayList<Student>();
		File stFileT = new File(stFile);
		BufferedReader buffStFile = getBufferReaderUTF8BOM(stFileT,charset);
		String res;
		while ((res = buffStFile.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(res, "\t");
			int id = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int bYear = Integer.parseInt(st.nextToken());
			lst.add(new Student(id, name, bYear));
		}
		// Diem
		File diemFileT = new File(diemFile);
		BufferedReader buffDiemFile = getBufferReaderUTF8BOM(diemFileT, charset);
		res = "";
		while ((res = buffDiemFile.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(res, "\t");
			int id = Integer.parseInt(st.nextToken());
			double grade = 0.0;
			int count = 0;
			for (Student std : lst) {
				if (std.id == id) {
					while (st.hasMoreTokens()) {
						grade += Double.parseDouble(st.nextToken());
						count++;
					}
				
					grade = Double.isNaN(grade / count) ? 0 : (grade / count);

					std.grade = grade;
					break;
				}
			}
		}
		return lst;
	}

	private BufferedReader getBufferReaderUTF8BOM(File file, String charset) throws IOException {
		FileInputStream fis = new FileInputStream(file);
//		// Bo qua 3 bytes
//		byte[] buff = new byte[3];
//		int byteMustRead;
//		int counter = 3;
//		while (counter > 0) {
//			byteMustRead = counter < buff.length ? counter : buff.length;
//			int byteReaded = fis.read(buff, 0, byteMustRead);
//			counter -= byteReaded;
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, charset));
		br.read();
		return br;
	}

	public void export(List<Student> sts, String destFile, String charset) throws UnsupportedEncodingException, FileNotFoundException {
		PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(new File(destFile)), charset)
				, true);
		pw.println("id\tHo Va Ten\tNam Sinh\tDiem Trung Binh");
		for(Student std:sts) {
			pw.println(std.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		Task task = new Task();
		List<Student> lst = task.loadData
				("C:\\Users\\pc\\Downloads\\sv.txt", "C:\\Users\\pc\\Downloads\\diem.txt", StandardCharsets.UTF_16BE.displayName());
		System.out.println(Arrays.toString(lst.toArray()));
		task.export(lst,"C:\\Users\\pc\\Downloads\\ok.csv" , StandardCharsets.UTF_8.displayName());
	}
}
