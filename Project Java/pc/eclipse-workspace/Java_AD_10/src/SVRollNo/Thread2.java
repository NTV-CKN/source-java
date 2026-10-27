package SVRollNo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Thread2 extends Thread{
	SharedData sharedData;

	public Thread2(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	@Override
	public void run() {	
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sharedData.boole == true) {
			synchronized (sharedData) {
				sharedData.notifyAll();
					while(sharedData.getIndex() != 2) {
						try {
							sharedData.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(sharedData.boole == false) {
							break;
						}
					}//whileNho
					if(sharedData.boole == false) {
						break;
					}
					System.out.println("Welcome: " + sharedData.getRollNo());
					System.out.println("Valid collection has length: "+sharedData.listValid.size());
					sharedData.setIndex(1);
			
					File file = new File("D:\\File\\"+sharedData.rollNoo+".dat");
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					FileOutputStream fos=null;
					ObjectOutputStream oos= null;
						try {	
						 fos = new FileOutputStream(file);
						 oos = new ObjectOutputStream(fos);
						 oos.writeObject(sharedData.listValid.get(sharedData.listValid.size()-1));						 
						} catch (IOException e) {
						e.printStackTrace();
						}finally {
							try {
							oos.close();	
							fos.close();
							} catch (IOException e) {
							e.printStackTrace();
							}	
						}				
			}//syn2
		}//whileLon
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
	}
}
