package week2.LeastCommonDivisor;

import java.math.BigInteger;

import week2.gretestCommonDivisor.EcludingGCD;

public class LeastCommonDivisor {
	
	
	
	private int getLCM(int num1, int num2) {
		/* 
		 * We follows below formula to get LCM
		 * 
		 * LCM * GCD = n1 * n2;
		 */
		
		EcludingGCD ecliEcludingGCD = new EcludingGCD();
		int gcd = ecliEcludingGCD.getGCD(num1, num2);
		BigInteger lcm = (BigInteger.valueOf(num1).multiply(BigInteger.valueOf(num2))).divide(BigInteger.valueOf(gcd));
		int lcmInt = lcm.intValue();
		return lcmInt;
	}
	
	public static void main(String[] args) {
		int num1 = 28851538;
		int num2 = 1183019;
		LeastCommonDivisor leastCommonDivisor = new LeastCommonDivisor();
		int result = leastCommonDivisor.getLCM(num1,num2);		
		System.out.println(result);
		
	}

}
