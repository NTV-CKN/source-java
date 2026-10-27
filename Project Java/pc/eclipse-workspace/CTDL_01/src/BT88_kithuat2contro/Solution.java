package BT88_kithuat2contro;

public class Solution {
	public static void mergeTwo(int[] m1, int size1, int[] m2, int size2) {
		int i = size1 -1;
		int j = size2 -1;
		int k = (size1 + size2)-1;
		while(k>=0) {
			 if(i<0) {
				m1[k] = m2[j];
				j--;
			}else if(j<0) {
				m1[k] = m1[i];
				i--;
			}
			else if(m1[i] > m2[j] ) {
				m1[k] = m1[i];
				i--;
			}else if(m1[i] <= m2[j]) {
				m1[k] = m2[j];
				j--;
			}
			--k;			
	}	 
}
	public static void duyetMang(int[] m1, int size1, int[] m2, int size2) {
		for (int i : m2) {
			Solution.merge(i, m1, size1);
			size1++;
		}
	}
	public static void merge(int giaTri, int [] m1, int size) {
		boolean boo = false;
		for (int j = 0; j <= size; j++) {
			if(m1[j] > giaTri) {
				boo = true;
				for (int k = size ; k > j; k--) {
					m1[k] = m1[k - 1];
				}
					m1[j] = giaTri;
					break;
			}else if(boo == false) {
				m1[size] = giaTri;
			}
		}
	}
	
	
	
public static void main(String[] args) {
	int[] m1 = new int[] {3, 5, 6, 7, 0, 0, 0};//2
	int[] m2 = new int[] {2, 4, 6};
	for (int i : m1) {
		System.out.print(i+" ");
	}
	System.out.println("\n");
	//Solution.duyetMang(m1, 0,  m2,1);
	Solution.mergeTwo(m1, 4, m2, 3);
	for (int i : m1) {
		System.out.print(i+" ");
	}
}
}
