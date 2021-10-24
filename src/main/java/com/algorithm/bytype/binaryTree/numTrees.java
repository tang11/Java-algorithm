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

    public static int numTrees1(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    public static void main(String[] args) {
        int n1 = 1;
        int n2=2;
        int n3= 3;
        System.out.println(numTrees(n1));
        System.out.println(numTrees(n2));
        System.out.println(numTrees(n3));
        System.out.println(numTrees1(n1));
        System.out.println(numTrees1(n2));
        System.out.println(numTrees1(n3));

    }

}
