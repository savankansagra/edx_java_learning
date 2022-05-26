package week5_dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class longestCommonSubseqof3 {
	public static void main(String[] args) {
		longestCommonSubseqof3 longestCommonSubseqof3Ob = new longestCommonSubseqof3();
		/* test input 1 */
//		int a[] = new int[] {1,2,3};
//		int b[] = new int[] {2,1,3};
//		int c[] = new int[] {1,3,5};
		
		/* test input 2 */
		int a[] = new int[] {8, 3, 2, 1, 7};
		int b[] = new int[] {8, 2, 1, 3, 8, 10, 7};
		int c[] = new int[] {6, 8, 3, 1, 4, 7};
		
		
		
		/*traveling index */
		int i=0;
		int j=0;
		int k=0;
		
		Map<twoKeyOneValueStructure, Integer> lookup = new HashMap<>();
		int resultLCM2 = longestCommonSubseqof3Ob.calculateLCMRecursiveDynamic(a,b,c,i,j,k,lookup);
		System.out.println(resultLCM2);
	}
	
	/*
	 * data structure for storing key as i,j
	 */
	private class twoKeyOneValueStructure{
		private int i;
		private int j;
		private int k;
		
		public twoKeyOneValueStructure(int i, int j, int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}
		public int getI() {
			return i;
		}
		public int getJ() {
			return j;
		}
		public int getK() {
			return k;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(i, j, k);
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
			return i == other.i && j == other.j && k == other.k;
		}
		private longestCommonSubseqof3 getEnclosingInstance() {
			return longestCommonSubseqof3.this;
		}
	}
	
	
	private int calculateLCMRecursiveDynamic(int[] a, int[] b, int[] c, int i, int j, int k, Map<twoKeyOneValueStructure, Integer> lookup ) {
		twoKeyOneValueStructure key = new twoKeyOneValueStructure(i,j,k);
		if(lookup.containsKey(key)) {
			return lookup.get(key);
		}
		
		if(i>=a.length || j>=b.length || k>=c.length) {
			return 0;
		}
		
		if(a[i] == b[j] && a[i] == c[k]) {
			int value = 1 + calculateLCMRecursiveDynamic(a, b, c, i+1, j+1, k+1, lookup);
			lookup.put(key, value);
			return value;
		} else {
			int value = Math.max(calculateLCMRecursiveDynamic(a, b, c, i, j, k+1, lookup),
							Math.max(calculateLCMRecursiveDynamic(a, b, c, i, j+1, k, lookup), 
								Math.max(calculateLCMRecursiveDynamic(a, b, c, i, j+1, k+1, lookup),
									Math.max(calculateLCMRecursiveDynamic(a, b, c, i+1, j, k, lookup),
										Math.max(calculateLCMRecursiveDynamic(a, b, c, i, j, k+1, lookup),
											Math.max(calculateLCMRecursiveDynamic(a, b, c, i+1, j, k+1, lookup),
												Math.max(calculateLCMRecursiveDynamic(a, b, c, i+1, j, k, lookup),
														Math.max(calculateLCMRecursiveDynamic(a, b, c, i, j+1, k, lookup),
																(calculateLCMRecursiveDynamic(a, b, c, i+1, j+1, k, lookup))))))))));
			lookup.put(key, value );
			return value;
		}
	}
}
