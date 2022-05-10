package week4_divide_and_conquer.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizingLottery {
	public static void main(String[] args) {
		OrganizingLottery organizingLottery = new OrganizingLottery();
		
		/* Test Case 1 */
		int stotal = 3;
		int ptotal = 2;
		
		List<List<Integer>> segments = new ArrayList<>();
		segments.add(Arrays.asList(0,5));
		segments.add(Arrays.asList(-3,2));
		segments.add(Arrays.asList(7,10));
		
		List<Integer> points = Arrays.asList(1,6);
		
		List<Integer> result =organizingLottery.findOccurance(stotal, ptotal, segments, points);
		System.out.println(result);
		
	}

	private List<Integer> findOccurance(int stotal, int ptotal, List<List<Integer>> segments, List<Integer> points) {
		//sort the segments by first index of it.
		List<List<Integer>> sortedSegements = segments.stream().sorted((o1,o2) -> {
			if(o1.get(0) < o2.get(0)) {
				return -1;
			} else if(o1.get(0) > o2.get(0)) {
				return 1;
			} else {
				//both first position of elements are same.
				if(o1.get(1) < o2.get(1)) {
					return -1;
				} else if(o1.get(1) > o2.get(1)) {
					return 1;
				}
				return 0;
			}
		}).collect(Collectors.toList());
		
		//System.out.println(sortedSegements); // sorted segment is in ascending order.
		
		
		//naive loop to find the point
		List<Integer> result = new ArrayList<>();
		
		Iterator<Integer> iteratPoint = points.iterator();
		while(iteratPoint.hasNext()) {
			Iterator<List<Integer>> iterat = sortedSegements.iterator();
			int point = iteratPoint.next();
			int pointCount = 0;
			while(iterat.hasNext()) {
				List<Integer> seg = iterat.next();
				if(seg.get(0)<=point && point <= seg.get(1)) {
					pointCount++;
				}
			}
			result.add(pointCount);
		}
		
		
		return result;
	}
}
