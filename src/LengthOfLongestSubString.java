import java.util.HashMap;

public class LengthOfLongestSubString {

  public static void main(String[] args) {

    String s = "abcabcbb";
    System.out.println(lenOfLongestSubstring(s));

  }

  public static int lenOfLongestSubstring(String s){

    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    int length = 0;
    int i=0;

    for(int j=0 ; j< s.length(); j++){
      Character c = s.charAt(j);

      if(map.containsKey(c)){
        i = map.get(c);
      }

      length = Math.max(length, j - i + 1);
      map.put(c,j+1);

    }

    return length;


  }

}
