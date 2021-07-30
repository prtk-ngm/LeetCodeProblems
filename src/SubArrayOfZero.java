public class SubArrayOfZero {

  public static void main(String[] args) {

    int num[] = new int[] {0,0,1,0,1};
    System.out.println("count:" + getSubArraysOfZero(num));


  }

  public static int getSubArraysOfZero(int num[]){
    int retCount = 0;
    if(num.length == 0){
      return retCount;
    }

    int sum = num[0];

    if(sum == 0)
      retCount++;

    for(int i = 1; i< num.length ; i++){
      if(sum == 0 && num[i] == 0){
        retCount += 2;
      }
      if(sum > 0){
        sum = 0;
      }




    }

    return retCount;

  }

}
