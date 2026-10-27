package java_BT55;

import java_BT55.SnhVien;


	public class SnhVien implements Comparable<SnhVien> {
		private int maSV;
		private String hoVaTen;
		private double diemTB;
		//constructor
		public SnhVien(int maSV, String hoVaTen, double diemTB) {
			super();
			this.maSV = maSV;
			this.hoVaTen = hoVaTen;
			this.diemTB = diemTB;
		}
		//getter and setter
		public int getMaSV() {
			return maSV;
		}
		public void setMaSV(int maSV) {
			this.maSV = maSV;
		}
		public String getHoVaTen() {
			return hoVaTen;
		}
		public void setHoVaTen(String hoVaTen) {
			this.hoVaTen = hoVaTen;
		}
		public double getDiemTB() {
			return diemTB;
		}
		//ham xu li
		public String getTen() {
			int luu = 0;
			String s = this.hoVaTen;
			s.trim();
			if(s.indexOf(" ") >= 0) {
				 luu = s.lastIndexOf(" ");
			}return s.substring(luu + 1);
		}
		@Override
		public void compareTo(SnhVien o) {
			String x = this.getTen();
			String y = o.getTen();
		if ( x.compareTo(y) < 0) {
			String temp = x;
			x = y;
			y = temp;
		}
		System.out.println();
		}
		@Override
		public String toString() {
			return "SnhVien [maSV=" + maSV + ", hoVaTen=" + hoVaTen + ", diemTB=" + diemTB + "]";
		}
}
