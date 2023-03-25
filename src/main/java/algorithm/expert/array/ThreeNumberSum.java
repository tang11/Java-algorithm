package algorithm.expert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenli
 * @date 2022/7/20
 */
public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triple = new ArrayList<Integer[]>();

        for (int i = 0; i < array.length; i++) {
            int left = i + 1;
            int right = array.length;
            while (left < right) {
                int curSum =array[i] + array[right] + array[left] ;
                if (curSum == targetSum) {
                     Integer[] newTriple = {array[i],array[right], array[left]};
                     triple.add(newTriple);
                     left++;
                     right--;
                } else if(curSum < targetSum){
                    left++;
                } else  if (curSum> targetSum) {
                    right--;
                }
                }
            }
        return triple;
        }
    }