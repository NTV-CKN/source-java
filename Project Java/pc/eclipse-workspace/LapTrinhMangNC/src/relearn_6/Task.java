package relearn_6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	public List<Student> importSt(String pathSt, String pathGrade, String charset) throws IOException {
		List<Student> sts = new ArrayList<Student>();
		// GD1: Doc st.txt
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathSt), charset));
		br.read();
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, "\t");
			int id = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int bYear = Integer.parseInt(st.nextToken());
			double grade = 0;
			sts.add(new Student(id, name, grade, bYear, 0, 0));
		}
		br.close();
		// GD2: Ghi lai diem trong grade.txt
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(pathGrade), charset));
		br2.read();
		line = "";
		while ((line = br2.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, "\t");
			int id = Integer.parseInt(st.nextToken());
			double grade = st.countTokens();
			for (Student stT : sts) {
				if (stT.id == id) {
					if (grade == 0) {
						stT.grade = grade;
						stT.minGrade = grade;
						stT.maxGrade = 0;
						break;
					}
					double gradeAvg = 0;
					double maxGrade = Integer.MIN_VALUE;
					double minGrade = Integer.MAX_VALUE;
					int count = 0;
					while (st.hasMoreTokens()) {
						double g = Double.parseDouble(st.nextToken());
						gradeAvg += g;
						minGrade = Math.min(minGrade, g);
						maxGrade = Math.max(maxGrade, g);
						count++;
					}
					stT.grade = gradeAvg / count;
					stT.maxGrade = maxGrade;
					stT.minGrade = minGrade;
					stT.grade = ((int)(stT.grade * 100))/100.0;
					break;
				}
			}
		}
		br2.close();
		return sts;
	}

	public void export(List<Student> sts, String destFile, String charset) throws UnsupportedEncodingException, FileNotFoundException {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFile), charset), true);
		pw.println("id\tname\tbirth year\tgrade avg\tmax grade\tmin grade");
		for(Student st: sts) {
			pw.println(st.toString());
		}
		pw.close();
	}

	public static void main(String[] args) throws IOException {
		Task t = new Task();
		List<Student> lst = t.importSt("C:\\Users\\pc\\Downloads\\students.txt", "C:\\Users\\pc\\Downloads\\grade.txt",
				StandardCharsets.UTF_16BE.displayName());
		System.out.println(Arrays.toString(lst.toArray()));
		t.export(lst, "C:\\Users\\pc\\Downloads\\students.csv", StandardCharsets.UTF_8.displayName());
		
	}
}
