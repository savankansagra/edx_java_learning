package week4_divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistInPoints {
	public static void main(String[] args) {
		MinimumDistInPoints minimumDistInPoints = new MinimumDistInPoints();
		
		/* generate test case  
		 * 		plan size => 10 * 10
		 * 		number of points => 10
		 * */
		int xRange=100;
		int yRange=100;
		int numberOfPoints = 10;
		List<int[]> planPoints = minimumDistInPoints.generatePoints(xRange,yRange,numberOfPoints);
		
		// naive way of finding the closest pair.
//		double minimumDist = minimumDistInPoints.naiveClosestPair(planPoints, numberOfPoints );
//		System.out.println(minimumDist);
		
		//Optimal way using divide and conqure.
		
		
		
	}

	
	private double naiveClosestPair(List<int[]> planPoints, int numberOfPoints) {
		/*
		 *  function to find minimum distance between all the given points in planPoints.
		 *  
		 *   Args:
		 *   	planPonts: List of points [[1,7],[8,9]...]
		 *   	numberOfPoints: total point count 
		 *   
		 *   return:
		 *   	minimum distance between two points.
		 */
		double minDist = Double.MAX_VALUE;
		for(int i=0;i<numberOfPoints;i++) {
			for(int j=i+1;j<numberOfPoints;j++) {
				double dist = this.calculateDistance(planPoints.get(i), planPoints.get(j));
				if(minDist > dist) {
					minDist = dist;
				}
			}
		}
		
		return minDist;
	}

	
	
	private double calculateDistance(int[] p1, int[] p2) {
		/*
		 * Find the euclidean distance between two 2-D points
		 * formula => dist^2 = (y2-y1)^2 + (x2-x1)^2
		 * 
		 * Args:
		 * 		p1: (x1, y1)
		 * 		p2: (x2, y2) 
		 */
		return Math.sqrt(Math.pow(p2[1]-p1[1], 2) + Math.pow(p2[0]-p1[0], 2));
	}


	private List<int[]> generatePoints(int x, int y, int numberOfPoints) {
		/*
		 * Function to generate points in given plan
		 * 
		 * Args:
		 * 		x,y : size of plan x * y
		 * 		numberOfPoints : number of point to be generated in plan 
		 * 
		 * return:
		 * 		List of random points [(x1,y1), (x2,y2), ...]
		 */
		List<int[]> planPoints = new ArrayList<>();
		for(int i=0;i<numberOfPoints;i++) {
			int xPoint = (int) (Math.random()*x);
			int yPoint = (int) (Math.random()*y);
			planPoints.add(new int[] {xPoint,yPoint});
		}
		
		return planPoints;
	}
	
	
}
