package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectSigneture {

	public static void main(String[] args) {
		CollectSigneture collectSigneture = new CollectSigneture();
		
		/* Test Case 1 */
//		int n = 3;
//		int aStart[] = {1,2,3};
//		int bEnd[] = {3,5,6};
		/* result
		 * 1
		 * 3
		 */
		
		/* Test Case 2 */
		int n = 4;
		int aStart[] = {4,1,2,5};
		int bEnd[] = {7,3,5,6};
		/* result
		 * 2
		 * 3 6
		 */
		
		
		System.out.println(collectSigneture.findMinumumVisit(n, aStart, bEnd));
		
	}

	private ArrayList<Integer> findMinumumVisit(int n, int[] aStart, int[] bEnd) {
		//Create HashMap 
		Map<Integer, Integer> inputHashMap = new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			inputHashMap.put(aStart[i], bEnd[i]);
		}
		
		//sort the hashmap by value
		ArrayList<Entry<Integer, Integer>> listOfInputHashMap = new ArrayList<>(inputHashMap.entrySet());
		listOfInputHashMap.sort(Entry.comparingByValue());
		inputHashMap.clear();
		int firstMinimumValue = listOfInputHashMap.get(0).getValue();
		for(Entry<Integer, Integer> entry: listOfInputHashMap) {
			inputHashMap.put(entry.getKey(), entry.getValue());
		}
		
		
		//Now make the iteration and find the points
		ArrayList<Integer> resultList = new ArrayList<>();
		resultList.add(firstMinimumValue);
		for(Entry<Integer, Integer> ent : inputHashMap.entrySet()) {
			if(ent.getKey() > resultList.get(resultList.size()-1)){
				resultList.add(ent.getValue());
			}
			
		}
		
		
		return resultList;
	}

	
	
}
