package java_BT46;

public class SapXepChen implements SapXepInterface{

	@Override
	public void SapXepTang(double[] arr) {
     int i, j;
     double template;
     for(i = 1; i<arr.length; i++) {
    	 template = arr[i];
    	 j = i-1;
    	 while(j >= 0 && arr[j] > template) {
    		 arr[j + 1] = arr[j];
    		 j = j - 1;
    	 }arr[j+1] = template;
     }
	}

	@Override
		public void SapXepGiam(double[] arr) {
		     int i, j;
		     double template;
		     for(i = 1; i<arr.length; i++) {
		    	 template = arr[i];
		    	 j = i-1;
		    	 while(j >= 0 && arr[j] < template) {
		    		 arr[j + 1] = arr[j];
		    		 j = j - 1;
		    	 }arr[j+1] = template;
		     }
			}		
	}


