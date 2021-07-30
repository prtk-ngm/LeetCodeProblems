import java.util.Arrays;

public class LongestSubSeq {

  public static void main(String[] args) {
    int a[] = new int[] {3, 4, -1, 0, 6, 2, 3};
    System.out.println("max:" + getLongestSubSeq(a));
  }

  public static int getLongestSubSeq(int []a){

    int T[] = new int[a.length];
    int R[] = new int[a.length];
    Arrays.fill(T,1);

    for(int i=0 ; i < R.length ; i++){
      R[i] = i;
    }

    for(int i=1; i< T.length ; i++){
      for(int j=0 ; j < i ; j++){

        if(a[j] < a[i]){
          if(T[i] < T[j] + 1) {
            T[i] = T[j] + 1;
           // R[i] = j;
          }

        }

      }
    }

    //get max value from array.
    int max = 0;

    for(int i=0 ; i < T.length ; i++){
      max = Math.max(max, T[i]);
    }

    return max;
  }

}
