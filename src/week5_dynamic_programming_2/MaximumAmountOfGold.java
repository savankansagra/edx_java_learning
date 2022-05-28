package week5_dynamic_programming_2;

public class MaximumAmountOfGold {
	public static void main(String[] args) {
		MaximumAmountOfGold maximumAmountOfGold = new MaximumAmountOfGold();
		
		//Test Case 1
		int W = 10;
		int n = 3;
		int input[] = new int[] {1, 4, 8};
		int total = 0;
		
		int output = maximumAmountOfGold.calculateMax(W,n-1,input,total);
		System.out.println(output);
	}

	private Integer calculateMax(int W, int i, int[] input, int total) {
		if(i<0) {
			return 0;
		} 
		
		if(input[i] > W) {
			return calculateMax(W, i-1, input, total);
		} else {
			return Math.max(calculateMax(W-input[i], i-1, input, total)+input[i], calculateMax(W, i-1, input, total));
		}
	}
}
