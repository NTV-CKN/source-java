package Thang;

public enum Thang {
	JANUARY (31), //thang1
	FEBUARY (31), //thang 2
	MARCH(31),//thang 3
	APRIL(31),//thang 4
	MAY(31), //thang 5
	JUNE(31), //thang 6
	JULY(31), //thang 7
	AUGUST(31),//thang 8
	 SEPTEMBER(31),//thang 9
	 OCTOBER(31),//thang 10
	 NOVEMBER(31),//thang 11
	 DECEMBER(30);//thang 12
	private final  int thoiGian;
	private Thang(int tg) {
		this.thoiGian = tg;
	}

	public int getThang() {
		return this.thoiGian;
	}
}
