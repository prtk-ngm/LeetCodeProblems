import java.util.Collections;
import java.util.HashMap;

public class LongestSubString {

  //159. Longest Substring with At Most Two Distinct Characters
  public static void main(String[] args) {

    System.out.println(longestSubStringWithTwoDiffCharAtMost("ccaabbb"));



  }

  public static  int longestSubStringWithTwoDiffCharAtMost(String s){
    int maxLength = 0;
    int n = s.length();

    int i=0;
    int l = 0;

    int MAX_LEN = 2;

    HashMap<Character,Integer> map = new HashMap<Character,Integer>();

    while( i < n ){

      map.put(s.charAt(i),i++);

      if(map.size() > MAX_LEN){
        int minValue = Collections.min(map.values());
        map.remove(s.charAt(minValue));
        l = minValue + 1;
      }

      maxLength = Math.max(maxLength, i-l);


    }



    return maxLength;

  }

}
