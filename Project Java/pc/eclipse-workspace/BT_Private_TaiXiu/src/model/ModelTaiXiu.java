package model;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class ModelTaiXiu {
//	private String tai = "Tuyet voi!";
//	private String xiu = "Tuyet voi";
	private String kq;
	private int rd1 = 0;
	private String s="choi";
	private int rd2 = 0;
	private int rd3 = 0;
	private double tienHienCo = 50000000;
	private double tienCuoc = 0;
	private double tienConLai = 0;
	private String tienHienCoStr = "50.000.000", tienConLaiStr;
	public String getTienHienCoStr() {
		return tienHienCoStr;
	}
	public void setTienHienCoStr(String tienHienCoStr) {
		this.tienHienCoStr = tienHienCoStr;
	}
	public String getTienConLaiStr() {
		return tienConLaiStr;
	}
	public void setTienConLaiStr(String tienConLaiStr) {
		this.tienConLaiStr = tienConLaiStr;
	}
	private String chonTaiXiu = "TAI";
	//constructor
	public ModelTaiXiu() {
	}
	//getter and setter
	public String getKq() {
		return kq;
	}
	public void setKq(String kq) {
		this.kq = kq;
	}
	public double getTienHienCo() {
		return tienHienCo;
	}
	public void setTienHienCo(double tienHienCo) {
		this.tienHienCo = tienHienCo;
	}
	public double getTienCuoc() {
		return tienCuoc;
	}
	public void setTienCuoc(double tienCuoc) {
		this.tienCuoc = tienCuoc;
	}
	public double getTienConLai() {
		return tienConLai;
	}
	public void setTienConLai(double tienConLai) {
		this.tienConLai = tienConLai;
	}
	//method ranDom
	public int random() {
		Random rd = new Random();
		rd1 = rd.nextInt(5) + 1;
		rd2 = rd.nextInt(5) + 1;
		rd3 = rd.nextInt(5) + 1;
		int tong = rd1 + rd2 + rd3;
	   return tong;
	}
	//method chon tai xiu
	public void chonTaiXiu(String h) {
		this.setChonTaiXiu(h);
	}
	//method tung
	public void tungXucSac() {
		int random = this.random();
		if (random == 3 || random == 18) {
			this.tienConLai = this.tienHienCo - this.tienCuoc;
			this.setTienHienCo(this.tienConLai);
		this.setTienHienCoStr(this.numberf.format(tienHienCo));
		this.setTienConLaiStr(this.numberf.format(tienConLai));
			this.setTienConLai(this.tienConLai);
			this.setKq("Ban thua - So du hien tai la "+this.getTienConLaiStr()+"VND");
		} else if (random >= 4 && random<= 10) {
			if (this.chonTaiXiu.equals("TAI")) {
				this.tienConLai = this.tienHienCo - this.tienCuoc;	
				this.setTienHienCo(this.tienConLai);
				this.setTienConLai(this.tienConLai);
				this.setTienHienCoStr(this.numberf.format(tienHienCo));
				this.setTienConLaiStr(this.numberf.format(tienConLai));
				this.setKq("Ban thua - So du hien tai la "+this.getTienConLaiStr()+"VND");
			} else if (this.chonTaiXiu.equals("XIU")) {
				this.tienConLai = this.tienHienCo + this.tienCuoc;	
				this.setTienHienCo(this.tienConLai);
				this.setTienConLai(this.tienConLai);	
				this.setTienHienCoStr(this.numberf.format(tienHienCo));
				this.setTienConLaiStr(this.numberf.format(tienConLai));
				this.setKq("Ban thang - So du hien tai la "+this.getTienConLaiStr()+"VND");
			}
		} else if (random >= 11 && random <= 17) {
			if (this.chonTaiXiu.equals("TAI")) {
				this.tienConLai = this.tienHienCo + this.tienCuoc;		
				this.setTienHienCo(this.tienConLai);
				this.setTienConLai(this.tienConLai);
				this.setTienHienCoStr(this.numberf.format(tienHienCo));
				this.setTienConLaiStr(this.numberf.format(tienConLai));
				this.setKq("Ban thang - So du hien tai la "+this.getTienConLaiStr()+"VND");
			} else if (this.chonTaiXiu.equals("XIU")) {
				this.tienConLai = this.tienHienCo - this.tienCuoc;	
				this.setTienHienCo(this.tienConLai);
				this.setTienConLai(this.tienConLai);	
				this.setTienHienCoStr(this.numberf.format(tienHienCo));
				this.setTienConLaiStr(this.numberf.format(tienConLai));
				this.setKq("Ban thua - So du hien tai la " +this.getTienConLaiStr()+"VND");
			}
			}
		}
	//public void format() {
		Locale locale = new Locale("vi", "VN");
		NumberFormat numberf = NumberFormat.getInstance(locale);
	
	
	public int getRd1() {
		return rd1;
	}
	public void setRd1(int rd1) {
		this.rd1 = rd1;
	}
	public int getRd2() {
		return rd2;
	}
	public void setRd2(int rd2) {
		this.rd2 = rd2;
	}
	public int getRd3() {
		return rd3;
	}
	public void setRd3(int rd3) {
		this.rd3 = rd3;
	}
	public String getChonTaiXiu() {
		return chonTaiXiu;
	}
	public void setChonTaiXiu(String chonTaiXiu) {
		this.chonTaiXiu = chonTaiXiu;
	}
	
}
