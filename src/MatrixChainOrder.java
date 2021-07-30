import java.util.Arrays;

public class MatrixChainOrder {

  public static void main(String[] args) {

    int [] arr = new int[] {1,2,2,3,3,3};
    int s[][] = matrixChainOrder(arr);

    System.out.println("s");
    for(int i=0 ; i < s.length ; i++){
      for(int j=0 ; j < s[0].length ; j++){
        System.out.print(s[i][j] + " ");
      }

      System.out.println();


    }

  }

  public static int[][] matrixChainOrder(int []arr){
    int temp[][] = new int[arr.length][arr.length];
    int s[][] = new int[arr.length][arr.length];
    int q = 0;
    for(int l=2; l < arr.length; l++){
      for(int i=0; i < arr.length - l; i++){
        int j = i + l;
        temp[i][j] = Integer.MAX_VALUE;
        for(int k=i+1; k < j; k++){
          q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
          if(q < temp[i][j]){
            temp[i][j] = q;
            s[i][j] = k;

          }
        }
      }
    }

    for(int i=0 ; i < temp.length ; i++){
      for(int j=0 ; j < temp[0].length ; j++){
        System.out.print(temp[i][j] + " ");
      }

      System.out.println();


    }
    return s;

  }

}
