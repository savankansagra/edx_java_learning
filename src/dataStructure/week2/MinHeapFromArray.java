package dataStructure.week2;

public class MinHeapFromArray {
	public static void main(String[] args) {
		MinHeapFromArray minHeapFromArray = new MinHeapFromArray();
		
		/* Test case  1 */
		int n=5;
		int input[] = new int[n];
		input = new int[] {5,4,3,2,1};
		
		
		// call the function of heapify to build the heap.
		minHeapFromArray.arrayToMeanHeap(input,n);
		minHeapFromArray.printHeap(input);
	}

	private void arrayToMeanHeap(int[] input, int n) {
		//start index will be last non-leaf element
		int startIndex = (n/2)-1;
		int countOfSwap = 0;
		
		for(int i=startIndex;i>=0;i--) {
			buildMinHeap(input,n,i,countOfSwap);
		}
		
		
	}

	private void buildMinHeap(int[] input, int n, int i, int countOfSwap) {
		int smallest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left<n  && input[smallest] > input[left]) { //check if left child is smaller.
			smallest = left;
		}
		
		if(right<n && input[smallest] > input[right]) {
			smallest = right;
		}
		
		if(smallest != i) { //swap the elements
			int swap = input[i];
			input[i]=input[smallest];
			input[smallest] = swap;
			
			System.out.println(i+" "+smallest);
			
			buildMinHeap(input, n, smallest, countOfSwap);
		}
	
	}
	
	private void printHeap(int[] input) {
		for(int i:input) {
			System.out.print(i+" ");
		}
	}
}
