public class InvertBinaryTree {


  public static void main(String[] args) {

    TreeNode root = new TreeNode(null, null, 4);
    root.left = new TreeNode(null, null, 2);
    root.right = new TreeNode(null, null, 7);
    root.left.left = new TreeNode(null, null, 1);
    root.left.right = new TreeNode(null, null, 3);
    root.right.left = new TreeNode(null, null, 6);
    root.right.right = new TreeNode(null, null, 9);
    //invertTree(root);
    //preorder(root);
    TreeNode node = binaryTreeToList(root);
    while (node != null) {
      System.out.println(node.right.data);
      node = node.right;
    }


  }

  public static void preorder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.data);
    preorder(root.left);
    preorder(root.right);
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    invertTree(root.left);
    invertTree(root.right);

    //swap left and right node data.
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;

    return root;

  }

  public static TreeNode append(TreeNode a, TreeNode b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }

    TreeNode aLast = a.left;
    TreeNode bLast = b.left;

    aLast.right = b;
    b.left = aLast;
    bLast.right = a;
    a.left = bLast;

    return a;
  }

  public static TreeNode binaryTreeToList(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftList = binaryTreeToList(root.left);
    TreeNode rightList = binaryTreeToList(root.right);
    root.left = root;
    root.right = root;

    leftList = append(leftList, root);
    rightList = append(leftList, rightList);

    return leftList;


  }

}

class TreeNode {

  TreeNode left;
  TreeNode right;
  int data;

  public TreeNode(TreeNode left, TreeNode right, int data) {
    this.left = left;
    this.right = right;
    this.data = data;
  }

}
