package BT27_kithuat2contro;

public class Solution {
	public static void remove(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[k] = nums[i];
				k++;
			}
		}
	}
	//for long nhau
 public static int removeElement(int[] nums, int val) {
	 int n = nums.length;
	 int i;
	 for (i = 0; i < n; ) {
		 if(nums[i] == val) {
			 for (int j = i; j < n - 1; j++) {
				 nums[j] = nums[j + 1];
			}
			 n--;
		}else {
			i++;
		}
	}
	 return i;
  }
public static void main(String[] args) {
	int[] nums1 = new int[]{0,1,2,2,3,0,4,1};
	//System.out.println(nums1.length);
	for (int i : nums1) {
		System.out.print(i);
	}
	System.out.println("\n");
	//System.out.println(	Solution.removeElement(nums1, 2));
	Solution.remove(nums1, 2);
	for (int i : nums1) {
		System.out.print(i);
	}

	
}
}
