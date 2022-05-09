package week4_divide_and_conquer.sorting;

public class selectionSort {
	public static void main(String[] args) {
		selectionSort selectionSortOb = new selectionSort();
		
		int[] input= new int[] {1, 5, 3, 8, 2};
		
		selectionSortOb.sort(input);
		selectionSortOb.printArray(input);
	}

	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
		
	}

	private void sort(int[] input) {
		int n = input.length;
		for(int i=0;i<n;i++) {
			int minIndex = i;
			for(int j=i;j<n;j++) {
				if(input[minIndex] > input[j]) {
					minIndex = j;
				}
			}
			//swap the element.
			int temp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = temp;
		}
		
	}
}
