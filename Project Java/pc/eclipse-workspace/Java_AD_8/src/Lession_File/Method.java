package Lession_File;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Method {
	//write
public static void writeFile(String str) throws IOException {
	File file = new File("D:\\File\\text1.txt");
	FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8,true);
	BufferedWriter bw = null;
	try {
		file.createNewFile();
		bw = new BufferedWriter(fw);
		String[] s = str.split("\n");
		for (String string : s) {
			bw.write(string +"\n");
		}
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		if(fw != null) {
			try {
				bw.flush();
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	//read
public static void readFile() throws IOException {
	File file = new File("D:\\File\\text1.txt");
	FileReader fr = null;
	BufferedReader br = null;
	try {
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		String str = br.readLine();
		while(str != null || str == "\n") {
			System.out.println(str);
			str = br.readLine();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}finally {
		if(br != null) {
			try {
				br.close();fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	//clear
public static void deleteFile(File file) {
	if(file.isDirectory()) {
		File[] files = file.listFiles();
		for (File file2 : files) {
			Method.deleteFile(file2);
		}
	}else {
		file.delete();
	}
	}
	//zip
public static void zipFile(File file) throws IOException {
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String str;
	String append ="";
	try {
		while( (str = br.readLine()) != null || str == "\n") {
			append+= str;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(br != null) {
			br.close();
			fr.close();
		}
	}
	
	ByteArrayOutputStream byteA = new ByteArrayOutputStream();
	byte[] input = append.getBytes();
	byte[] buffer = new byte[512];
	
	Deflater de = new Deflater(Deflater.DEFAULT_COMPRESSION);
	de.setInput(input);
	de.finish();
	while(!de.finished()) {
		int compress = de.deflate(buffer);
		byteA.write(buffer, 0, compress);
	}
	byte[] output = byteA.toByteArray();
	String result = new String(output, StandardCharsets.UTF_8);
	
	File file2 = new File("D:\\File\\text2.zip");
	file2.createNewFile();
	FileWriter fos = new FileWriter(file2, true);
	BufferedWriter bos = new BufferedWriter(fos);
	bos.write(result);
	
	bos.flush();
	bos.close();
	fos.close();
}
	//unzip
public static void unZipFile(File file) throws IOException {
//	FileReader fr = new FileReader(file);
//	BufferedReader br = new BufferedReader(fr);
//	StringBuilder builder = new StringBuilder();
//	String str = "";
//	while((str = br.readLine())!=null) {
//		builder.append(str);
//	}
//	String result = builder.toString();
//	br.close();fr.close();
	FileInputStream fis = new FileInputStream(file);
	ByteArrayOutputStream byteA = new ByteArrayOutputStream();
	byte[] input = fis.readAllBytes();

	fis.close();
	byte[] output;
	byte[] buffer = new byte[1024];
	Inflater in = new Inflater();
	in.setInput(input);
//	in.finished();
	while(!in.finished()) {
		try {
			int compress = in.inflate(buffer);
			byteA.write(buffer, 0, compress);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	in.end();
	output = byteA.toByteArray();
	File file2 = new File("D:\\File\\text3.zip");
	file2.createNewFile();
	FileWriter fw = new FileWriter(file2);
	BufferedWriter bw = new BufferedWriter(fw);
	
	String str2 = new String(output, StandardCharsets.UTF_8);
	bw.write(str2);
	
	bw.close();
	fw.close();
}
//zip by zipout
public static void newZip(File file, File fileZip) throws IOException {
	FileInputStream fis = new FileInputStream(file);
	FileOutputStream fos = new FileOutputStream(fileZip);
	
	ZipOutputStream zipOut = new ZipOutputStream(fos);
	ZipEntry zipe = new ZipEntry(file.getName());
	zipOut.putNextEntry(zipe);
	byte[] bytes = new byte[1024];
	int lenght;
	while((lenght = fis.read(bytes)) >= 0) {
		zipOut.write(bytes,0, lenght);
	}zipOut.close();
	fis.close();fos.close();
}
//zip multi file
public static void zipMultiFiles(File file1, File file2, File file3) throws IOException {
	File fileZip = new File("D:\\File\\zipne.zip");
	File[] files = new File[] {file1, file2, file3};
	FileOutputStream fos = new FileOutputStream(fileZip);
	ZipOutputStream zipOut = new ZipOutputStream(fos);
	for (File file : files) {
		if(file.isDirectory()) {
			continue;
		}else {
			FileInputStream fis = new FileInputStream(file);
			ZipEntry zipe = new ZipEntry(file.getName());
			zipOut.putNextEntry(zipe);
			int size;
			byte[] bytes = new byte[1024];
			while((size=fis.read(bytes))>=0) {
				zipOut.write(bytes, 0, size);
			}fis.close();
		}
	}zipOut.close(); fos.close();
}
}

