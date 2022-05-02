package week2.fibonakiNumber;

public class FirstNativeRecursive {

	private int fibonakiNative(int i) {
		if( i <= 1) {
			return i;
		} else {
			return fibonakiNative(i-1)+ fibonakiNative(i-2);
		}
	}
	
	
	
	public static void main(String[] args) {
		FirstNativeRecursive firstNativeRecursive = new FirstNativeRecursive();
		int result = firstNativeRecursive.fibonakiNative(45);
		System.out.println(result);
		
	}
}
