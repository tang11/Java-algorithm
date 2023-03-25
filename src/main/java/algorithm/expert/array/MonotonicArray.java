package algorithm.expert.array;

/**
 * @author tang lijuan
 * @date 2023/3/20
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if(array.length <=2) {
            return true;
        }
        int direction = array[1] - array[0];
        for(int i= 2; i< array.length; i++) {
            if (direction == 0) {
                direction  = array[i] - array[i-1];
                continue;
            }
            if(breakDirection(direction, array[i-1], array[i])){
                return false;
            }

        }
        return true;
    }
    public static boolean breakDirection(int direction, int preInt, int curInt) {
        int diff = curInt - preInt;
        if(direction > 0) {
            return diff < 0;
        }
        return diff > 0;
    }

    public static boolean isMonotonic1(int[] array) {
        boolean isNonDecresing = true;
        boolean isNonIncreasing = true;
        for(int i =1; i < array.length; i++) {
            if(array[i] < array[i-1]) {
                isNonDecresing  = false;
            }
            if(array[i] > array[i-1]) {
                isNonIncreasing = false;
            }
        }
        // Write your code here.
        return isNonDecresing || isNonIncreasing;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(arr));
        System.out.println(isMonotonic1(arr));
    }
}
