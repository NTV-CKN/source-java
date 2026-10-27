package java_BT65;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class Map {
java.util.Map<String, String > map = new TreeMap<String , String>();

//Them tu
public void themTu(String k, String v) {
	map.put(k, v);
}
//Xoa tu
public void xoaTu(String k) {
	map.remove(k);
}
//Tra tu
public String traTu(String k) {
        return map.get(k);
}
//in ra danh sach tu khoa
public void inDSKey() {
	Set<String> in = this.map.keySet();
	System.out.println(Arrays.toString(in.toArray()));
}
//in ra danh sach gia tri
public void inDSValue() {
	Collection<String> in = this.map.values();
	System.out.println(Arrays.toString(in.toArray()));
}
//in so luong tu
public int inSoLuong() {
	return this.map.size();
}
//xoa all
public void xoaAll() {
	this.map.clear();
}
}
