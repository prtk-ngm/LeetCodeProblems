import java.util.ArrayList;
import java.util.List;

public class subsetSum {

  public static void main(String[] args) {

    int arr1[] = {2, 3, 7};
    System.out.print(checkSubsetSum(arr1, 5));


  }



  public static boolean checkSubsetSum(int a[], int total){
    boolean T[][] = new boolean[a.length + 1][total+1];

    for(int i=0 ; i <= a.length ; i++){
      T[i][0] = true;
    }

    for(int i=1 ; i <= a.length ; i++){

      for(int j=1 ; j <= total ; j++){

        if(j < a[i-1]){
          T[i][j] = T[i-1][j];
        }else{
          T[i][j] = T[i-1][j] || T[i-1][j-a[i-1]];
        }
      }

    }

    return T[a.length][total];

  }

}
