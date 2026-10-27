package thunghiem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("C:\\Users\\pc\\Downloads\\diem - Copy.txt"),
						StandardCharsets.UTF_16LE.displayName()));
		int count = 0;
		String line;
		br.read();
		while((line = br.readLine()) != null) {
			System.out.println(++count);
			System.out.println(line);
		}
	}
}
