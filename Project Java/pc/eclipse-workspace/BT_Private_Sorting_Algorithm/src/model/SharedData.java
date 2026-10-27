package model;

public class SharedData {
	static int i = 0, lengthArr = 0;
	static String label_1 = "";
	static String label_2 = "";
	static String demand = "";
	static SharedData sharedData = null;
	static int j = 0;
	static int index = 0;
	public static SharedData getData() {
		if (sharedData == null) {
			sharedData = new SharedData();
		}
		return sharedData;
	}

	public boolean isAvailable() {
		return i < lengthArr;
	}

	public static void sendData(int index, int length) {
		i = index;
		lengthArr = length;
	}

	public static void sendStringLabel(String lable1, String lable2) {
		label_1 = lable1;
		label_2 = lable2;
	}
	
	public static void setJ(int indexJ) {
		j = indexJ;
	}
	
	public static void setDemand(String str) {
		demand = str;
	}
	
	public static void setIndex(int i) {
		index = i;
	}
}
