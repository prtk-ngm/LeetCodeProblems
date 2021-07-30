import java.util.ArrayList;
import java.util.List;

public class FindMissingRangesInArray {

  public static void main(String[] args) {

    List<String> result = findMissingRange(new int[]{0,1,3,50,75},0,99);
    System.out.println(result.size());
    result.stream().forEach(e -> System.out.println(e));

  }

  public static List<String> findMissingRange(int []nums, int i, int j){

    List<String> result = new ArrayList<String>();
    int prev = i -1;
    for(int k=0 ; k<= nums.length; k++){
      int curr = (k < nums.length) ? nums[k] : j+1;
      if(2 <= curr-prev){
        result.add(getRange(prev+1, curr-1));
      }

      prev = curr;


    }

    return result;

  }

  public static String getRange(int lower, int upper){

    if(lower == upper)
      return String.valueOf(lower);

    return lower + "->" + upper;

  }



}
