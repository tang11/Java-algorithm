package algorithm.expert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author tang lijuan
 * @date 2023/3/26
 */
public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer,List<Integer[]>> allPairsSums = new  HashMap<>();
        List<Integer[]> quadruplets =  new ArrayList<Integer[]>();
        for(int i =0; i< array.length-1; i++) {
            for(int j = i+1;j < array.length; j++) {
                int  currentSum = array[i] +  array[j];
                int  difference = targetSum - currentSum;
                if(allPairsSums.containsKey(difference)) {
                    for(Integer[] pair : allPairsSums.get(difference)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }
            for(int k =0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[k], array[i]};
                if(!allPairsSums.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<Integer[]>();
                    pairGroup.add(pair);
                    allPairsSums.put(currentSum, pairGroup);
                } else {
                    allPairsSums.get(currentSum).add(pair);
                }
            }
        }


        return quadruplets;
    }

    public static void main(String[] args) {
       int[] array = new int[]{7, 6, 4, -1, 1, 2};
       int targetSum = 16;

    }
}
