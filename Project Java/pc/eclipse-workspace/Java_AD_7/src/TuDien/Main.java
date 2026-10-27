package TuDien;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int save;
	do {
	System.out.println("PRESS 1 TO START\nPRESS ANY NUM TO EXIT");
	save = sc.nextInt();
	if(save == 1) {
		Method.start();
	}
	} while (save == 1);
}
}
