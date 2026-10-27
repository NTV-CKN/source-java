package main;

import java.util.Scanner;

import QuanLiDSSV.DanhSachSinhVien;
import QuanLiDSSV.SinhVien;

public class main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
     int luachon = 0;
   	DanhSachSinhVien dssv = new DanhSachSinhVien();

	do {
		
		System.out.println("****MOI BAN LUA CHON****");
		System.out.println("Nhan 1 de them sinh vien");
		System.out.println("Nhan 2 de in danh sach sinhvien");
		System.out.println("Nhan 3 de kiem tra danh sach sinh vien co rong khong");
		System.out.println("Nhan 4 de kiem tra so luong sinh vien");
		System.out.println("Nhan 5 de xoa toan bo danh sach");
		System.out.println("Nhan 6 de kiem tra sinh vien co trong danh sach khong");
		System.out.println("Nhan 7 de xoa 1 sinh vien khoi danh sach");
		System.out.println("Nhan 8 de tim kiem tat ca sinh dua tren ten cua sinh vien do");
		System.out.println("Nhan 9 de sap xep diem sinh vien tu cao toi thap");
		System.out.println("Nhan 10 de ghi danh sach sinh vien vao file");
		System.out.println("Nhan 11 de doc file");
		System.out.println("Nhan 0 de thoat");
		luachon = sc.nextInt();
	    sc.nextLine();
	    
	    //TH1
	    if(luachon == 1) {
	    	System.out.println("Nhap ma so sinh vien ");String maSV = sc.nextLine();
	    	System.out.println("Nhap ho va ten sinh vien ");String hoVaTen = sc.nextLine();
	    	System.out.println("Nhap nam sinh ");int namSinh = sc.nextInt();
	    	System.out.println("Nhap diem trung binh ");double diemTB = sc.nextDouble();
	    	
	    	SinhVien sinhVien = new SinhVien(maSV, hoVaTen, namSinh, diemTB);
	        dssv.themSinhVien(sinhVien);
	    }  else if(luachon == 2) {
	     //TH2
	    dssv.inDanhSachSV(); 
	    System.out.println("\n");
	    }else if(luachon == 3) {
	    	//TH3
	    	if(dssv.kiemTraRong() == true) {
	    		System.out.println("Danh sach sinh vien hien dang rong!");
	    	}else {
	    		System.out.println("Danh sach sinh vien khong rong!");
	    	}
	    }else if(luachon == 4) {
	    	//TH4
	    	dssv.laySoLuong();
	    }else if(luachon == 5) {
	    	//TH5
	    	dssv.lamRongDSSV();
	    }else if (luachon == 6) {
	    	//TH6
	    	System.out.println("Nhap ma sinh vien muon kiem tra");
	    	String b = sc.nextLine();
	    	SinhVien sv = new SinhVien(b);
	    	System.out.println( dssv.kiemTraSinhVien(sv));
	    }else if (luachon == 7) {
	    	//TH7
	    	System.out.println("Nhap vao ma sinh vien ma ban muon xoa!");
	    	String c = sc.nextLine();
	    	SinhVien sv2= new SinhVien(c);
            dssv.xoaSinhVien(sv2);
	    }else if(luachon == 8) {
	    	//TH8
	    	System.out.println("Nhap vao ten sinh vien ma ban muon tim!");
	    	String c = sc.nextLine();
	    	SinhVien sv2= new SinhVien(c);
	    	dssv.timKiemSinhVien(c);
	    }else if (luachon == 9) {
	    	dssv.sapXepDiemTB();
	    	   dssv.inDanhSachSV(); 
	   	    System.out.println("\n");
	    }else if(luachon == 10) {
	    	//TH10
	    	System.out.println("Nhap path co file muon luu");
	    	String v = sc.nextLine();
	    	dssv.ghiDanhSachSinhVien(v);
	    }else if(luachon == 11) {
	    	//TH11
	    	System.out.println("Nhap path ");
	    	String v = sc.nextLine();
	    	dssv.docAllFileDanhSachSinhVien(v);
	    }
	} while (luachon != 0);
	    

	  
}
}
