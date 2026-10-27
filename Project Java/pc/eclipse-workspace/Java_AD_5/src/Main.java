import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Method method = new Method();
		 Student student;
		 List<Student> list = new ArrayList<Student>();
		 
		do {
			System.out.println("Press 1 to break" +"\n"+"Press 2 to scan"+"\n"+
		"Press 3 to print"+"\n"+"Press 4 to add list"+"\n"+"Press 5 to remove");
			int nhap = sc.nextInt();
			if(nhap == 1) {
				System.exit(0);
			}else if(nhap == 2) {
				System.out.println("Nhap ten ");
				String name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Nhap nam sinh ");
				int nam = sc.nextInt();
				System.out.println("Nhap id code ");
				int id = sc.nextInt();
				student = new Student(name, nam, id);		
			   method = new Method(student, list);
			}else if(nhap == 3) {
				method.printSV();
			}else if(nhap == 4) {
				method.addSV();
			}else if(nhap == 5) {
				method.removeSV();
			}
		}while(true);

	}

}
