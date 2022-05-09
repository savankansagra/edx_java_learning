package week4_divide_and_conquer.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlaceLine {
	public static void main(String[] args) throws Exception{
		//take input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCase = Integer.parseInt(br.readLine());
		
		int totalHouse = 0;
		int details[][] = null;
		
		while(numberOfTestCase-- > 0) {
			//take input from user
			totalHouse = Integer.parseInt(br.readLine());
			details = new int[totalHouse][3];
			for(int i=0;i<totalHouse;i++) {
				String input = br.readLine();
				for(int k=0;k<3;k++) {
					String each[] = input.split(" ");
					details[i][k] = Integer.parseInt(each[k]);
				}
			}
			
			// Sort the given array
			// Use Bubble sort for sorting array.
			PlaceLine placeLine = new PlaceLine();
			placeLine.sort(totalHouse,details);	
			//System.out.println("ok sorting");
			
			
			String result = placeLine.isPosibleToPlot(totalHouse, details);
			System.out.println(result);
			
		}

		
	}

	private String isPosibleToPlot(int totalHouse, int[][] details) {
		 
		boolean resultFlag = false;
		
		/*
		 * Plot all the possible line.
		 *  
		 */
		//find minimum value of x axis points
		int minimumX = Integer.MAX_VALUE;
		int mimimumXindex = 0;
		for(int i=0;i<totalHouse;i++) {
			if(minimumX > details[i][0]) {
				minimumX = details[i][0];
				mimimumXindex = i;
			}
		}
		
		//find maximum value if x axis points
		int maximumX = Integer.MIN_VALUE;
		int maximumXindex = totalHouse -1;
		for(int i=0;i<totalHouse;i++) {
			if(maximumX < details[i][0]) {
				maximumX = details[i][0];
				maximumXindex = i;
			}
		}
		
		//find minimum value of y axis points
		int minimumY = Integer.MAX_VALUE;
		int minimumYindex = 0;
		for(int j=0;j<totalHouse;j++) {
			if(minimumY > details[j][1]) {
				minimumY = details[j][1];
				minimumYindex = j;
			}
		}
		
		//find maximum valoe of y axis points
		int maximumY = Integer.MIN_VALUE;
		int maximumYindex = 0;
		for(int j=0;j<totalHouse;j++) {
			if(maximumY > details[j][1]) {
				maximumY = details[j][1];
				maximumYindex = j;
			}
		}
		
		
		
		// formula for plotting x=y parallel line is
		// Y = X + yCordinate - xCordinate
		// check for all x axis point
		for(int k=minimumX;k<=maximumX;k++) {
			int tempX = k;
			int tempY = maximumY;
			
			//line equation will  be 
			// Y = X + tempY - tempX
			if(this.countOnBothSide(tempX, tempY, totalHouse, details)) {
				resultFlag = true;
				break;
			}
		}
		
		//check for all y axis points
		if(!resultFlag) {
			for(int k=minimumY;k<=maximumY;k++) {
				int tempX = maximumX;
				int tempY = k; 
				
				if(this.countOnBothSide(tempX, tempY, totalHouse, details)) {
					resultFlag = true;
					break;
				}
			}
		}
		
		//Return result
		if(resultFlag) {
			return "YES";
		} else {
			return "NO";
		}
	}

	
	
	private boolean countOnBothSide(int tempX, int tempY, int totalHouse, int[][] details) {
		//line equation will  be 
		// Y = X + tempY - tempX
		
		int leftSideCount = 0;
		int rightSideCount = 0;
		for(int l=0;l<totalHouse;l++) {
			//check for above side
			// pointY > pointX + tempY - tempX
			if(details[l][1] > details[l][0] + tempY - tempX) {
				leftSideCount += details[l][2];
			}
			
			//check for below side
			// PointY < PointX + tempY - tempX
			if(details[l][1] < details[l][0] + tempY - tempX) {
				rightSideCount += details[l][2];
			}
			
		}
	
		// compare both result
		if(leftSideCount == rightSideCount) {
			return true;
		}
		return false;
	}

	private void sort(int totalHouse, int[][] details) {
		for(int i=0;i<totalHouse;i++) {
			for(int j=0;j<totalHouse-i-1;j++) {
				if(details[j][2] > details[j+1][2]) {
					//swap elements.
					int temp[] = details[j];
					details[j] = details[j+1];
					details[j+1] = temp;
				}
			}
		}
	}
	
	
}
