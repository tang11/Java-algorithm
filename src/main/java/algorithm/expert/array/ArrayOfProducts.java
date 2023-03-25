package algorithm.expert.array;

import java.util.Arrays;

/**
 * @author tang lijuan
 * @date 2023/3/25
 */
public class ArrayOfProducts {
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.

        int[] products = new int[array.length];
        for(int i = 0; i< array.length; i++) {
            int runningProduct = 1;

            for(int j =0; j< array.length; j++) {
                if(i != j) {
                    runningProduct *= array[j];
                }
            }
            products[i] = runningProduct;
        }
        return products;
    }

    public static int[] arrayOfProducts1(int[] array) {
        // Write your code here.

        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        for(int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct =1;
        for(int i = array.length-1; i>=0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        for(int i =0; i< array.length; i++) {
            products[i] = leftProducts[i]* rightProducts[i];
        }
        return products;
    }

    public static int[] arrayOfProducts2(int[] array) {
        // Write your code here.
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for(int i =0 ; i< array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for(int i = array.length-1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return products;
    }
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 4, 2};
        System.out.println(Arrays.toString(arrayOfProducts(array)));
        System.out.println(Arrays.toString(arrayOfProducts1(array)));
        System.out.println(Arrays.toString(arrayOfProducts2(array)));
    }
}
