package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectSigneture {

	public static void main(String[] args) {
		CollectSigneture collectSigneture = new CollectSigneture();
		
		/* Test Case 1 */
		int n = 3;
		int aStart[] = {1,2,3};
		int bEnd[] = {3,5,6};
		/* result
		 * 1
		 * 3
		 */
		
		/* Test Case 2 */
//		int n = 4;
//		int aStart[] = {4,1,2,5};
//		int bEnd[] = {7,3,5,6};
		/* result
		 * 2
		 * 3 6
		 */
		
		SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer,Integer>();
		sortedMap.put(1, 3);
		sortedMap.put(2, 5);
		sortedMap.put(3,6);
		
		Set s = sortedMap.entrySet();
		System.out.println(s);
		
		collectSigneture.findMinumumVisit(n, sortedMap);
		
	}

	private void findMinumumVisit(int n, SortedMap<Integer, Integer> sortedMap) {
		List<Integer> resultList = new ArrayList<>();
		int left = sortedMap.firstKey();
		int right = sortedMap.get(sortedMap.firstKey());
		
		for(Map.Entry<Integer, Integer> iter : sortedMap.entrySet()) {
			int start = iter.getKey();
			int end = iter.getValue();
			if(left <= start && start <= right) {
				
			} else {
				resultList.add();
				left = start;
				right = end;
				
			}
		}
		
		
	}
}
