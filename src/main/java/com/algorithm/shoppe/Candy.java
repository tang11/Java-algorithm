package com.algorithm.shoppe;

/**
 * @author tanglijuan
 * @date 2021/12/10
 *
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。

 */
public class Candy {

    /**
     *
     * 我们可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理。
     *
     * 左规则：当 \textit{ratings}[i - 1] < \textit{ratings}[i]ratings[i−1]<ratings[i] 时，ii 号学生的糖果数量将比 i - 1i−1 号孩子的糖果数量多。
     *
     * 右规则：当 \textit{ratings}[i] > \textit{ratings}[i + 1]ratings[i]>ratings[i+1] 时，ii 号学生的糖果数量将比 i + 1i+1 号孩子的糖果数量多。
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i>0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }else {
                left[i] = 1;
            }
        }
        int right = 0; int ret =0;
        for (int i = n-1; i>=0; i--) {
            if (i < n-1 && ratings[i] > ratings[i+1]) {
                right ++;
            }else {
                right = 1;
            }
            ret += Math.max(left[i],right);
        }
        return ret;
    }
}
