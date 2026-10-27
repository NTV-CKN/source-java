package java_BT57;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Vu_choi_tai_xiu {
	public static void main(String[] args) {
		Scanner vc = new Scanner(System.in);
		double soTien = 5000000;
		double soTienSauPhanUng = 0;
		int chon = 0;
		int rd1 = 0;
		int rd2 = 0;
		int rd3 = 0;
		int chonTaiXiu;
		Locale lc = new Locale("vi", "VN");
		NumberFormat num = NumberFormat.getCurrencyInstance(lc);
		do {
			System.out.println("MOI BAN LUA CHON: ");
			System.out.println("\t Bam 1 de choi");
			System.out.println("\t Bam cac so con lai de thoat");
			chon = vc.nextInt();
			if (chon == 1) {
				System.out.println("****SO DU BAN DANG CO LA: " + num.format(soTien));
				System.out.println("***BAN MUON CUOC BAO NHIEU");
				double tienCuoc = vc.nextDouble();
				if (tienCuoc > soTien || tienCuoc < 0) {
					System.out.println("***SO TIEN CUOC KHONG HOP LE!");
					do {
						System.out.println("***NHAP LAI: ");
						tienCuoc = vc.nextDouble();

					} while (tienCuoc > soTien && tienCuoc < 0);
				}

				System.out.println("***SO TIEN BAN DAT CUOC LA: " + num.format(tienCuoc));

				do {
					System.out.println("***VUI LONG CHON 1 LA TAI HOAC 2 LA XIU ");
					chonTaiXiu = vc.nextInt();
				} while (chonTaiXiu > 2 || chonTaiXiu < 1);

				System.out.println("***TIEN HANH TUNG XUC SAC");
				Random rd = new Random();
				rd1 = rd.nextInt(5) + 1;
				rd2 = rd.nextInt(5) + 1;
				rd3 = rd.nextInt(5) + 1;
				int tong = rd1 + rd2 + rd3;

				System.out.println("****XUC SAC THU DUOC LA: " + rd1 + "-" + rd2 + "-" + rd3);
				System.out.println("****TONG THU DUOC LA: " + (tong));
				if (tong == 3 || tong == 18) {
					System.out.println("****NHA CAI AN HET");
					soTienSauPhanUng = soTien - tienCuoc;
					System.out.println("****SO TIEN CON LAI CUA BAN LA: " + (num.format(soTienSauPhanUng)));
				} else if (tong >= 4 && tong <= 10) {
					if (chonTaiXiu == 1) {
						System.out.println("****BAN DA THUA");
						soTienSauPhanUng = soTien - tienCuoc;
						System.out.println("****SO TIEN CON LAI CUA BAN LA: " + (num.format(soTienSauPhanUng)));
					} else if (chonTaiXiu == 2) {
						System.out.println("****BAN DA THANG");
						soTienSauPhanUng = soTien + tienCuoc;
						System.out.println("****SO TIEN DUOC THUONG LA: " + (num.format(soTienSauPhanUng)));
					}
				} else if (tong >= 11 && tong <= 17) {
					if (chonTaiXiu == 2) {
						System.out.println("****BAN DA THUA");
						soTienSauPhanUng = soTien - tienCuoc;
						System.out.println("****SO TIEN CON LAI CUA BAN LA: " + (num.format(soTienSauPhanUng)));
					} else if (chonTaiXiu == 1) {
						System.out.println("****BAN DA THANG");
						soTienSauPhanUng = soTien + tienCuoc;
						System.out.println("****SO TIEN DUOC THUONG LA: " + (num.format(soTienSauPhanUng)));
					}
				}

			}
		} while (chon == 1);
	}
}
