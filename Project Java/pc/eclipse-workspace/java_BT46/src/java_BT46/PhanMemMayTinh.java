package java_BT46;

public class PhanMemMayTinh implements MayTinhBoTuiInterface, SapXepInterface {

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
	@Override
	public double plus(double a, double b) {
		return a+b;
	}

	@Override
	public double except(double a, double b) {
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
		public void divide(double a, double b) {
		    try {
				System.out.println(a/b);
			} catch (ArithmeticException e) {
		        System.out.println("loi chia 0!");
			}
	}


}
