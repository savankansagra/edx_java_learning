package week4_divide_and_conquer;

import java.util.ArrayList;
import java.util.Collections;
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
		
		minimumDistInPoints.printPlane(planPoints);
		
		// naive way of finding the closest pair.
//		double minimumDist = minimumDistInPoints.naiveClosestPair(planPoints, numberOfPoints );
//		System.out.println(minimumDist);
		
		//Optimal way using divide and conqure.
		minimumDistInPoints.closestPair(planPoints);
		
		System.out.println("minimum distance => "+ minimumDistInPoints.bestDistance
				+ "\n the points are p1 =>"+ minimumDistInPoints.best1[0] + ","+minimumDistInPoints.best1[1]
				+ "\n the points are p2 =>"+ minimumDistInPoints.best2[0] + ","+minimumDistInPoints.best2[1]);
		
	}


	private double bestDistance = Double.MAX_VALUE;
	private int[] best1;
	private int[] best2;

	
	private void closestPair(List<int[]> planPoints) {
		/* validation of points */
		if(planPoints == null) throw new IllegalArgumentException("plan points are null");
		for(int i=0;i<planPoints.size(); i++) {
			if(planPoints.get(i) == null) {
				throw new IllegalArgumentException("array element "+i+" is null");
			}
		}
			
		
		int n = planPoints.size();
		if(n<=1) return;
		
		//sort by x-coordinates
		Collections.sort(planPoints, (o1,o2) -> {
			if(o1[0]-o2[0] < 0) {
				return -1;
			} else if(o1[0] - o2[0] > 0) {
				return 1;
			} else {
				if(o1[1] - o2[1] < 0) {
					return -1;
				} else if(o1[1] - o2[1] > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		printPlane(planPoints);
		
		//check for coincident points
		for(int i=0;i<n-1;i++) {
			if(planPoints.get(i).equals(planPoints.get(i+1))) {
				bestDistance = 0.0;
				best1 = planPoints.get(i);
				best2 = planPoints.get(i+2);
			}
		}
		
		// auxiliary array.
		List<int[]> aux = new ArrayList<>(n);
		
		closest(planPoints, aux, 0, n-1);
		
		
	}


	private double closest(List<int[]> planPoints, List<int[]> aux, int lo, int hi) {		
		if(hi <= lo) return Double.POSITIVE_INFINITY;
		
		//if total points are less then three then Calculate all possibility.
		if(hi-lo <3) {
			double delta = Double.POSITIVE_INFINITY;
			for(int i=lo;i<hi;i++) {
				for(int j=i+1;j<=hi;j++) {
					double distance = calculateDistance(planPoints.get(j), planPoints.get(i));
					if(distance < delta) {
						delta = distance;
						if(delta < bestDistance) {
							bestDistance=delta;
							best1 = planPoints.get(i);
							best2 = planPoints.get(j);
						}
					}
				}
			}
			return delta;
		}
		
		
		int mid = lo + (hi-lo)/2;
		int[] midPoint = planPoints.get(mid);
		
		double delta1 = closest(planPoints, aux, lo, mid);
		double delta2 = closest(planPoints, aux, mid+1, hi);
		double delta = Math.min(delta1, delta2);
		
		//sort aux array element by y cordinates.
		merge(planPoints, aux, lo, mid, hi);		
		
		// Points in L and R within delta of x median,
		int m=0;
		for(int i=lo;i<=hi;i++) {
			if(Math.abs(planPoints.get(i)[0] - midPoint[0]) < delta) {
				aux.add(planPoints.get(i));
				m++;
			}
		}
		
		
		
		//compare each point to its neighbors with y-coordinate closer then delta.
		for(int i=0;i<m;i++) {
			for(int j=i+1; (j<m) && (aux.get(j)[1] - aux.get(i)[1] < delta);j++){
				double distance = calculateDistance(aux.get(j), aux.get(i));
				if(distance < delta) {
					delta = distance;
					if(delta < bestDistance) {
						bestDistance=delta;
						best1 = aux.get(i);
						best2 = aux.get(j);
					}
				}
			}
		}
		
		return delta;
	}


	private void merge(List<int[]> planPoints, List<int[]> aux, int lo, int mid, int hi) {
		List<int[]> tempArray = new ArrayList<int[]>();
		
		int l=0;
		for(int i=lo;i<=hi;i++) {
			tempArray.add(planPoints.get(i));
			l++;
		}
		
		
		//sort into tempArray.
		int i=lo, j=mid+1;
		for(int k=0;k<l;k++) {
			if(i > mid) {
				tempArray.add(k, planPoints.get(j++));
			} else if(j > hi) {
				tempArray.add(k, planPoints.get(i++));
			} else if(planPoints.get(i)[1] - planPoints.get(j)[1] > 0) {
				tempArray.add(k,planPoints.get(i));
				i++;
			} else {
				tempArray.add(k, planPoints.get(j));
				j++;
			}
		}
		
		//merge back to aux.
		for(int m=0;m<l;m++) {
			aux.add(lo+m,tempArray.get(m));
		}
		
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
	
	
	private void printPlane(List<int[]> planPoints) {
		System.out.print("[");
		for(int[] i:planPoints) {
			System.out.print("("+i[0]+","+i[1]+")");
		}
		System.out.println("]");
	}
}
