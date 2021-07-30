import java.util.Arrays;
import java.util.HashMap;

public class CoinChangeDP {

  public static void main(String[] args) {

    int amount = 23;
    int []coins = new int[] {1,2,5,6};

    System.out.println("minCoinRequired:" + minCoinRequired(coins, amount));
    HashMap<Integer, Integer> map = new HashMap<>();
    System.out.println("minCoinTopDownApproach:" + minCoinTopDownApproach(coins, amount,map ));

  }

  public static int minCoinRequired(int []coins, int amount){

    int max = amount + 1;
    int[] dp = new int[amount + 1];
    int[] R = new int[amount+1];
    Arrays.fill(R, -1);
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          R[i] = j;
        }
      }
    }

    for(int i=0 ; i< R.length ; i++){
      System.out.print(R[i] + " ");
    }

    printCoinCombination(R, coins);
    return dp[amount] < amount ? dp[amount] : -1;
  }

  private static void printCoinCombination(int R[], int coins[]) {
    if (R[R.length - 1] == -1) {
      System.out.print("No solution is possible");
      return;
    }
    int start = R.length - 1;
    System.out.println("Coins used to form total ");
    while ( start != 0 ) {
      int j = R[start];
      System.out.print(coins[j] + " ");

      start = start - coins[j];
    }
    System.out.print("\n");
  }



  public static int minCoinTopDownApproach(int []coins, int amount,
      HashMap<Integer, Integer> map){

    //if amount is 0 we don't need any coin.
    if(amount == 0)
      return 0;

    //get already calculated  value in map
    if(map.containsKey(amount)){
      return map.get(amount);
    }

    int min = Integer.MAX_VALUE;
    for(int i=0 ; i < coins.length ; i++){
      //coin is greater than amount skip the coin
      if(coins[i] > amount)
        continue;

      int val = minCoinTopDownApproach(coins, amount-coins[i], map);
      if(val < min){
        min = val;
      }
    }

    min = (min == Integer.MAX_VALUE ) ? min : min + 1;
    map.put(amount, min);
    return min;

  }


}
