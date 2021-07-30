import java.util.Stack;

public class CancelPairCharsInString {

  public static void main(String[] args) {
    String s = new String("abc");
    System.out.println(cancelPair(s));

  }




  public static String cancelPair(String s){
    Stack<Character> st = new Stack<Character>();
    StringBuffer sb = new StringBuffer();
    for(int i=0 ; i < s.length() ; i++){
      if(st.size() > 0){
        char c = st.peek();
        if(c == s.charAt(i)){
          st.pop();
          continue;
        }
      }
      st.push(s.charAt(i));

    }
    while(!st.isEmpty()){
      sb.append(st.pop());
    }
    sb.reverse();
    return sb.toString();
  }

}
