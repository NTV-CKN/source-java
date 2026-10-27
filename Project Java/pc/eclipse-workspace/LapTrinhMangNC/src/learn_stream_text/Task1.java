package learn_stream_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task1 {
	public static String countLineCharWord(String path, String charset) throws IOException {
		String res = "";
		File file = new File(path);
		if (!file.exists() || file.isDirectory())
			return "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		if (charset.equals(StandardCharsets.UTF_16BE.displayName())
				|| charset.equals(StandardCharsets.UTF_16LE.displayName())) {
			br.read();
		}
		String line;
		long countLine = 0;
		long countWord = 0;
		long countChar = 0;
		while ((line = br.readLine()) != null) {
			countLine++;
			StringTokenizer st = new StringTokenizer(line, " ");
			countWord += st.countTokens();
			countChar += line.toCharArray().length;
		}
		res = "Result is: count line" + countLine + ", count word " + countWord + ", count char " + countChar;
		return res;
	}
	
	public static void copy(String path, String dest,String charset, String destCharset) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charset));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), destCharset));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(dest), destCharset), false);
		int bom = br.read();
		pw.write(bom);
		char[] chBuff = new char[1024];
		int charMustRead;
		while(true) {
			int charReaded = br.read(chBuff, 0, chBuff.length);
			if(charReaded == -1) break;
			System.out.println(charReaded);
			pw.write(chBuff, 0, charReaded);
		
		}
		pw.close();
		br.close();
	}
	public static void main(String[] args) throws IOException {
		//System.out.println(Task1.countLineCharWord("C:\\Users\\pc\\Downloads\\diem.txt", StandardCharsets.UTF_16LE.displayName()));
	Task1.copy("C:\\Users\\pc\\Downloads\\diem - Copy.txt", "C:\\Users\\pc\\Downloads\\diem1 - Copy.txt", 
StandardCharsets.UTF_16LE.displayName(), StandardCharsets.UTF_16BE.displayName());
	}
}
