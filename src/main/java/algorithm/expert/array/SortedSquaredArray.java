package algorithm.expert.array;

import java.util.Arrays;

/**
 * @author tang lijuan
 * @date 2023/3/16
 */
public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] arr= new int[]{1, 2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int counter = array.length -1;
        int firstIdx = 0;
        int lastIdx= array.length -1;
        int[] out = new int[array.length];
        for(int i =0;i < array.length; i++) {
            if(Math.abs(array[firstIdx]) >  Math.abs(array[lastIdx])){
                out[counter -i] = array[firstIdx]  * array[firstIdx];
                firstIdx++;
            } else {
                out[counter -i] = array[lastIdx]  * array[lastIdx];
                lastIdx--;

            }
        }
        // Write your code here.
        return out;
    }
}
