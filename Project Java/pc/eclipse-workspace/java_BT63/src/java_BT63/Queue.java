package java_BT63;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue {
public static void main(String[] args) {
	java.util.Queue<String> vu = new LinkedList<String>();
	java.util.Queue<String> vu2 = new PriorityQueue<String>();
	//LinkedList
	System.out.println("LinkedList");
	vu.offer("Nguyen truong vu");
	vu.offer("Ngo kha qua nho");
	vu.offer("Ngo van thien"); 
	vu.offer("kakaka");
	int luu =vu.size() ;
	for (int i = 0; i <luu ; i++) {
		System.out.println(vu.remove());
	}
	//priorityList
	System.out.println("priorityList");
	vu2.offer("cai gi");
	vu2.offer("khong biet  gi");
	vu2.offer("au nua ba");
	int luu2 =vu2.size() ;
	for (int i = 0; i <luu2 ; i++) {
		System.out.println(vu2.poll());
	}
	
}
}
