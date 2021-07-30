public class MinEditString {

  public static void main(String[] args) {

    String str2 = "abe";
    String str1 = "cd";
    //int result = recEditDistance(str1.toCharArray(), str2.toCharArray(), 0, 0);
    //System.out.print(result);
    System.out.println(dynamicEditDistance(str1.toCharArray(), str2.toCharArray()));
  }

  public static int dynamicEditDistance(char[] str1, char[] str2){
    int T[][] = new int[str1.length+1][str2.length+1];

    for(int i=0 ; i < T.length ; i++){
       T[i][0]  = i;
    }

    for(int j=0 ; j < T[0].length ; j++){
      T[0][j]  = j;
    }

    for(int i=1 ; i < T.length ; i++){
      for(int j=1 ; j < T[0].length ; j++){
          if(str1[i-1] == str2[j-1]){
            T[i][j] = T[i-1][j-1];
          }else{
            T[i][j] = 1 + min(T[i-1][j], T[i-1][j-1], T[i][j-1]);
          }
      }
    }

    printT(T);
    printEditResult(T, str1, str2);
    return T[T.length-1][T[0].length - 1];
  }

  public static void printT(int [][]T){

    System.out.println("T");
    for(int i=0 ; i < T.length ; i++) {
      for (int j = 0; j < T[0].length; j++) {
        System.out.print(T[i][j] + " ");
      }
      System.out.println();
    }

    }

  public static void printEditResult(int [][]T, char[] str1, char[] str2){
      int i = T.length - 1;
      int j = T[0].length - 1;

      System.out.println("Operations:");

      while(true){

        if(i == 0 || j==0)
          break;

        if (str1[i-1] == str2[j-1]) {
          i = i-1;
          j = j-1;
        }if (T[i][j] == T[i-1][j] + 1) {
          System.out.println("Delete in string1 " + str1[i-1]);
          i = i-1;
        } else if (T[i][j] == T[i][j-1] + 1){
          System.out.println("Delete in string2 " + str2[j-1]);
          j = j -1;
        }
        else if (T[i][j] == T[i-1][j-1] + 1){
          System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
          i = i-1;
          j = j-1;
        }

        else {
          throw new IllegalArgumentException("Some wrong with given data");
        }

      }

  }

  public static int recEditDistance(char[]  str1, char str2[], int len1,int len2){

    if(len1 == str1.length){
      return str2.length - len2;
    }
    if(len2 == str2.length){
      return str1.length - len1;
    }



    return min(recEditDistance(str1, str2, len1 + 1, len2 + 1) + str1[len1] == str2[len2] ? 0 : 1,
        recEditDistance(str1, str2, len1, len2 + 1) + 1,
        recEditDistance(str1, str2, len1 + 1, len2) + 1);

  }

  private static  int min(int a,int b, int c){
    int l = Math.min(a, b);
    return Math.min(l, c);
  }



}
