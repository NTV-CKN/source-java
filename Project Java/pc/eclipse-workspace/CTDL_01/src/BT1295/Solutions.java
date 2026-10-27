package BT1295;

public class Solutions {
	public static int duyetMang(int[] nums) {
		int bienDem = 0;
		for (int i : nums) {
			if(Solutions.demSoChuSo(i) % 2 ==0) {
				bienDem++;
			}
		}
		return bienDem;
	}
	public static int demSoChuSo(int a) {
	//	int kQ = a;
		int count = 0;
		int kQ = 0;
		while(	( a % 10) != 0) { 
			kQ = a/10;
			a = kQ;
			count++;
		}
		return count;
	}
	
public static void main(String[] args) {
	int[] nums = new int[] {12,3455 ,2,6,7896};
	System.out.println(Solutions.duyetMang(nums));

}
}
