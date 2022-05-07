package week4_divide_and_conquer;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		
		/* Test Case 1 */
//		int n = 5;
//		int input[] = new int[] {2,3,9,2,2};
		
		/* Test Case 2 */
//		int n=4;
//		int input[] = new int[] {1,2,3,4};
		
		/* Test Case 3 */
		int n=4;
		int input[] = new int[] {1,2,3,1};
		
		//int result = majorityElement.calulateNaive(n,input);
		int result = majorityElement.calculateFast(n, input);
		System.out.println(result);
		
	}

	private int calulateNaive(int n, int[] input) {
		int flag = 0;
		for(int i=0;i<n;i++) {
			int currentElement = input[i];
			int count=0;
			for(int j=0;j<n;j++) {
				if(currentElement == input[j] ) {
					count++;
				}
			}
			if(count > n/2) {
				flag = 1;
				break;
			}
		}
		
		return flag;
	}
	
	@SuppressWarnings("unused")
	private int calculateFast(int n, int[] input){
		//first find the maximum repeat element.
		int maxIndex = 0;
		int count = 0;
		for(int i=0;i<n;i++) {
			if(input[i] == input[maxIndex]) {
				count++;
			} else {
				count--;
			}
			
			if(count == 0) {
				maxIndex = i;
				count = 1;
			}	
		}
		
		//Check the frequency of max element.
		count=0;
		for(int i=0;i<n;i++) {
			if(input[maxIndex] == input[i]) {
				count++;
			}
			if(count > n/2) {
				return 1;
			}
				
		}
		
		return 0;
	}
}
