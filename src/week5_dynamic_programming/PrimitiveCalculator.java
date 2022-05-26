package week5_dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveCalculator {
	public static void main(String[] args) {
		PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();
		
		//test case 1
		int num=5;
		
		/*
		 * we can perform three operations
		 * 1) a + 1
		 * 2) 2*a
		 * 3) 3*a 
		 */
		
		
		// Expected result => 1 2 4 5
		
		Map<Integer, Integer> resultMap = new HashMap<>();
		
		primitiveCalculator.calculate(num,1,resultMap);
		
				
	}

	private Integer calculate(int num, int start, Map<Integer, Integer> resultMap) {
		if(start == num) {
			return -1;
		} 
		if(resultMap.containsKey(start)) {
			return resultMap.get(start);
		} else {
			int d1 = calculate(num, start+1, resultMap);
			int d2 = calculate(num, start*2, resultMap);
			int d3 = calculate(num, start*3, resultMap);
			int min = Math.min(d1, Math.min(d2, d3));
			return min;
		}
		
	}
}
