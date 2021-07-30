public class ExpressiveWords {

  public static void main(String[] args) {
    System.out.println(":" +expressiveWords("heeellooo",new String[]{"hi"}));

  }


  public static int expressiveWords(String s, String[] words){
    int retCount = 0;
    for(String word : words){

      if(check(s,word) == true){
        System.out.println("check");
        retCount += 1;
      }

    }
    return  retCount;
  }

  public static boolean check(String s, String word) {

    int i = 0;
    int j = 0;

    while (i < s.length() && j < word.length()) {


      //if element does not match return false;
      if(s.charAt(i) != word.charAt(j)){
        return false;
      }

      int sIndex = i;
      while ( i < s.length() && s.charAt(i) == s.charAt(sIndex)) {
        i++;
      }

      int wIndex = j;
      while ( j < word.length() && word.charAt(j) == word.charAt(wIndex)) {
        j++;
      }

      int l1 = i - sIndex;
      int l2 = j - wIndex;



      if (l1 == l2 || l1 >= 3 && l1 > l2) {
        continue;
      }

      return false;


    }
    return i== s.length() && j == word.length();
  }



}
