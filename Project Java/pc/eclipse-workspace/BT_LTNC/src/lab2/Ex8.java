package lab2;

public class Ex8 {

	public static String getYearCanChi(int year) {
		int startYear = 1984;// The year start cycle lunar calendar of Chinese
		int offset = (year - startYear) % 60;
		int canIndex = offset % 10;
		int chiIndex = offset % 12;
		String can = "";
		String chi = "";

		switch (canIndex) {
		case 9:
			can = "Quy";
			break;
		case 0:
			can = "Giap";
			break;
		case 1:
			can = "At";
			break;
		case 2:
			can = "Binh";
			break;
		case 3:
			can = "Dinh";
			break;
		case 4:
			can = "Mau";
			break;
		case 5:
			can = "Ki";
			break;
		case 6:
			can = "Canh";
			break;
		case 7:
			can = "Tan";
			break;
		case 8:
			can = "Nham";
			break;
		}

		switch (chiIndex) {
		case 11:
			chi = "Hoi";
			break;
		case 0:
			chi = "Ty";
			break;
		case 1:
			chi = "Suu";
			break;
		case 2:
			chi = "Dan";
			break;
		case 3:
			chi = "Mao";
			break;
		case 4:
			chi = "Thin";
			break;
		case 5:
			chi = "Ty";
			break;
		case 6:
			chi = "Ngo";
			break;
		case 7:
			chi = "Mui";
			break;
		case 8:
			chi = "Than";
			break;
		case 9:
			chi = "Dau";
			break;
		case 10:
			chi = "Tuat";
			break;
		}

		return can + " " + chi;
	}

	public static void main(String[] args) {
		System.out.println(Ex8.getYearCanChi(1998));
		System.out.println(Ex8.getYearCanChi(2005));
		System.out.println(Ex8.getYearCanChi(2006));
		System.out.println(Ex8.getYearCanChi(2024));
	}
}
