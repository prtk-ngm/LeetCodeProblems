public class KMP {


  public static void main(String []args){

    int F[] = createPrefixTable("aab");
    for(int i=0; i < F.length ; i++){
      System.out.print(F[i] + " ");
    }

    String target = "aaaba";
    String pattern = "aab";
    int shift = KMPSearch(pattern,target);
    System.out.println("shift:" + shift);
    if(shift >= 0)
      System.out.println("string:" + target.substring(shift,shift+pattern.length()));

  }
  //aab   0 1 0    //abc 0 0 0
  public static int [] createPrefixTable(String pattern){
    int m = pattern.length();
    int F[] = new int[m];

    int i=1;
    int j=0;
    F[0] = 0;


    while(i < m){
      if(pattern.charAt(i) == pattern.charAt(j)){
        F[i] = j + 1;
        i++;
        j++;
      }
      else if(j > 0){
        j = F[j-1];

      }else{
        F[j] = 0;
        i++;
      }



    }
    return F;
  }

  public static int KMPSearch(String pattern, String target){
    int i=0;
    int j=0;
    int F[] = createPrefixTable(pattern);

    while(i < target.length()){

      if(pattern.charAt(j) == target.charAt(i)){

        if(j == pattern.length()-1){
          return i-j;

        }else {

          i++;
          j++;
        }
      }
      else if(j >0){
        j = F[j-1];

      }else{
        i++;

      }


    }
    return -1;
  }

}
