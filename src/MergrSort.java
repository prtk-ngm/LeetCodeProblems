public class MergrSort {

  public static void main(String[] args) {

    int a[] = new int[]{5,2,3,6,1};
    mergeSort(a, 0 ,a.length-1);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }


  }

    public static void mergeSort ( int a[], int left, int right){
      if (left < right) {
        int mid = (left + right) / 2;

        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);
        merge(a, left, mid, right);

      }

    }

    public static void merge ( int[] a,int left, int mid, int right){

      int n1 = mid - left + 1;
      int n2 = right - mid;

      int L[] = new int[n1];
      int R[] = new int[n2];

      for(int i=0 ; i<n1 ; i++){
        L[i] = a[left + i];
      }

      for(int j=0 ; j<n2 ; j++){
        R[j] = a[mid + 1 + j];
      }

      int i = 0;
      int j = 0;
      int k = left;

      while (i < n1 && j < n2) {

        if (L[i] <= R[j]) {
          a[k] = L[i];
          i++;

        } else {
          a[k] = R[j];
          j++;

        }

        k++;

      }
      while (i < n1) {
        a[k] = L[i];
        i++;
        k++;
      }

      while (j < n2) {
        a[k] = R[j];
        j = j+1;
        k++;
      }




    }


}
