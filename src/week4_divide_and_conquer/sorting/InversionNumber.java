package week4_divide_and_conquer.sorting;

import javax.print.DocFlavor.INPUT_STREAM;

public class InversionNumber {
	
	int countOfInversion = 0;
	
	public static void main(String[] args) {
		InversionNumber inversionNumber = new InversionNumber();
		
		/* test case 1 */
		int a[] = new int[] {2,3,9,2,1,9};
		int n=4;
		
		int left=0;
		int right=a.length-1;
		
		inversionNumber.countOfInversion = 0;
		inversionNumber.inverse(a,left,right);
		System.out.println(inversionNumber.countOfInversion);
		
		inversionNumber.printArray(a);
		
	}

	private void inverse(int[] a, int left, int right) {
		int mid= left+( right-left)/2;
		
		if(left < right) {
			inverse(a, left, mid);
			inverse(a, mid+1, right);
			
			merge(a,left,mid,right);	
		}
	}

	
	private void merge(int[] a, int left, int mid, int right) {
		int k=0;
		int tempArray[] = new int[right-left+1];
		int leftPoint = left;
		int rightPoint = mid+1;
		
		for(int i=left;i<=right;i++) {
			
			if(leftPoint > mid && rightPoint <= right) {
				tempArray[k++] = a[rightPoint];
				rightPoint++;
			} else if (leftPoint <= mid && rightPoint > right) {
				tempArray[k++] = a[leftPoint];
				leftPoint++;
			} else if (a[leftPoint] > a[rightPoint]) {
				tempArray[k++] = a[rightPoint];
				rightPoint++;
				countOfInversion = countOfInversion+(mid-leftPoint+1);
			} else if(a[leftPoint] <= a[rightPoint]) {
				tempArray[k++] = a[leftPoint];
				leftPoint++;
			}
		}
		
		for(int i=left; i<=right; i++) {
			a[i] = tempArray[i-left];
		}		
	}
	
	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
	}

}
