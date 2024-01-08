package algorithm.expert.array;

import java.util.HashSet;

/**
 * @author tang lijuan
 * @date 2023/3/25
 */
public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        int minimumSecondIndex = array.length;
        for(int i = 0; i< array.length; i++) {
            int value = array[i];
            for(int j = i +1; j < array.length; j++) {
                int valueToCompare = array[j];
                if(value == valueToCompare) {
                    minimumSecondIndex = Math.min(minimumSecondIndex, j);
                }
            }

        }
        if(minimumSecondIndex == array.length) {
            return -1;
        }
        return array[minimumSecondIndex];
    }

    public int firstDuplicateValue1(int[] array) {
        // Write your code here.

        HashSet<Integer> seen = new HashSet<Integer>();
        for(int value: array) {
            if(seen.contains(value)) {
                return value;
            }
            seen.add(value);
        }
        return -1;
    }

    public int firstDuplicateValue2(int[] array) {
        // Write your code here.
        for(int value: array) {
            int absValue = Math.abs(value);
            if(array[absValue - 1] < 0) {
                return absValue;
            }
            array[absValue -1] *= -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int expected = 2;
        int[]  array = new int[]{2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(array));
        assert  firstDuplicateValue(array) == expected;

    }
}
