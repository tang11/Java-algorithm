package com.algorithm;

import java.util.Arrays;

/**
 * @author tanglijuan
 * @date 2021/9/4
 */
public class FindArrayQuadruplet {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        // your code goes here
        int n = arr.length;
        Arrays.sort(arr);
        if(n < 4) {
            return new int[]{};
        }
        for(int i =0; i<=n-4;i++){
            for(int j =i+1; j<= n-3; j++) {
                int  r= s - arr[i] - arr[j];
                int low = j +1;
                int hig = n -1;
                while(low < hig) {
                    if(arr[low] + arr[hig] < r) {
                        low ++;
                    } else if(arr[low] + arr[hig] > r) {
                        hig --;
                    } else {
                        return new int[]{arr[i], arr[j], arr[low],arr[hig]};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 0, 9, 5, 1, 3};
        int s = 20;
        int[] arr1= new int[]{4,4,4,4};
        int s1= 16;
        System.out.println(Arrays.toString(findArrayQuadruplet(arr, s)));
        System.out.println(Arrays.toString(findArrayQuadruplet(arr1,s1)));
    }
}
