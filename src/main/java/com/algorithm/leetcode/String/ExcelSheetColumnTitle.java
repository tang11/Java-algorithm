package com.algorithm.leetcode.String;

/**
 * leetcode168
 *
 * @date 2021/8/3
 * <p>
 * 这是一道从 11 开始的的 2626 进制转换题。
 * <p>
 * 对于一般性的进制转换题目，只需要不断地对 columnNumbercolumnNumber 进行 % 运算取得最后一位，然后对 columnNumbercolumnNumber 进行 / 运算，将已经取得的位数去掉，直到 columnNumbercolumnNumber 为 00 即可。
 * <p>
 * 一般性的进制转换题目无须进行额外操作，是因为我们是在「每一位数值范围在 [0,x)[0,x)」的前提下进行「逢 xx 进一」。
 * <p>
 * 但本题需要我们将从 11 开始，因此在执行「进制转换」操作前，我们需要先对 columnNumbercolumnNumber 执行减一操作，从而实现整体偏移。
 * <p>
 * 作者：AC_OIer
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/gong-shui-san-xie-cong-1-kai-shi-de-26-j-g2ur/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
