package week2.fibonakiNumber;

public class FirstNativeRecursive {

	private int fibonakiNative(int i) {
		if( i <= 1) {
			return i;
		} else {
			return fibonakiNative(i-1)+ fibonakiNative(i-2);
		}
	}
	
	public int fibonakiNativeWithloop(int i) {
		int []fiboArray = new int[i+1];
		fiboArray[0] = 0;
		
		if(i==0) {
			fiboArray[0] = 0;
		} else {
			fiboArray[0] = 0;
			fiboArray[1] = 1;
		} 
		
		
		for(int k=2;k<=i;k++) {
			fiboArray[k] = fiboArray[k-1] + fiboArray[k-2];
		}
		
		return fiboArray[i];
	}
	
	
	public static void main(String[] args) {
		FirstNativeRecursive firstNativeRecursive = new FirstNativeRecursive();
		
//		// call the recursive call
//		int result = firstNativeRecursive.fibonakiNative(45);
//		System.out.println(result);
		
//		//call loop
		int result = firstNativeRecursive.fibonakiNativeWithloop(5);
		System.out.println(result);
		
		
		
		
	}
}
