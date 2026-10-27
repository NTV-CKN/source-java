package SVRollNo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Thread3 extends Thread{
	SharedData sharedData;

	public Thread3(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sharedData.boole == true) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				while(sharedData.getIndex() != 3) {
					try {
						sharedData.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(sharedData.boole == false) {
						break;
					}
				}//whilecon
				if(sharedData.boole == false) {
					break;
				}
				System.out.println("Unvalid roll number: "+sharedData.rollNoo);
				sharedData.setIndex(1);
				
				File file = new File("D:\\File\\unvalid.txt");
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
					fw = new FileWriter(file, true);	
					bw = new BufferedWriter(fw);
					bw.write(sharedData.rollNoo);
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(bw!=null) {
						try {
							bw.close();	
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				}	
			}//syn3
		}//whilebo
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
	}
}
