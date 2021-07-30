import java.util.Arrays;

//Heap data structure
class Heap{
  public int [] array; //hold data
  private int count; //number of elements present in heap.
  private int capacity; // capacity of heap(size)

  public void setCount(int count) {
    this.count = count;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
 public int getCount() {
    return count;
  }

  public int getCapacity() {
    return capacity;
  }

}

//To have all heap operations
class HeapOperations {

  public Heap createHeap(int capacity){
    if(capacity == 0){
      System.out.println("capacity should be grater than 0");
    }
    Heap heap = new Heap();
    heap.setCount(0); //initial heap count should be 0
    heap.setCapacity(capacity);
    heap.array = new int[capacity];
    return heap;
  }

  public void buildHeap(Heap heap, int a[], int n){
      if(heap == null)
        return;
      while(n > heap.getCapacity())
        resizeHeap(heap);

      for(int i=0 ; i < n ; i++){
        heap.array[i] = a[i];
      }
      heap.setCount(n);

      for(int i= (n-1)/2; i >=0 ; i--){
        percolateDown(heap, i);
      }
    }

    int [] heapSort(int a[], int n){
      Heap h = createHeap(n);
      buildHeap(h, a, n);
      for(int i=0 ; i < h.getCount(); i++){
        System.out.println("b:" + h.array[i]);
      }

      int oldSize = h.getCount();
      int temp;
      for(int i=n-1 ; i > 0 ; i--){
       temp = h.array[0];
       h.array[0] = h.array[h.getCount()-1];
       h.array[h.getCount()-1] = temp;
       h.setCount(h.getCount()-1);
       percolateDown(h,0);
      }
      h.setCount(oldSize);

      return h.array;
  }

  public void resizeHeap(Heap heap){

    int[] oldArray = heap.array;
    heap.array = new int[heap.getCapacity()+1];

    for(int i=0 ; i < oldArray.length ; i++){
      heap.array[i] = oldArray[i];
    }

  }

  public int leftChild(Heap h, int i){
    int left = 2*i+1;
    if(left >= h.getCount()){
      return -1;
    }

    return left;

  }

  public int rightChild(Heap h, int i){
    int right = 2*i+2;
    if(right >= h.getCount()){
      return -1;
    }
    return right;
  }

  //to satisfy the heap properties we will do percolate down small elements
  public void percolateDown(Heap heap, int i){

    int l,r,max,temp;
    l = leftChild(heap, i);
    r = rightChild(heap, i);

    if(l != -1 && heap.array[l] > heap.array[i])
      max = l;
    else
      max = i;

    if(r != -1 && heap.array[r] > heap.array[max])
      max = r;

    if(max != i){
      temp = heap.array[i];
      heap.array[i] = heap.array[max];
      heap.array[max] = temp;
      percolateDown(heap, max);
    }
  }

  }

public class HeapTest{

  public static void main(String[] args) {

    HeapOperations op = new HeapOperations();
    Heap h = op.createHeap(3);
    int a[] = new int[]{1,3,2,9,7,6};
    int [] sorted = op.heapSort(a, a.length);

    for(int i=0 ; i < sorted.length; i++){
      System.out.println("after sort:" + sorted[i]);
    }


  }
}
