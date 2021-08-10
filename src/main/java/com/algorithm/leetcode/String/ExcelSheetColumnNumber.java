package com.algorithm.leetcode.String;

/**
 * leetcode171
 *
 * @date 2021/8/10
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int j = 0; j < columnTitle.length(); j++) {
            int cur = columnTitle.charAt(j) - 'A' + 1;
            result = result * 26 + cur;
        }
        return result;
    }
}
