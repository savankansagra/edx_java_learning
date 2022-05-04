package week3;

public class MoneyLootMaximumKnapsack {
	public static void main(String[] args) {
		MoneyLootMaximumKnapsack moneyLootMaximumKnapsack = new MoneyLootMaximumKnapsack();
		/* Test Case 1 
		int n = 3;
		int W = 50;
		int[] itemsValue = {60,100,120};
		int[] itemWeight = {20,50,30};
		*/
		
		/* Test Case 2 */
		int n = 1;
		int W = 10;
		int[] itemsValue = {500};
		int[] itemWeight = {30};
		
		Float maxAmount = moneyLootMaximumKnapsack.fillKnapSnap(n,W,itemsValue,itemWeight);
	}

	private float fillKnapSnap(int n, int w, int[] itemsValue, int[] itemWeight) {
		Float resultValue = 0.0F;
		Float resultWeight = 0.0F;
		
		for(int i=0;i<n;i++) {
			int indexI = findMaxValuetoWeight(itemsValue,itemWeight);
			if(itemWeight[indexI] <= w) {
				//take full item
				resultValue += itemsValue[indexI];
				resultWeight += itemWeight[indexI];
				w = w - itemWeight[indexI];
				itemWeight[indexI] = 0;
				itemsValue[indexI] = 0;
			} else {
				//do the fraction of item
				int remainWeight = w;
				resultValue += (1.0F * itemsValue[indexI] / itemWeight[indexI]) * remainWeight;
				resultWeight = (float) remainWeight;
				w = 0;
				break;
			}
		}
		
		System.out.println("result Value = "+resultValue);
		System.out.println("result Weight = "+resultWeight);
		return resultValue;
	}

	private int findMaxValuetoWeight(int[] itemsValue, int[] itemWeight) {
		int index=0;
		Float maxValueToWeight = 1.0F * itemsValue[index]/itemWeight[index];
		for(int i=0;i<itemsValue.length;i++) {
			if(itemWeight[i] != 0 && itemsValue[i]!=0  && maxValueToWeight < itemsValue[i] / itemWeight[i]) {
				index = i;
				maxValueToWeight = (float) (itemsValue[i] / itemWeight[i]);
			}
		}
		return index;
	}
}
