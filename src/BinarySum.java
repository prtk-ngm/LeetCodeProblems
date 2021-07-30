import java.math.BigInteger;

public class BinarySum {

  public static void main(String []args){

    System.out.println(binarySum("1010","1011"));


  }


  public static String binarySum(String a, String b){
    //Binary to decimal.
    BigInteger x = new BigInteger(a,2);
    BigInteger y = new BigInteger(b,2);
    BigInteger zero = new BigInteger("0",2);
    BigInteger sum, carry;
    while(y.compareTo(zero) != 0){

      sum = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = sum;
      y=carry;

    }
    //decimal to binary.
    return x.toString(2);
  }

}
