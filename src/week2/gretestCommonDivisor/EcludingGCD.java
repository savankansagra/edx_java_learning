package week2.gretestCommonDivisor;

public class EcludingGCD {
	
	public int getGCD(int num1, int num2) {
		int gcdAns = 1;
		
		while(num1 >= 0 && num2 >= 0) {
			//It can dividedbal
			if(num1 == 0) {
				gcdAns = num2;
				break;
			} else if (num2 == 0) {
				gcdAns = num1;
				break;
			} else if(num1 > num2) {
				if(num1 % num2 == 0) {
					gcdAns = num2;
					break;
				} else {
					num1 = num1 % num2;
				}
			} else if (num2 >= num1) {
				if(num2 % num1 == 0) {
					gcdAns = num1;
					break;
				} else {
					num2 = num2 % num1;
				}
			}
		}
					
		return gcdAns;
	}
	
	public static void main(String[] args) {
		int num1 = 28851538;
		int num2 = 1183019;
		EcludingGCD ecludingGCD = new EcludingGCD();
		int result = ecludingGCD.getGCD(num1,num2);
		System.out.println(result);
	}
}
