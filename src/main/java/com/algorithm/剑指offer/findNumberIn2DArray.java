package com.algorithm.剑指offer;

/**
 *
 * @date 2021/8/15
 */
public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length ==0) {
            return false;
        }
        int i = 0;
        int j = matrix[i].length -1;
        while(i< matrix.length && j >=0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
