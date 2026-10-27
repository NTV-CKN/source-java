package Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {
	private Student student;
	Scanner sc = new Scanner(System.in);
	List<Student> listStudent = new ArrayList<Student>();
	int save = 0;
	public void start() {
		try {
				do {
			System.out.println("PRESS 1 TO ADD STUDENT\nPRESS 2 TO SEARCH STUDENT BY ID"
				+ "\nPRESS 3 TO REMOVE BY ID\nPRESS 4 TO SORT BY NAME\nPRESS 5 TO PRINT\n"
				+ "PRESS 6 TO CHANGE STUDENT\nPRESS 7 TO WRITE STUDENT REST\nPRESS 8 TO READ\nPRESS ANY NUMBER TO EXIT"
				+ "\nPRESS 9 TO CLEAR REST");
			save  = sc.nextInt();
			if(save == 1) {
				String name = "";String id = "";String address = "";String xLoai="";
				name = Regex.isRegexName();
				id = Regex.isRegexId();
				System.out.println("Nhap address: ");
				sc.nextLine();
				address = sc.nextLine();
				System.out.println("Nhap loai");
				xLoai = sc .nextLine();
				student = new Student(name, address, id, xLoai);
				listStudent.add(student);
				continue;
			}else if(save == 5) {
				Iterator<Student> duyet = listStudent.iterator();
				while(duyet.hasNext()) {
					Student next = duyet.next();
					System.out.println(next);
				}
			}else if(save == 2) {
				String idN = Regex.isRegexId();
				for(int i = 0; i<listStudent.size(); i++) {
					Student student = listStudent.get(i);
					if(student.isId(idN)) {
						System.out.println(student);
						break;
					}
				}
			}else if(save == 3) {
				String idN = Regex.isRegexId();
				for(int i = 0; i<listStudent.size(); i++) {
					Student student = listStudent.get(i);
					if(student.isId(idN)) {
						listStudent.remove(i);
						break;
					}
				}
			}else if(save == 4) {
				listStudent.sort(student);
			}else if(save == 6) {
				for(int i = 0; i<listStudent.size(); i++) {
					Student student = listStudent.get(i);
					String idN = Regex.isRegexId();
					if(student.isId(idN)) {
						String name = "";String id = "";String address = "";String xLoai="";
						name = Regex.isRegexName();
						id = Regex.isRegexId();
						System.out.println("Nhap address: ");
						sc.nextLine();
						address = sc.nextLine();
						System.out.println("Nhap loai");
						xLoai = sc .nextLine();
						student = new Student(name, address, id, xLoai);
						listStudent.set(i, student);
						break;
					}
				}
			}else if(save == 7) {
				
				 File file = new File("D:\\File\\dssv.txt");
			        try {
			            if (!file.exists()) {
			                file.createNewFile();
			            }
			            try (FileOutputStream fos = new FileOutputStream(file, true)) {
			                for (Student student : listStudent) {
			                    String str = student.toString();
			                    byte[] data = str.getBytes();
			                    fos.write(data);
			                    fos.flush();
			                }
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				}else if(save == 8) {
					 File file = new File("D:\\File\\dssv.txt");
				        FileInputStream fis = null;
				        try {
				            fis = new FileInputStream(file);
				            int code;
				            if (file.exists()) {
				                while ((code = fis.read()) != -1) {
				                    char c = (char) code;
				                    System.out.print(c);
				                }
				            }
				        } catch (IOException e) {
				            e.printStackTrace();
				        } finally {
				            if (fis != null) {
				                try {
				                    fis.close();
				                } catch (IOException e) {
				                    e.printStackTrace();
				                }
				            }
				        }
					
					}else if(save == 9) {
						 File file = new File("D:\\File\\dssv.txt");
						 if(file.exists()) {
							 file.delete();
						 }
					}
				}while (save >= 1 &&save<=8);
				
			}catch (Exception e) {
				System.err.println("LOI");
		}
		} 
		} 

	

