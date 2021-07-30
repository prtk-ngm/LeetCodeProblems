import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class AVLTreeTest {

  public static void main(String[] args) {
    AVLTreeOperations op = new AVLTreeOperations();
    AVLTreeNode root = op.insert(null,null,30);
    root = op.insert(root,null,20);
    root = op.insert(root,null,40);
    root = op.insert(root,null,10);
    root = op.insert(root,null,50);

    //op.delete(root,40);
    op.levelOrderTraversal(root);

    List<String> s = new ArrayList<>(Arrays.asList("i"));








  }

}

class AVLTreeNode{

  AVLTreeNode left;
  AVLTreeNode right;
  int data;
  int height;

}

class AVLTreeOperations{

  public int height(AVLTreeNode root){
    if(root == null)
      return -1;
    else
      return root.height;
  }

  public int getBF(AVLTreeNode root){

    if(root.left != null && root.right != null){
      return root.left.height - root.right.height;
    }else if(root.left != null && root.right == null){
      return root.left.height;

    }
    else if(root.left == null && root.right != null){
      return root.right.height;
    }
    return 0;
  }

  /*   6(x)
     5(w)     ---> 5
   3            3    6
   */
  public AVLTreeNode singleRotateLeft(AVLTreeNode x){
    AVLTreeNode w = x.left;
    x.left = w.right;
    w.right = x;
    x.height = Math.max(height(x.left),height(x.right)) + 1;
    w.height = Math.max(height(w.left),x.height) + 1;

    return w; //new root

  }
  /*
          6(x)
           7(w)  --------    7
            8              6   8

   */

  public AVLTreeNode singleRotateRight(AVLTreeNode x){
    AVLTreeNode w = x.right;
    x.right = w.left;
    w.left = x;

    x.height = Math.max(height(x.right),height(x.left)) + 1;
    w.height = Math.max(height(w.right),x.height) + 1;

    return w; //new root

  }

  public AVLTreeNode doubleRotateWithLeftRight(AVLTreeNode x){
    x.left = singleRotateRight(x.left);
    return singleRotateLeft(x);


  }

  public AVLTreeNode doubleRotateWithRightLeft(AVLTreeNode x){
    x.right = singleRotateLeft(x.right);
    return singleRotateRight(x);
  }

  public AVLTreeNode insert(AVLTreeNode root, AVLTreeNode parent, int data){
    if(root == null){
      root = new AVLTreeNode();
      root.data = data;
      root.height = 0;
      root.left = root.right = null;
    }

    else if(data < root.data){

      root.left = insert(root.left, root, data);
      //maintain AVL property
      if(height(root.left) -height(root.right) == 2){
        if(data < root.left.data)
          root = singleRotateLeft(root);
        else
          root = doubleRotateWithLeftRight(root);
      }

    }

    else if(data > root.data){
      root.right = insert(root.right, root, data);
      //maintain AVL property
      if(height(root.right) -height(root.left) == 2){
        if(data > root.right.data)
          root = singleRotateRight(root);
        else
          root = doubleRotateWithRightLeft(root);
      }


    }

    root.height = Math.max(height(root.left),height(root.right)) + 1;

    return root;

  }

  AVLTreeNode delete(AVLTreeNode root, int data){
    AVLTreeNode temp = null;

    if(root == null)
      return null;

    //Single node AVL tree
    if(root.left == null && root.right == null)
    {
      if(root.data == data){
        return null;
      }
    }

    if(root.data < data){
      root.right = delete(root.right, data);

    }else if(root.data > data){
      root.left = delete(root.left , data);

    }
    //root node
    else{
      if(root.left != null){
         temp = inorderPrevious(root.left);
         root.data = temp.data;
         root.left = delete(root.left, temp.data);


      }else{

        temp = inorderSuccessor(root.right);
        root.data = temp.data;
        root.right = delete(root.right, temp.data);


      }


    }

    if(root != null) {

        //Left rotate condition
        if (getBF(root) == 2 && getBF(root.left) == 1)
          root = singleRotateLeft(root);

        if (getBF(root) == 2 && getBF(root.left) == 0)
          root = singleRotateLeft(root);

        //Right rotate condition
        if (getBF(root) == -2 && getBF(root.right) == -1)
          root = singleRotateRight(root);

        if (getBF(root) == -2 && getBF(root.right) == 0)
          root = singleRotateRight(root);

        //Left Right condition
        if (getBF(root) == 2 && getBF(root.left) == -1)
          root = doubleRotateWithLeftRight(root);

        //Right Left condition
        if (getBF(root) == -2 && getBF(root.right) == 1)
          root = doubleRotateWithRightLeft(root);
    }

    return root;
  }

  AVLTreeNode inorderPrevious(AVLTreeNode p){
    while(p.right != null)
        p = p.right;
    return p;

  }

  AVLTreeNode inorderSuccessor(AVLTreeNode p){
    while(p.left != null)
      p = p.left;
    return p;
  }


  public int isAVLTree(AVLTreeNode root){
    boolean retVal = false;
    int left, right;
    if(root == null)
      return 0;

    left = isAVLTree(root.left);
    if(left == -1)
      return left;
    right = isAVLTree(root.right);
    if(right == -1)
      return right;

    if(Math.abs(left-right) > 1)
      return -1;

    return Math.max(left,right) + 1;


  }

  public void levelOrderTraversal(AVLTreeNode root){
    if(root == null){
      return;
    }
    Queue<AVLTreeNode> q = new LinkedList<AVLTreeNode>();
    q.add(root);
    q.add(null); //Level marker

    while(!q.isEmpty()){
      AVLTreeNode node = q.poll();
      if(node == null && q.size() != 0){
        System.out.println();
        q.add(null);


      }

      if(node != null) {
          System.out.print(node.data + " ");
          if (node.left != null)
            q.add(node.left);
          if (node.right != null)
            q.add(node.right);
      }

    }

  }


}
