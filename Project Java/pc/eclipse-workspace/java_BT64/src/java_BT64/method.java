package java_BT64;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.Random;
public class method{
	//private HashSet<String> vatChua;
 //public Object rutTham;
  Set<String> vatChua = new HashSet<String>();
 public method() {
 }
 //1 them 
 public void themMa (String v) {
       vatChua.add(v);
}
 //2 xoa 1 ma chi dinh
 public void xoaMa(String v) {
	 vatChua.remove(v);
 }
 //3 kiem tra ma so co ton tai
 public boolean kiemTraMa(String v) {
	 return vatChua.contains(v);
 }
 //4 xoa all
 public void xoaAll() {
	 vatChua.clear();
 }
 //5 lay so luong phieu
 public int laySoLuong() {
	 return vatChua.size();
 }
 //6 rut tham
public String rutTham() {
	Random rd = new Random();
	int luu = rd.nextInt(vatChua.size());
	String kq = "";
//	return (String)vatChua.toArray()[luu];
	Object arr[]=vatChua.toArray();
	kq = arr[luu]+"";
	return kq;
}
 //7 in ra toan bo 
public String inRaAll() {
     return 	vatChua.toString();
	
}

}
