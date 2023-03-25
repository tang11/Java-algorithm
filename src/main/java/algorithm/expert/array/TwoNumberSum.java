package algorithm.expert.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author tanglijuan
 * @date 2023/2/22
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        System.out.println(Arrays.toString(twoNumberSum(arr, targetSum)));
    }
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashSet<Integer> numbers = new HashSet<>();

        for(int i =0; i< array.length; i++)  {
            if(numbers.contains(targetSum - array[i])) {
                return new int[]{array[i], targetSum- array[i]};
            }
            numbers.add(array[i]);
        }
        return new int[0];
    }
}
