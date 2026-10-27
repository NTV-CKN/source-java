package QuanLiDSSV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> danhSach;

//constructorNull
	public DanhSachSinhVien() {
		this.danhSach = new ArrayList<SinhVien>();
	}

//constructorHaveParameter
	public DanhSachSinhVien(ArrayList<SinhVien> s) {
		this.danhSach = s;
	}

// 1. them sinh vien vao danh sach
	public void themSinhVien(SinhVien a) {
		this.danhSach.add(a);
	}

//2. in danh sach sinh vien ra man hinh
	public void inDanhSachSV() {
		for (SinhVien sinhVien : this.danhSach) {
			System.out.println(sinhVien);
		}
	}

//3. check danh sach co rong khong
	public boolean kiemTraRong() {
		return this.danhSach.isEmpty();
	}

//4. lay so luong sinh vien trong danh sach
	public void laySoLuong() {
		System.out.println("So luong sinh vien hien tai la: " + this.danhSach.size());
	}

//5. lam rong danh sach sinh vien
	public void lamRongDSSV() {
		this.danhSach.removeAll(danhSach);
	}

//6. kiem tra sinh vien co trong danh sach khong (dua vao maSV)
	public boolean kiemTraSinhVien(SinhVien q) {
		return this.danhSach.contains(q);
	}

//7. xoa 1 sinh vien khoi danh sach dua tren ma sinh vien
	public void xoaSinhVien(SinhVien a) {
		this.danhSach.remove(a);
	}

//8. tim kiem tat ca sinh dua tren ten cua sinh vien do
	public void timKiemSinhVien(String x) {
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getFullName().indexOf(x) >= 0) {
				System.out.println(sinhVien);
			} else {
				System.out.println("khong co sinh vien nao!");
			}
		}
	}

//9. xuat ra danh sach sinh vien co diem trung binh tu cao toi thap
	public void sapXepDiemTB() {
		Collections.sort(this.danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getDiemTB() > o2.getDiemTB()) {
					return -1;
				} else if (o1.getDiemTB() < o2.getDiemTB()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	// 10 ghi danh sach sinh vien vao file
	public void ghiDanhSachSinhVien(String f) {

		try {
			File f1 = new File(f);
			OutputStream os;
			os = new FileOutputStream(f1);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			for (SinhVien sinhVien : danhSach) {
				oos.writeObject(sinhVien);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//11 doc file
	public void docAllFileDanhSachSinhVien(String g) {
		File f = new File(g);
		try {
		InputStream is = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(is);
		SinhVien sv = null;
		while(true) {
			sv = (SinhVien) ois.readObject();
			if(sv != null) {
				this.danhSach.add(sv);
			}else {
				break;
			}
		}ois.close();
	}catch (Exception e) {
	      e.printStackTrace();
	}
		}
}
