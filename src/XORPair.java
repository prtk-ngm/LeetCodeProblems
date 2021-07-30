public class XORPair {

  public static void main(String[] args) {
    int[] numbers = new int[]{3, 10, 5, 25, 2, 8};
    TrieNode root = new TrieNode(null, null);
    for (int num : numbers) {
      insert(num, root);
    }
    System.out.println(findMaxXORPair(root, numbers));


  }

  public static void insert(int n, TrieNode root) {

    TrieNode curr = root;
    for (int i = 31; i >= 0; i--) {
      //get 31,30,29... bits from right.
      int b = (n >> i) & 1;

      if (b == 0) {
        if (curr.left == null) {
          curr.left = new TrieNode(null, null);

        }
        curr = curr.left;

      } else {
        if (curr.right == null) {
          curr.right = new TrieNode(null, null);
        }
        curr = curr.right;

      }
    }

  }

  public static int findMaxXORPair(TrieNode root, int[] numbers) {
    int maxXOR = Integer.MIN_VALUE;

    for (int i = 0; i < numbers.length; i++) {
      int value = numbers[i];
      int currXOR = 0;
      TrieNode curr = root;
      for (int j = 31; j >= 0; j--) {
        int b = (value >> j) & 1;
        if (b == 0) {
          if (curr.right != null) {
            currXOR += Math.pow(2, j);
            curr = curr.right;
          } else {
            curr = curr.left;
          }

        } else {

          if (curr.left != null) {
            currXOR += Math.pow(2, j);
            curr = curr.left;
          } else {
            curr = curr.right;
          }

        }


      }
      if (currXOR > maxXOR) {
        maxXOR = currXOR;
      }
    }

    return maxXOR;

  }

}

class TrieNode {

  TrieNode left;
  TrieNode right;

  public TrieNode(TrieNode left, TrieNode right) {
    this.left = left;
    this.right = right;
  }

}
