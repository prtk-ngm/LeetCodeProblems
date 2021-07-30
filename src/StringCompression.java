public class StringCompression {

  public static void main(String[] args) {

    char chars[] = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    System.out.println(compressString(chars));


  }

  public static int compressString(char[] chars) {
    int index = 0;
    int i = 0;

    while (i < chars.length) {
      int j = i;
      while (j < chars.length && chars[i] == chars[j]) {
        j++;
      }
      chars[index++] = chars[i];
      if (j - i > 1) {
        String count = String.valueOf(j - i);
        for (char c : count.toCharArray()) {
          chars[index++] = c;

        }
      }
      i = j;
    }

    return index;

  }

}
