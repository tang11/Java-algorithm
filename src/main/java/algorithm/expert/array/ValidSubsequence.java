package algorithm.expert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tang lijuan
 * @date 2023/3/16
 */
public class ValidSubsequence {

    public static void main(String[] args) {
        List<Integer> arr =new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList(Arrays.asList(1, 6, -1, 10));
        System.out.println(isValidSubsequence(arr,sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int index = 0;
        for(int i =0;i < array.size();i++) {
            if(sequence.get(index).equals(array.get(i))) {
                index++;
            }
            if(index==sequence.size()){
                return true;
            }
        }
        // Write your code here.
        return false;
    }
}
