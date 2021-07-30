import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import java.util.Arrays;

public class QuickSortImpl {

  public static void main(String []args){

    int a[] = new int[]{3,1,2,7,8,6};
    quickSort(a,0, a.length-1);
    System.out.println(Arrays.toString(a));

  }

  public static int partition(int a[],int low, int high){
    int left = low;
    int right = high;
    int pivotElement = a[low];

    while(left < right){
      while(left < a.length-1 && a[left] <= pivotElement)
        left++;

      while(right >= 0 && a[right] > pivotElement)
        right--;

      if(left < right){
        int temp = a[right];
        a[right] =  a[left];
        a[left] = temp;

      }

    }
    //right is final position of element and right should be move to low
    a[low] = a[right];
    a[right] =  pivotElement;

    return right;

  }

  public static void quickSort(int a[], int left, int right){
    int mid = -1;

    //termination condition
    if(left <= right) {
      mid = partition(a, left, right);
      quickSort(a, left, mid - 1);
      quickSort(a, mid + 1, right);
    }

  }

}
