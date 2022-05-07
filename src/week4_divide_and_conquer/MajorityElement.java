package week4_divide_and_conquer;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		
		/* Test Case 1 */
		//int n = 5;
		//int input[] = new int[] {2,3,9,2,2};
		
		/* Test Case 2 */
		int n=4;
		int input[] = new int[] {1,2,3,4};
		
		int result = majorityElement.calulateNaive(n,input);
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
}
