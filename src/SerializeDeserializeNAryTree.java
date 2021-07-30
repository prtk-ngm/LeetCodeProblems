import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
  public int val;
  public List<Node> children;

  public Node() {
    children = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    children = new ArrayList<Node>();
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }




};

class SerializeDeserializeTrie{

  public String serialize(Node root){
    StringBuffer sb = new StringBuffer();
    if(root == null){
      return "";
    }

    sb.append(String.valueOf(root.val));
    sb.append(",").append(String.valueOf(root.children.size()));


    for(int i=0 ; i< root.children.size() ; i++){
      sb.append(",").append(serialize(root.children.get(i)));
    }

    return sb.toString();

  }

  public Node deserializeHelper(Queue<String> nodesLeft){
    String nodeValue = nodesLeft.poll();
    int childSize = Integer.parseInt(nodesLeft.poll());

    Node root = new Node(Integer.parseInt(nodeValue));
    for(int i=0 ; i<childSize ; i++){
      root.children.add(deserializeHelper(nodesLeft));
    }

    return root;

  }

  public Node deserialize(String s){

    Queue q = new LinkedList(Arrays.asList(s.split(",")));
    return deserializeHelper(q);

  }
}

public class SerializeDeserializeNAryTree {

  public static void main(String[] args) {

    List<Node> list1 = new ArrayList<Node>();
    list1.add(new Node(5));
    list1.add(new Node(2));
    list1.add(new Node(4));

    List<Node> list2 = new ArrayList<Node>();
    list2.add(new Node(6));
    list2.add(new Node(7));


    Node root = new Node(1,list1);
    root.children.get(0).children = list2;


    SerializeDeserializeTrie object = new SerializeDeserializeTrie();
    String serializeString = object.serialize(root);

    Node deserializeNode = object.deserialize(serializeString);
    System.out.println(serializeString);
    System.out.println(object.serialize(deserializeNode));

    System.out.println(serializeString.equalsIgnoreCase(object.serialize(deserializeNode)));




  }





}
