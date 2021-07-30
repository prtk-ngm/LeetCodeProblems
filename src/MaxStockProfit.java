public class MaxStockProfit {

  public static void main(String[] args) {
    int prices[] = new int[] {7,1,5,3,2,4};
    System.out.println(maxProfit(prices));

  }

  public static int maxProfit(int[] prices){
    int i=0;
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    while(i < prices.length){
      if(prices[i] < minPrice){
        minPrice = prices[i];
      } else if(prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }



      i++;
    }

    return maxProfit;

  }

}


