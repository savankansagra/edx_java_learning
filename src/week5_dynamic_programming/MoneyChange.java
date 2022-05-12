package week5_dynamic_programming;

public class MoneyChange {
	public static void main(String[] args) {
		// test case 1
		int money = 34;
		int[] coins = new int[] {1,3,4};
		
		MoneyChange moneyChange = new MoneyChange();
		
		int result = moneyChange.minCoin(money, coins);
		System.out.println(result);
	}

	/**
	 * make recursive call to solve the problem.
	 * 
	 * @param money
	 * @param coins
	 * @return total coin for change of money.
	 */
	private int minCoin(int money, int[] coins) {
		if(money==0) return 0;
		int minNumCoins = Integer.MAX_VALUE;
		
		for(int i=0;i<coins.length;i++) {
			if(money >= coins[i]) {
				int numCoins = minCoin(money-coins[i], coins);
				if(numCoins+1 < minNumCoins) {
					minNumCoins = numCoins+1;
				}
			}
		}
		
		return minNumCoins;
	}
}
