package ex4;

import java.util.Scanner;

/*
 * phan test nay gia dinh user la mot con nguoi ki tinh, moi thu ho lam
 * deu co su ki luong dan den viec khong bi mac loi trong qua trinh nhap lieu.
 * 
 * Mo ta cach hoat dong: moi lan khoi dong tro choi thi he thong se quay random ket qua
 * sau do user chon in ve so, ve so nay duoc luu tai thu tu thu i cua danh sach cac agent trong
 * company, trong do con so duoc tao ra se duoc luu vao danh sach numberString. Khi muon 
 * do ve so thi tu trong ket qua APrize co danh sach cac Result, trong company co danh sach cac APrize
 * tuong ung 3 ve so 6_45/55, mega4. De lay ket qua thi user phai chon 1 trong 3 prize de thuc hien do ve so
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Company company = new Company();
		int choose = 0;
		System.out.println("Cu moi khi khoi dong tro choi thi he thong se tao ra cac con so trung thuong"
				+ "\n==========================================================");
		company.randomPrize();
		System.out.println("==========================================================");

		try {
			while (choose != 4) {
				System.out.println("***CHAO MUNG BAN CHOI SO XO***\n" + "Chon cac lua chon sau de tien hanh choi:\n"
						+ "Nhan 1 de in ve so\nNhan 2 de thong ke dai li co nhieu ve trung\n"
						+ "Nhan 3 de do ve so\nNhan 4 de thoat tro choi");
				System.out.println("Ban chon: " + (choose = sc.nextInt()));
				if (choose == 1) {
					System.out.println("Nhap vao 1 so tuong ung chay tu 0 den " + Utils.sizeLottery
							+ " tuong ung thu tu cac dai li trong company");
					System.out.println("Ve duoc tao la: " + company.createLottery(sc.nextInt()));
				} else if (choose == 2) {
					String nameLottery = "";
					sc.nextLine();
					System.out.println("Nhap date theo dinh dang dd/mm/yyyy ");
					String date = sc.nextLine();
					
					System.out.println("Tu 0 - 2 hay nhap 1 so tuong ung voi " + "6_45, 6_55, mega4");
					int num = sc.nextInt();
					while (num > 2 && num < 0) {
						System.out.println("Ban lua chon khong phu hop, moi chon lai ");
						num = sc.nextInt();
					}
					String textNum = "";
					if (num == 0) {
						nameLottery = Utils.NAME_6_45;
						textNum = enterNumber(6, 1, 45);
					}
					if (num == 1) {
						nameLottery = Utils.NAME_6_55;
						textNum = enterNumber(6, 1, 55);
					}
					if (num == 2) {
						nameLottery = Utils.NAME_MEGA;
						textNum = enterNumber(4, 1, 24);
					}
					System.out.println(
							company
							.getResultByPrizeDate(date, textNum, nameLottery)
							);

				} else if (choose == 3) {
					int chooseLottery = 0;
					try {
						System.out.println("Hien tai tro choi co 3 ve so 6_45, 6_55, mega4\n"
								+ "Vui long chon so tu 0 den 2 ung voi thu tu 3 ve so tren de chon");
						System.out.println("So ban da chon la " + (chooseLottery = sc.nextInt()));
						String str = "", result = "";
						if (chooseLottery == 0) {
							str = enterNumber(6, 1, 45);
							result = company.checkLotteryPrize(str, chooseLottery);
						} else if (chooseLottery == 1) {
							str = enterNumber(6, 1, 55);
							result = company.checkLotteryPrize(str, chooseLottery);
						} else if (chooseLottery == 2) {
							str = enterNumber(4, 1, 24);
							result = company.checkLotteryPrize(str, chooseLottery);
						}
						if (result.equals(""))
							System.out.println("Khong tim thay");
						else
							System.out.println(result);
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("So ban nhap khong hop le!");
					}
				} else if (choose == 4) {
					System.exit(0);
				} else {
					System.out.println("Moi ban nhap lai");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Nhap sai, vui long chay lai!");
		}

	}

	private static String enterNumber(int max, int origin, int bound) {
		Scanner enter = new Scanner(System.in);
		StringBuilder strB = new StringBuilder();
		int num = 0;
		System.out.println("Nhap " + max + " moi lan nhap 1 so ");

		int index = 0;
		try {
			while (max - 1 > index) {
				System.out.println("So " + (index + 1) + " " + (num = enter.nextInt()));
				strB.append(num + ", ");
				index++;
			}
			System.out.println("So " + (index + 1) + " " + (num = enter.nextInt()));
			strB.append(num);
			return strB.toString();
		} catch (Exception e) {
			System.err.println("Loi tai enter number");
			return "";
		}
	}
}
