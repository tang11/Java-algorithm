package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * @date 2021/8/20
 */
public class findContinuousSequence1 {
    public int[][] c(int target) {
        List<List<Integer>> res = new ArrayList<>();
        int end = target / 2 + 1;
        for (int i = end; i > 0; i--) {
            List<Integer> temp = new ArrayList<>();
            int sum = i;
            int diff = target - i;
            temp.add(i);
            for (int j = i - 1; j > 0; j--) {
                if (j == diff) {
                    temp.add(j);
                    res.add(temp);
                    continue;
                } else if (j > diff) {
                    break;
                } else {
                    temp.add(j);
                }
            }

        }
        return null;
    }
}
