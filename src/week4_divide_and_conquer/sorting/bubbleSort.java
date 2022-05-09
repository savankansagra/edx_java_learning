package week4_divide_and_conquer.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bubbleSort {
	
	public static void main(String[] args) {
		/* Test Case 1 */
		//int A[] = new int[] {7,4,5,2};
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int total = Integer.parseInt(br.readLine());
			int A[] = new int[total];
			int count = 0;
			for(String i:br.readLine().split(" ")) {
				A[count++] = Integer.parseInt(i); 
			}

		
			bubbleSort bubbleSortOb = new bubbleSort();
			bubbleSortOb.sort(A,A.length);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void sort(int[] a, int length) {
		int swapCount = 0;
		int temp=0;
		for(int i=0;i<length;i++) {
			for(int k=0;k<length-i-1;k++) {
				if(a[k] > a[k+1]) {
					temp = a[k];
					a[k] = a[k+1];
					a[k+1] = temp;
					swapCount++;
				}
			}
				
		}
		
		
		System.out.println(swapCount);
	}
	
	
	
	
}
