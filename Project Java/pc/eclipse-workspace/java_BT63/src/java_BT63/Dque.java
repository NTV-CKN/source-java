package java_BT63;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dque {
public static void main(String[] args) {
	Deque<String> vu1 = new ArrayDeque<String>();
	
	vu1.offer("Tao lay may");
	vu1.offer("Tao cung lay may");
	vu1.offerFirst("Thang kia");
	vu1.offerLast("Adu");
	int luu = vu1.size();
	for (int i = 0; i < luu; i++) {
		System.out.println(vu1.poll());
	}
}
}
