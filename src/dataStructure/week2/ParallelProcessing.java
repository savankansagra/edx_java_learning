package dataStructure.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ParallelProcessing {
	public class finishJob{
		int indexOfWorker;
		int endTime;
		public finishJob() {
			super();
		}
		public finishJob(int indexOfWorker, int endTime) {
			super();
			this.indexOfWorker = indexOfWorker;
			this.endTime = endTime;
		}
		public int getIndexOfWorker() {
			return indexOfWorker;
		}
		public void setIndexOfWorker(int indexOfWorker) {
			this.indexOfWorker = indexOfWorker;
		}
		public int getEndTime() {
			return endTime;
		}
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		
	}
	
	public class resultStructure{
		int indexOfWorker;
		int jobStartTime;
		public resultStructure(int indexOfWorker, int jobStartTime) {
			super();
			this.indexOfWorker = indexOfWorker;
			this.jobStartTime = jobStartTime;
		}
		public resultStructure() {
			
		}
		
		public int getIndexOfWorker() {
			return indexOfWorker;
		}
		public void setIndexOfWorker(int indexOfWorker) {
			this.indexOfWorker = indexOfWorker;
		}
		public int getJobStartTime() {
			return jobStartTime;
		}
		public void setJobStartTime(int jobStartTime) {
			this.jobStartTime = jobStartTime;
		}
		@Override
		public String toString() {
			return  indexOfWorker + " " + jobStartTime;
		}
	}
	
	//finishArray is List of set that have number_of_worker and end_time
	List<finishJob> finishJobs = new ArrayList<>();
	List<resultStructure> result =  new ArrayList<>();

	private void initializeFinishJobForWorkers(int numberOfWorker) {
		for(int i=0;i<numberOfWorker;i++) {
			finishJobs.add(new finishJob(i, 0));
		}
	}


	private void nextJob(int i) {
		finishJob root = finishJobs.get(0); //take first worker from priority queue
		int indexOfWorker = root.getIndexOfWorker();
		int endTime = root.getEndTime();
		resultStructure resultOb = new resultStructure(indexOfWorker,endTime);
		result.add(resultOb);
		root.endTime += i; // added the execution time to the end time of finishJob.
		minifyHeap(0);
		
	}

	private void minifyHeap(int index) {
		int minIndex = index;
		int left = minIndex*2+1;
		int right = minIndex*2+2;
		if(left < finishJobs.size() && finishJobs.get(minIndex).getEndTime() > finishJobs.get(left).getEndTime()) {
			minIndex = left;
		}
		if(right < finishJobs.size() && finishJobs.get(minIndex).getEndTime() > finishJobs.get(right).getEndTime()) {
			minIndex = right;
		}
		//swap the elements
		if(index != minIndex) {
			Collections.swap(finishJobs, index, minIndex);
			minifyHeap(minIndex);
		}
	}
	
	public static void main(String[] args) {
		ParallelProcessing parallelProcessing = new ParallelProcessing();
		
		/* Test case 1 */
//		int numberOfWorker = 2;
//		int numberOfJob = 5;
//		int jobs[] = new int[] {1,2,3,4,5};
//		
		/* Test case 2 */
		int numberOfWorker = 4;
		int numberOfJob = 20;
		int jobs[] = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		
		//initialize finish job
		parallelProcessing.initializeFinishJobForWorkers(numberOfWorker);
		
		for(int i:jobs) {
			parallelProcessing.nextJob(i);
		}
		
		System.out.println(parallelProcessing.result);
		
	}
}
