package thuchanh2;

import java.util.List;

public class Utils {
	public static void backtrack(List<Integer> state) {
		printListState(state, "List neightbours null, backtrack:");
	}
	
	public static void printListState(List<Integer> states, String msg) {
		System.out.print(msg);
		for(Integer state: states) {
			System.out.print(" " + state);
		}
		System.out.println();
	}
}
