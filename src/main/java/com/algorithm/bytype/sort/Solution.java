package com.algorithm.bytype.sort;

/**
 * @author tanglijuan
 * @date 2021/11/25
 */
public class Solution {
    public int solution(int[] A) {

        int min = Integer.MAX_VALUE;

        for (int p = 1; p < A.length - 2; p++) {
            for (int q = p + 2; q < A.length - 1; q++) {
                if (A[p] + A[q] < min) {
                    min = A[p] + A[q];
                }
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 3, 1, 7};
        Solution solution = new Solution();
        System.out.print(solution.solution(A));
        Long a = new Long(3445);
        System.out.println(a==3445);
    }

}
