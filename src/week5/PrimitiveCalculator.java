package week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimitiveCalculator {
	public static void main(String[] args) {
		PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();
		
		/* Test Case 1 */
		int n = 96234;
		
		Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		
		int result = primitiveCalculator.count(n, lookup);
		System.out.println(result);
		
		System.out.println("-------------");
		List<Integer> resultOptimal = primitiveCalculator.optimal_sequence(n);
		System.out.println(resultOptimal);
		
	}

	private int count(int n, Map<Integer, Integer> lookup) {
		if(lookup.containsKey(n)) {
			return lookup.get(n);
		}
		
		if(n==1) {
			return 0;
		} else {
			int result;
			if(n%2==0 && n%3==0) {
				result =1+ 
						//Math.min(count(n-1, lookup), 
					  Math.min(count(n/2, lookup), 
							count(n/3, lookup));
			} else if(n%2==0) {
				result = 1+ Math.min(count(n-1, lookup), 
						  		count(n/2, lookup));
			} else if(n%3==0) {
				result = 1+ Math.min(count(n-1, lookup), count(n/3, lookup));
			} else {
				result = 1+ count(n-1, lookup);
			}
			//System.out.println(result);
			lookup.put(n, result);
			return result;
		}
	}
	
	/*
	 * Below solution we got from the stack over flow.
	 * https://stackoverflow.com/questions/37019999/primitive-calculator-dynamic-approach
	 */
	private  List<Integer> optimal_sequence(int n) {
	    List<Integer> sequence = new ArrayList<>();

	    int[] arr = new int[n + 1];

	    for (int i = 1; i < arr.length; i++) {
	        arr[i] = arr[i - 1] + 1;
	        if (i % 2 == 0) arr[i] = Math.min(1 + arr[i / 2], arr[i]);
	        if (i % 3 == 0) arr[i] = Math.min(1 + arr[i / 3], arr[i]);

	    }

	    for (int i = n; i > 1; ) {
	        sequence.add(i);
	        if (arr[i - 1] == arr[i] - 1)
	            i = i - 1;
	        else if (i % 2 == 0 && (arr[i / 2] == arr[i] - 1))
	            i = i / 2;
	        else if (i % 3 == 0 && (arr[i / 3] == arr[i] - 1))
	            i = i / 3;
	    }
	    sequence.add(1);

	    Collections.reverse(sequence);
	    return sequence;
	}
}
