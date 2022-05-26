package week5_dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestCommonSubseqof2 {
	public static void main(String[] args) {
		LongestCommonSubseqof2 longestCommonSubseqof2Ob = new LongestCommonSubseqof2();
		/* test input 1 */
		int a[] = new int[] {2, 7, 5,8,9,10,11,12};
		int b[] = new int[] {2, 5,8,9,10,11,12};
		
		/*traveling index */
		int i=0;
		int j=0;
		
		
		int resultLCM = longestCommonSubseqof2Ob.calculateLCMRecursive(a,b,i,j);
		System.out.println(resultLCM);
		
		Map<twoKeyOneValueStructure, Integer> lookup = new HashMap<>();
		int resultLCM2 = longestCommonSubseqof2Ob.calculateLCMRecursiveDynamic(a,b,i,j, lookup);
		System.out.println(resultLCM2);
	}

	private int calculateLCMRecursive(int[] a, int[] b, int i, int j) {
		if(i>=a.length || j>=b.length) {
			return 0;
		}
		
		if(a[i] == b[j]) {
			return 1+calculateLCMRecursive(a, b, i+1, j+1);
		} else {
			return Math.max(calculateLCMRecursive(a, b, i, j+1),
					Math.max(calculateLCMRecursive(a, b, i+1, j), calculateLCMRecursive(a, b, i+1, j+1)));
		}
	}
	
	
	/*
	 * data structure for storing key as i,j
	 */
	private class twoKeyOneValueStructure{
		int i;
		int j;
		
		public twoKeyOneValueStructure(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}


		public int getJ() {
			return j;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(i, j);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			twoKeyOneValueStructure other = (twoKeyOneValueStructure) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return i == other.i && j == other.j;
		}

		private LongestCommonSubseqof2 getEnclosingInstance() {
			return LongestCommonSubseqof2.this;
		}
		
		

	}
	
	
	private int calculateLCMRecursiveDynamic(int[] a, int[] b, int i, int j, Map<twoKeyOneValueStructure, Integer> lookup ) {
		twoKeyOneValueStructure key = new twoKeyOneValueStructure(i,j);
		if(lookup.containsKey(key)) {
			return lookup.get(key);
		}
		
		if(i>=a.length || j>=b.length) {
			return 0;
		}
		
		if(a[i] == b[j]) {
			int value = 1+calculateLCMRecursiveDynamic(a, b, i+1, j+1, lookup);
			lookup.put(key, value);
			return value;
		} else {
			int value = Math.max(calculateLCMRecursiveDynamic(a, b, i, j+1, lookup),
					Math.max(calculateLCMRecursiveDynamic(a, b, i+1, j, lookup), calculateLCMRecursiveDynamic(a, b, i+1, j+1, lookup))); 
			lookup.put(key, value );
			return value;
		}
	}
	
}
