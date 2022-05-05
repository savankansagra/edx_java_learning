package week3;

import java.util.ArrayList;

public class MaximumNumberPrise {
	public static void main(String[] args) {
		MaximumNumberPrise maximumNumberPrise = new MaximumNumberPrise();
		
		int n=1000;
		/*
		 * Test Case 1
		 */
		//int n=6;
		/*
		 * result => 1 2 3
		 */
		
		/*
		 * Test Case 2
		 */
//		int n=8;
		/*
		 * result => 1 2 5
		 */
		
		/*
		 * Test Case 3
		 */
//		int n=12;
		/*
		 * result => 1 2 3 6
		 */
		
		maximumNumberPrise.getMaxPriseCount(n-1, 1);
		maximumNumberPrise.printResult();
	}

	

	ArrayList<Integer> result = new ArrayList<>();

	private int getMaxPriseCount(int n, int level) {
		if(n <= level) {
			if(!result.contains(n+level)) {
				result.add(n+level);
			}
			return 0;
		}
		else {
			result.add(level);
			level += 1;
			return getMaxPriseCount(n-level, level);
		}
	}
	
	private void printResult() {
		System.out.println(result.size());
		System.out.println(result);
	}
}
