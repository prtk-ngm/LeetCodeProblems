import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class HeapNode{
  Integer value;
  Integer listPosition;
  Integer listIndex;

  public HeapNode(Integer value, Integer listPosition, Integer listIndex) {
    this.value = value;
    this.listPosition = listPosition;
    this.listIndex = listIndex;
  }
}

public class MergeKSortedLists {

  public static void main(String[] args) {

    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    lists.add(Arrays.asList(1,2,3));
    lists.add(Arrays.asList(4,5,7));
    lists.add(Arrays.asList(8,9,10));
    int a[] = mergeKSortedLists(lists);

    for(int i=0 ; i < a.length ; i++){
      System.out.println(a[i]);
    }


  }

  public static int[] mergeKSortedLists(List<List<Integer>> lists) {
    if (lists == null)
      return null;

    PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(1,
        (HeapNode a, HeapNode b) -> a.value - b.value);

    int size = 0;
    for (int i = 0; i < lists.size(); i++)
      size += lists.get(i).size();

    int [] result = new int[size]; //Size is k * n

    for (int i = 0; i < lists.size(); i++)
      minHeap.add(new HeapNode(lists.get(i).get(0), i, 0));

    for(int i=0; i< size; i++){
      HeapNode node = minHeap.poll();
      if(node != null){
        result[i] = node.value;
        if(node.listIndex +1 < lists.get(node.listPosition).size()){
          minHeap.add(new HeapNode(lists.get(node.listPosition).get(node.listIndex+1),
              node.listPosition,
              node.listIndex+1));
        }
      }
    }
    return result;
  }


}
