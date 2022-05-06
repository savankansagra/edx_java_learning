package week4_divide_and_conquer;

public class BinarySearch {
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		
		/* test Case 1 */
		int n = 5;
		int inputArray[] = new int[] {1,5,8,12,13};
		int totalTest = 5;
		int testCaseArray[] = new int[] {8,1,23,1,-8};
		
		int tempResult = -1;
		for(int test : testCaseArray) {
			tempResult = binarySearch.searchTargetElement(inputArray,0,inputArray.length,test);
			System.out.print(tempResult + " ");
		}
				
	}

	private int searchTargetElement(int[] inputArray, int left, int right, int test) {
		if(left>=right) {
			return -1;
		}
		int midIndex = left + (right-left)/2;
		if(inputArray[midIndex] == test) {
			return midIndex;
		} else if(test < inputArray[midIndex]) {
			right = midIndex-1;
		} else if(test > inputArray[midIndex]) {
			left = midIndex+1;
		}
		
		return searchTargetElement(inputArray, left, right, test);
	}
}
