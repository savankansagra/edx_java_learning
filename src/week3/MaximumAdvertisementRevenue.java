package week3;

import java.util.Arrays;

public class MaximumAdvertisementRevenue {
	public static void main(String[] args) {
		MaximumAdvertisementRevenue maximumAdvertisementRevenue = new MaximumAdvertisementRevenue();
		/* Test Case 1 */
		int n = 3;
		int aProfit[] = {1,3,-5};
		int bClick[] = {-2,4,1};
		
		int result = maximumAdvertisementRevenue.calculateProfile(n, aProfit, bClick);
		System.out.println(result);
		
		
	}

	private int calculateProfile(int n, int[] aProfit, int[] bClick) {
		//idea is to sort both array in descending order then
		Arrays.sort(aProfit); // sort in ascending order.
		Arrays.sort(bClick); // sort in ascending order.
		
		// then do multiplication one by one element from both arrays.
		int result = 0; 
		for(int i = aProfit.length-1; i>=0; i--) {
			result = result + aProfit[i]*bClick[i];
		}
		
		return result;
	}
}
