package java_BT68;

import java.io.File;

public class Handle {
	private File file;
	public Handle(String h) {
		this.file = new File(h);
	}
 

public boolean kiemTraThucThi() {
	return this.file.canExecute();
}
public boolean kiemTraDoc() {
	return this.file.canRead();
}
public boolean kiemTraGhi() {
	return this.file.canWrite();
}
public void inPathName() {
	System.out.println(this.file.getAbsolutePath());
}
public void inTen() {
	System.out.println(this.file.getName());
}
public void inRaCacThuMucVaTepTin() {
	File[] arr = this.file.listFiles();
	for (File file : arr) {
		System.out.println(file);
	}
	
}
public void ganInChiTiet() {
	this.inChiTietDir(this.file, 1);
}
public void inChiTietDir(File f, int bac) {
		for (int i = 0; i < bac; i++) {
			System.out.print("\t"); 
		}
		
		System.out.println("|__  "+f.getName());
		if(f.canRead() && f.isDirectory()) {
	
			File [] arr = f.listFiles();
			for (File file : arr) {
				inChiTietDir(file, bac + 1);
			}
		}
	}
}
