package de6;

import java.util.ArrayList;
import java.util.List;

public class ShareData {
	static List<String> listCapPhuong = new ArrayList<String>();
	static List<String> listQuan = new ArrayList<String>();
	static List<String> listCapCity = new ArrayList<String>();

	public static List<String> getListCapPhuong() {
		return listCapPhuong;
	}

	public static void setListCapPhuong(List<String> listCapPhuong) {
		ShareData.listCapPhuong = listCapPhuong;
	}

	public static List<String> getListQuan() {
		return listQuan;
	}

	public static void setListQuan(List<String> listQuan) {
		ShareData.listQuan = listQuan;
	}

	public static List<String> getListCapCity() {
		return listCapCity;
	}

	public static void setListCapCity(List<String> listCapCity) {
		ShareData.listCapCity = listCapCity;
	}
	
	
}
