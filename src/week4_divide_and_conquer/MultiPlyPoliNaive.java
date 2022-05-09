package week4_divide_and_conquer;

public class MultiPlyPoliNaive {
	public static void main(String[] args) {
		MultiPlyPoliNaive multiPlyPoliNaive = new MultiPlyPoliNaive();
		
		/* Test Case 1 */
		int a[] = new int[] {3,2,5}; // 3x^2 + 2x + 5
		int b[] = new int[] {5,1,2}; // 5x^2 + x + 2
		int n = 3;
		// result = [15,13,33,9,10]
		
		
		multiPlyPoliNaive.multiPlay(a,b,n);
	}

	private void multiPlay(int[] a, int[] b, int n) {
		int[] product = new int[2*n - 1];
		for(int i=0;i<2*n-2;i++) {
			product[i]=0;
		}
		
		// multiply it.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				product[i+j] = product[i+j] + a[i]*b[j];
			}
		}
		
		for(int i:product) {
			System.out.print(i+" ");
		}
	}
}
