import java.math.BigInteger;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {

  static int  index=0;
  public static void main(String[] args) {

    System.out.println(decodeString("3[a]2[bc]"));
    BigInteger x = new BigInteger("10", 2);
    System.out.println("x:" + x);



  }

  public static String decodeString(String s) {

    return decodeStringHelper(s);

  }

  public static String decodeStringHelper(String s){

    //int index = 0;
    StringBuffer result = new StringBuffer();

    System.out.println("index:" + index);

    while(index < s.length() && s.charAt(index) != ']'){

      if(Character.isDigit(s.charAt(index))){
        int num = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
          num = num * 10 + s.charAt(index++) - '0';
        }
        index++; // to ignore '['

        String r = decodeStringHelper(s);

        while(num-- > 0){
          result.append(r);
        }

        index++;


      }

      //if its not number and '['
      else{
        result.append(s.charAt(index++));
      }


    }



    return result.toString();



  }

}
