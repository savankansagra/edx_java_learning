package week2.fibonakiNumber;

public class LastDigitOfFiboNumber {

	private String addIntOfStringType(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();

		//reverse the strings.
		s1 = new StringBuilder(s1).reverse().toString();
		s2 = new StringBuilder(s2).reverse().toString();
		String resultReverse = new String();
		
		//do addition one by one digit
		int cess = 0;
		int maxLen = s1Len > s2Len ? s1Len : s2Len;
		
		for(int i=0;i<=maxLen;i++) {
			if(i<s1Len && i<s2Len) {
				int temp = Character.getNumericValue(s1.charAt(i)) + Character.getNumericValue(s2.charAt(i));
				int tempAdd = (temp + cess);
				resultReverse += String.valueOf(tempAdd % 10);
				cess = tempAdd / 10;
			} else if(i<s1Len) {
				int temp = Character.getNumericValue(s1.charAt(i));
				int tempAdd = (temp + cess);
				resultReverse += String.valueOf(tempAdd % 10);
				cess = tempAdd / 10;
			} else if(i < s2Len) {
				int temp = Character.getNumericValue(s2.charAt(i));
				int tempAdd = (temp + cess);
				resultReverse += String.valueOf(tempAdd % 10);
				cess = tempAdd / 10;
			} else if(cess > 0) {
				resultReverse += String.valueOf(cess);
				cess = 0;
			}
		}
		
		String resultString = new StringBuilder(resultReverse).reverse().toString();
		
		return resultString;
		
	}
	
	private int lastDigit(int i) {
		
		//find the fibonaki number in String
		String []fiboArray = new String[i+1];
		fiboArray[0] = "0";
		
		if(i==0) {
			fiboArray[0] = "0";
		} else {
			fiboArray[0] = "0";
			fiboArray[1] = "1";
		} 
		
		for(int k=2;k<=i;k++) {
			//do addition in string
			fiboArray[k] = addIntOfStringType(fiboArray[k-1], fiboArray[k-2]);
		}
		
		//find the last digit
		int result = Character.getNumericValue(fiboArray[i].charAt(fiboArray[i].length()-1)) % 10;		
		
		return result;
	}
	
	public static void main(String[] args) {
		LastDigitOfFiboNumber lastDigitOfFiboNumber = new LastDigitOfFiboNumber();
		int result = lastDigitOfFiboNumber.lastDigit(327305);
		System.out.println(result);
	}

	
}
