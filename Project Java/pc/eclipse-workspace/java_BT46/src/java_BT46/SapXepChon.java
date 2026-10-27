package java_BT46;

public class SapXepChon implements SapXepInterface{

	@Override
	public void SapXepTang(double[] arr) {
       int i, j , sx;
       for(i = 0; i<arr.length-1; i++) {
    	   sx = i;
    	   for(j = 1 + i; j < arr.length; j++) {
    		   if (arr[sx] > arr[j]) {
    			   sx = j;
    		   }
    	   }
    			   double template = arr[sx];
    			   arr[sx] = arr[i];
    			   arr[i] = template;
    		   
    	   }
       }
	

	@Override
		public void SapXepGiam(double[] arr) {
		       int i, j , sx;
		       for(i = 0; i<arr.length-1; i++) {
		    	   sx = i;
		    	   for(j = 1 + i; j < arr.length; j++) 
		    		   if (arr[sx] < arr[j]) {
		    			   sx = j;
		    		   }
		    			   double template = arr[sx];
		    			   arr[sx] = arr[i];
		    			   arr[i] = template;
		    		   
		    	   }
		       }
}
	


