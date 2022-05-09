package week4_divide_and_conquer.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		
		int[] input = new int[] {1,5,4,6,8};
		int n = input.length;
		
		insertionSort.sort(n, input);
		insertionSort.printArray(input);
	}

	private void sort(int n, int[] input) {
		for(int i=0;i<n;i++) {
			int temp = input[i];
			int j = i;
			while(j>0 && temp > input[j-1]) {
				input[j]=input[j-1];
				j = j-1;
			}
			input[j] = temp;
		}
		
	}
	
	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
		
	}
}
