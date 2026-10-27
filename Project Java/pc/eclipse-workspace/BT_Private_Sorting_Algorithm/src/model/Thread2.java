package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


import view.View;

public class Thread2 extends Thread {
	View v;
	public Thread2(View v) {
		this.v = v;
	}
	@Override
	public void run() {
		
		while (SharedData.getData().isAvailable()) {
			synchronized (SharedData.getData()) {
				SharedData.getData().notifyAll();
				while(SharedData.getData().index != 2) {
					try {
						SharedData.getData().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				boolean boo = true;
				for (int i = 0; i < v.nums.length; i++) {
					// set mau vong lap thu i
					v.label_1.get(i).setForeground(Color.RED);
					// trao doi data
					SharedData.getData().sendData(i, v.nums.length);

					for (int j = 0; j < v.nums.length - 1; j++) {
						SharedData.getData().setDemand("Doi mau");
						SharedData.getData().setJ(j);
						//SharedData.sendStringLabel(v.label_2.get(j).getText(), v.label_2.get(j + 1).getText());
						//wait notifyAll
						SharedData.getData().setIndex(1);
						SharedData.getData().notifyAll();
						try {
							SharedData.getData().wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						//
						if (v.nums[j] > v.nums[j + 1]) {
							SharedData.getData().setDemand("Doi vi tri");
							int swap = v.nums[j];
							v.nums[j] = v.nums[j + 1];
							
//						label_2.get(j).setText("" + nums[j + 1]);
							v.nums[j + 1] = swap;
//						label_2.get(j + 1).setText("" + swap);
							boo = false;
							SharedData.getData().setIndex(1);
							SharedData.getData().notifyAll();
							try {
								SharedData.getData().wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
					SharedData.getData().setDemand("Doi mau chuoi cuoi");
					SharedData.getData().setIndex(1);
					SharedData.getData().notifyAll();
					try {
						SharedData.getData().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					v.label_2.get(count + 1).setForeground(Color.GREEN);
//					v.label_2.get(count).setForeground(Color.BLACK);
					if (boo) {
						break;
					}
					v.label_1.get(i).setForeground(Color.WHITE);
				}
				SharedData.getData().setDemand("Loc mang");
				for (int i = 0; i < v.nums.length; i++) {
					SharedData.getData().setIndex(1);
//					v.label_2.get(i).setForeground(Color.GREEN);
					SharedData.getData().notifyAll();
					try {
						SharedData.getData().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//					this.setVisible(true);

			}
		}
		synchronized (SharedData.getData()) {
			SharedData.getData().notifyAll();
		}
	}

}
