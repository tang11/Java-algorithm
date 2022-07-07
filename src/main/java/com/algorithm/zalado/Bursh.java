package com.algorithm.zalado;

/**
 * @author shenli
 * @date 2022/6/29
 *
 * 应该是一道动态规划题
 * https://stackoverflow.com/questions/56373582/how-can-i-count-how-many-horizontal-brush-strokes-are-required-to-draw-an-array
 *
 * A brush stroke starts whenever the height increases going from left to right,
 * and ends when it decreases. You only need to look at when it increases,
 * because if you just count the starting points of each stroke you will have the stroke count.
 * Instead of looping over the height levels in an inner loop,
 * Permutationsjust subtract one height level from the previous to get the difference.
 */
public class Bursh {
    public int solution(int[] A) {
        if(A == null || A.length ==0) {
            return 0;
        }
        int count =0;
        int previousHeight = 0;
        for (int i=0; i < A.length; i++) {
            if(A[i] > previousHeight) {
                count = count+ (A[i] - previousHeight);

            }
            previousHeight = A[i];


        }
        return count;

    }
}
