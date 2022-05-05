package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumSalary {
	public static void main(String[] args) {
		MaximumSalary maximumSalary = new MaximumSalary();
		
		// Test Case 1
//		int n = 2;
//		int input[] = new int[] {21,2};
		
		//Test Case 2
//		int n = 3;
//		int input[] = new int[] {23, 39, 92};

		//Test Case 3
//		int n=5;
//		int input[] = new int[] {9, 4, 6, 1, 9};
		
		//Test Case 4
		int n=4;
		int input[] = new int[] {21, 219, 39, 391};
		
		
		System.out.println(maximumSalary.calculateMaxSalary(n, input));
	}

	private String calculateMaxSalary(int n, int[] input) {
		
		//convert int[] to arrayList.
		ArrayList<Integer> inputArrayList = (ArrayList<Integer>) Arrays.stream(input).boxed().collect(Collectors.toList());
		
		String ans = "";
		while(!inputArrayList.isEmpty()) {
			Integer maxDigit = 0;
			for(Integer digit: inputArrayList) {
				if(getGreaterThenOrEqual(maxDigit, digit)) {
					maxDigit = digit;
				}
			}
			ans = ans+maxDigit;
			inputArrayList.remove(maxDigit);
		}
				
		return ans;
	}

	private boolean getGreaterThenOrEqual(Integer maxDigit, Integer digit) {
		boolean ans = true;
		String maxDigitString = maxDigit.toString();
		String digitString = digit.toString();
		int tempDi = 0;
		
		while(!maxDigitString.isEmpty() && !digitString.isEmpty() ) {
			int firstInMaxDigit = Integer.parseInt(maxDigitString.substring(0, 1));
			int firstInDigit = Integer.parseInt(digitString.substring(0,1));
			
			if(firstInMaxDigit == firstInDigit) {
				if(maxDigitString.length() == 1) {
					tempDi = Integer.parseInt(maxDigitString);
				} else if (digitString.length() == 1) {
					tempDi = Integer.parseInt(digitString);
				}
				maxDigitString =  maxDigitString.substring(1);
				digitString = digitString.substring(1);
				
				if(maxDigitString.length() == 0) {
					if(tempDi < Integer.parseInt(digitString.substring(0,1))){
						ans=true; 
					} else {
						ans=false;
					}
				} else if( digitString.length() == 0) {
					if(tempDi < Integer.parseInt(maxDigitString.substring(0,1))){
						ans=false ;
					}  else {
						ans = true;
					}
				}		
				continue;
				
			} else if (firstInMaxDigit < firstInDigit) {
				ans = true;
				break;
				
			} else if(firstInMaxDigit > firstInDigit) {
				ans = false;
				break;
			}
		}
		
		
			
			
		return ans;
	}
}
