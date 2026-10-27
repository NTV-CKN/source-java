package model;

import java.awt.Color;

import view.View;

public class Thread1 extends Thread {
	public Thread1(View v) {
		this.v = v;
	}
	View v;
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(SharedData.getData().isAvailable()) {
			synchronized (SharedData.getData()) {
				SharedData.getData().notifyAll();
				while(SharedData.getData().index != 1) {
					try {
						SharedData.getData().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(SharedData.demand.equals("Doi mau")) {
					v.label_2.get(SharedData.getData().j).setForeground(Color.YELLOW);
					v.label_2.get((SharedData.getData().j +1)).setForeground(Color.YELLOW);
				}else if(SharedData.demand.equals("Doi vi tri")) {
					v.label_2.get(SharedData.getData().j).setText("" + v.nums[(SharedData.getData().j)+ 1]);
					v.label_2.get((SharedData.getData().j) + 1).setText("" + v.nums[SharedData.getData().j]);	
				}else if(SharedData.demand.equals("Doi mau chuoi cuoi")) {
					v.label_2.get((SharedData.getData().j) + 1).setForeground(Color.GREEN);
					v.label_2.get(SharedData.getData().j).setForeground(Color.BLACK);
				}else {
					v.label_2.get(SharedData.getData().j).setForeground(Color.GREEN);
				}
				v.setVisible(true);
				SharedData.getData().setIndex(2);
				SharedData.getData().notifyAll();
				try {
					SharedData.getData().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		synchronized (SharedData.getData()) {
			SharedData.getData().notifyAll();
		}
	}
}
