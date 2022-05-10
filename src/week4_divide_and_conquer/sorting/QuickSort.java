package week4_divide_and_conquer.sorting;

import java.util.Arrays;
import java.util.Random;


public class QuickSort {
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		
		/* Test Case 1 */
		int input[] = new int[] {6,7,8,3,2,1,15,24,48,100,1523,10,6,8,5,4,2,3};
		//generate 10000 elements
//		int input[] = new int[100000];
//		for(int i=0;i<100000;i++) {
//			input[i] = (int) (Math.random()*(100000));
//		}
//		
		
		int input2[] = Arrays.copyOf(input, input.length);
		
		
		int start =0;
		int end = input.length;
		
		long startTime = System.nanoTime();
		quickSort.sort(input, start, end);
		long finishTime = System.nanoTime();
		System.out.println("total time to selecting first pivot => "+ (finishTime-startTime));
		
		//using random partation
		long startTimeRandom = System.nanoTime();
		quickSort.randompartationsort(input2, start,end);
		long finishTimeRandom = System.nanoTime();
		System.out.println("total time to random pivot =>"+(finishTimeRandom-startTimeRandom));
		
		quickSort.printArray(input);
		
	}

	private void randompartationsort(int[] input, int start, int end) {

		int random = (int) (start + Math.random()*(end-start+1));
		swap(input, start, random);
		sort(input, start, end);
		
	}

	private void sort(int[] input, int start, int end) {
		if(start<end) {
			int piv_pos = partation(input,start,end);
			sort(input, start, piv_pos);
			sort(input, piv_pos+1, end);
		}
		
	}

	private int partation(int[] input, int start, int end) {
		int pivot = start;
		int i = start+1;  //the index between less then pivot and greater then pivot elements.
		// j is index between partitioned and unpartationed elements.
		for(int j=start+1;j<end;j++) {
			if(input[j] < input[pivot]) {
				swap(input,i,j);
				i++;
			}
		}
		//swap the pivot at right position
		swap(input, pivot, i-1);
		return i-1;
	}

	private void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
		
	}
}
