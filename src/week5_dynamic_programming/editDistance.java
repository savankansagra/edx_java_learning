package week5_dynamic_programming;

public class editDistance {
	public static void main(String[] args) {
		
		String s1="ab";
		String s2="ab";
		editDistance editDistanceOb = new editDistance();
		
		editDistanceOb.calculateDis(s1, s2);
	}

	private void calculateDis(String s1, String s2) {
		int i=s1.length()-1;
		int j=s2.length()-1;
		int minResult = calculateRecursive(s1,s2,i,j);
		System.out.println(minResult);
		
	}

	private int calculateRecursive(String s1, String s2, int i, int j) {
		if(i<0 || j<0) {
			return 0;
		} 
		
		if(s1.charAt(i)==s2.charAt(j)) {
			return Math.min(calculateRecursive(s1, s2, i-1, j-1),
						Math.min(calculateRecursive(s1, s2, i-1, j)+1, calculateRecursive(s1, s2, i, j-1)+1));
		} else {
			return Math.min(calculateRecursive(s1, s2, i-1, j-1)+1, 
						Math.min(calculateRecursive(s1, s2, i-1, j)+1, calculateRecursive(s1, s2, i, j-1)+1));
		}
		
	}

	
}
