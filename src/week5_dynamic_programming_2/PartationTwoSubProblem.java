package week5_dynamic_programming_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PartationTwoSubProblem {
	public static void main(String[] args) {
		PartationTwoSubProblem partationTwoSubProblem = new PartationTwoSubProblem();
		
		int[] nums = new int[] {1,5,11,5};
		
		boolean resultTemp1 = partationTwoSubProblem.canPartition(nums);
		System.out.println(resultTemp1);
	}
	
	boolean canPartition(int[] nums) {
		int sum=0;
		for(int num:nums) {
			sum+=num;
		}
		if((sum & 1) == 1) {
			return false;
		} 
		sum/=2;
		
		int n = nums.length;
		boolean[][] dp = new boolean[n+1][sum+1];
		for(int i=0; i<dp.length;i++) {
			Arrays.fill(dp[i], false);
		} 
		
		dp[0][0] = true;
		
		for(int i=1;i<n+1;i++) {
			dp[i][0] = true;
		}
		
		for(int j=1;j<sum+1;j++) {
			dp[0][j] = false;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j >= nums[i-1]) {
					dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]] );
				}
			}
			
		}
		
		return dp[n][sum];
	}
	
	
}
