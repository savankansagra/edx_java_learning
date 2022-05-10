package week4_divide_and_conquer.sorting;

public class MergeSort {
	public static void main(String[] args) {
		//int[] input = new int[] {9,3,8,3,7,1};
		int[] input = new int[] {2,3,9,2,1,9};
		int n = 6;
		
		MergeSort mergeSort = new MergeSort();
		
		mergeSort.mergeSort(input, 0, input.length-1);
		
		mergeSort.printArray(input);
	}

	private void mergeSort(int[] input, int left, int right) {
		int mid = left + (right - left)/2;
		
		if(left < right) {
			mergeSort(input, left, mid);
			mergeSort(input, mid+1, right);
			
			merge(input, left, mid, right);
			
		}
		
	}

	private void merge(int[] input, int left, int mid, int right) {
		int k = 0;
		int tempArray[] =  new int[right-left+1];
		int leftPoint = left;
		int rightPoint = mid+1;
		
		for(int i=left; i<=right; i++) {
			
			if(leftPoint > mid && rightPoint <= right) {
				tempArray[k++] = input[rightPoint];
				rightPoint++;
				
			} else if(leftPoint <= mid && rightPoint > right) {
				tempArray[k++] = input[leftPoint];
				leftPoint++;
				
			}
			else if(input[leftPoint] > input[rightPoint] ) {
				tempArray[k++] = input[rightPoint];
				rightPoint++;
			} else if(input[leftPoint] <= input[rightPoint]) {
				tempArray[k++] = input[leftPoint];
				leftPoint++;			
			}
		}
		
		for(int i=left;i<=right;i++) {
			input[i] = tempArray[i-left];
		}
	}
	
	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
		
	}
}
