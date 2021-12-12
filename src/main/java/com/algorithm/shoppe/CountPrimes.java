package com.algorithm.shoppe;

import java.util.Arrays;

/**
 * @author shenli
 * @date 2021/12/10
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {

    /**
     * ：如果 xx 是质数，那么大于 xx 的 xx 的倍数 2x,3x,\ldots2x,3x,… 一定不是质数，
     * 我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。
     * 从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 0，这样在运行结束的时候我们即能知道质数的个数。
     * 时间复杂度：O(nloglogn)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
