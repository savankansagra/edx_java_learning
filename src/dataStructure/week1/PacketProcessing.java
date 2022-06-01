package dataStructure.week1;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class PacketProcessing {
	public static void main(String[] args) {
		PacketProcessing packetProcessing = new PacketProcessing();
		
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int n = sc.nextInt();
		
		packetProcessing.process(S, n, sc);
	}
	
	private class PacketInfo{
		int startTime;
		int totalTime;
		
		public PacketInfo(int startTime, int totalTime) {
			super();
			this.startTime = startTime;
			this.totalTime = totalTime;
		}
		
		public int getStartTime() {
			return startTime;
		}
		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}
		public int getTotalTime() {
			return totalTime;
		}
		public void setTotalTime(int totalTime) {
			this.totalTime = totalTime;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(startTime, totalTime);
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
			PacketInfo other = (PacketInfo) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return startTime == other.startTime && totalTime == other.totalTime;
		}
		private PacketProcessing getEnclosingInstance() {
			return PacketProcessing.this;
		}
	}
	

	private void process(int s, int n, Scanner sc) {
		Queue<PacketInfo> queue = new LinkedList<>();
		int processorRunningTill = 0;
		int currentBuffer = 1;
		for(int i=0;i<n;i++) {
			int start = sc.nextInt();
			int length = sc.nextInt();
			PacketInfo pi = new PacketInfo(start, length);
			if(currentBuffer <= s) {
				currentBuffer++;
				queue.add(pi);
			}
			PacketInfo processPi = queue.peek();
			if(processPi != null) {
				if(processorRunningTill <= processPi.getStartTime()) {
					queue.remove();
					currentBuffer--;
					processorRunningTill = processPi.getStartTime()+processPi.getTotalTime();
					System.out.println(processPi.getStartTime());
				}
			}
		}
		
	}
}
