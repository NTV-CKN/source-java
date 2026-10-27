package SVRollNo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Thread1 extends Thread{
	SharedData sharedData;

	public Thread1(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	@Override
	public void run() {
		synchronized (sharedData) {
			File file = new File("D:\\File\\student.txt");
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String str = br.readLine();
				
				while(str != null) {
					if(Regex.check(str)) {
						sharedData.addValid(str);
						sharedData.setIndex(2);
						sharedData.setRollNo(str);
						sharedData.notifyAll();
						sharedData.wait();		
					}else{
						sharedData.addUnValid(str);
						sharedData.setIndex(3);
						sharedData.setRollNo(str);
						sharedData.notifyAll();
						sharedData.wait();		
					}
					try {
						str = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}//while
				sharedData.setBoole(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(br!=null) {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}//access file
		}//synchro1

		
		synchronized (sharedData) {
//			sharedData.setBoole(false);
			sharedData.notifyAll();	
		}
	}
}
