package thunghiem;

import java.util.HashMap;

public class Exam {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// for cow 6ms
	public static ListNode hasCycle1(ListNode head) {
		if (head == null) {
			return null;
		}
		HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		ListNode temp = head;
		while (temp.next != null) {
			if (map.containsKey(temp)) {
				return temp;
			} else if (!map.containsKey(temp)) {
				map.put(temp, temp.val);
			}
			temp = temp.next;
		}
		return null;
	}

	// two pointers 1ms
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		int index = 0;
		ListNode point1 = head;
		ListNode point2 = head;
		while (point2.next != null) {
			point2 = point2.next;
			if (point1 == point2) {
				return true;
			}
			if (index == 2) {
				point1 = point1.next;
				index = 0;
			}
			index++;
		}
		return false;
	}
	// hash 5ms

	//two pointers 0ms
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode point1 = head;
		ListNode point2 = head;
		while (point1.next != null) {
			point1 = point1.next.next;
			point2 = point2.next;
			if (point1 == null) {
				return null;
			}
			if (point1 == point2) {
				point1 = head;
				while (point1 != point2) {
					point1 = point1.next;
					point2 = point2.next;
				}
				return point2;
			}
		}
		return null;
	}

	public static void m(int i, int j) {

	}
}
