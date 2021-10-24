package com.algorithm.bytype.binaryTree;

/**
 * @author shenli
 * @date 2021/10/24
 */
public class numTrees {
    public static int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long num = 1;
        for (int i = 0; i < n; ++i) {
            num = num * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) num;
    }

    public static void main(String[] args) {
        int n1 = 1;
        int n2=2;
        int n3= 3;
        System.out.println(numTrees(n1));
        System.out.println(numTrees(n2));
        System.out.println(numTrees(n3));

    }

}
