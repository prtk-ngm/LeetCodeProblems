import java.util.Collections;
import java.util.PriorityQueue;

public class FindMaxPairInTwoArray {

  public static void main(String[] args) {
    int array1[] = new int[]{1,2,3};
    int array2[] = new int[]{4,5,6};

    int a[] = getMaxPair(array1,array2);
    System.out.println("Pair is:{" + a[0] + "," + a[1] + "}");


  }

  static int[] getMaxPair(int array1[], int array2[]){
    int [] retArray = new int[2];
    retArray[0] = Integer.MIN_VALUE;
    retArray[1] = Integer.MIN_VALUE;

    //Create two max heap with both array.
    PriorityQueue<Integer> pq1 = new
        PriorityQueue<Integer>(array1.length, Collections.reverseOrder());
    PriorityQueue<Integer> pq2 = new
        PriorityQueue<Integer>(array2.length, Collections.reverseOrder());



    for(int i=0 ; i< array1.length ; i++){
      pq1.add(array1[i]);
    }

    for(int i=0 ; i< array2.length ; i++){
      pq2.add(array2[i]);
    }
    while(!pq1.isEmpty() && !pq2.isEmpty()){
      Integer num1 = pq1.poll();
      Integer num2 = pq2.poll();
      if(retArray[0] + retArray[1] < num1+ num2){
        retArray[0] = num1;
        retArray[1] = num2;

      }


    }
    return retArray;
  }





}
