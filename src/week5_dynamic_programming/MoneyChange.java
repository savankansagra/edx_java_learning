package week5_dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoneyChange {
	public static void main(String[] args) {
		// test case 1
		int money = 34;
		int[] coins = new int[] {1,3,4};
		
		MoneyChange moneyChange = new MoneyChange();
		
//		int result = moneyChange.minCoin(money, coins);
//		System.out.println(result);
		
		int result2 = moneyChange.minCoinDynamic(money, coins);
		System.out.println(result2);
		
		
	}

	
	private int minCoinDynamic(int money, int[] coins) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 0);
		
		for(int i=1;i<=money;i++) {
			cache.put(i, cache.get(i-1)+1);
			for(int coin:coins) {
				if(coin <= i) {
					int other = cache.get(i-coin)+1;
					cache.put(i, Math.min(cache.get(i), other));
				}
			}
			
		}
		
		System.out.println(cache);
		return cache.get(money);
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
