public class LargestNumber {

  public static void main(String[] args) {
    //int[] numbers = new int[]{3, 30, 34, 5, 9};
    int[] numbers = new int[]{10,2};
    System.out.println(getLargestNumber(numbers));
  }


  public static int getLargestNumber(int[] numbers) {
    int largestNumber = 0;
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        {
          String num1 = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
          String num2 = String.valueOf(numbers[j]) + String.valueOf(numbers[i]);
          if (Integer.parseInt(num1) < Integer.parseInt(num2)) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
          }

        }

      }

    }
    StringBuffer sb = new StringBuffer();
    for (int k = 0; k < numbers.length; k++) {
      sb.append(String.valueOf(numbers[k]));
    }

    return Integer.parseInt(sb.toString());
  }

}
