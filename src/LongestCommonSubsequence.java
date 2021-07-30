import java.util.Arrays;

public class LongestCommonSubsequence {

  public static void main(String[] args) {

    String str1 = "abdcf";
    String str2 = "abfcf";

    System.out.println(lcs(str1,str2));
    System.out.println(lcsDP(str1,str2));

  }


  public static int lcs(String str1, String str2){

    return lcsHelper(str1 , str2, 0, 0);
  }

  //BF approach takes almost 2^n if(m==n)
  public static int lcsHelper(String str1, String str2, int i, int j){

    if(i == str1.length() || j == str2.length())
      return 0;

    //if both char is same at str1[i] and str2[j]
    if(str1.charAt(i) == str2.charAt(j)){
      return 1 + lcsHelper(str1, str2, i+1, j+1);
    }else {
      return Math.max(lcsHelper(str1, str2, i+1, j), lcsHelper(str1, str2, i, j+1));
    }

  }

  public static int lcsDP(String str1, String str2){

    if(str1.length() == 0 || str2.length() == 0)
      return 0;

    int m = str1.length()+1;
    int n= str2.length()+1;
    int [][]LCS = new int[str1.length()+1][str2.length()+1];

    for(int i=1 ; i< m; i++){
      for(int j=1 ; j< n; j++){

        if(str1.charAt(i-1) == str2.charAt(j-1)){
          LCS[i][j] = LCS[i-1][j-1] + 1;
        }else{
          LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        }
      }
    }

    return LCS[m-1][n-1];





  }

}
