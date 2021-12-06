package com.algorithm.abytype.twosum;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/11/17
 */
public class TwoSumII {

    static HashMap<Integer, Integer> frequency = new HashMap<>();

    public static void add(int number) {
        frequency.put(number, frequency.getOrDefault(number, 0) + 1);
    }

    public static boolean find(int value) {
        for (int key : frequency.keySet()) {
            int diff = value - key;
            if (diff == key && frequency.get(key) > 1) {
                return true;
            }
            if (diff != key && frequency.containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    static Set<Integer> sum = new HashSet<>();
    static List<Integer> nums = new ArrayList<>();

    public static void add1(int number) {
        for (int item : nums) {
            sum.add(item + number);
        }
        nums.add(number);
    }

    public static boolean find1(int value) {
        return sum.contains(value);
    }

    public static void main(String[] args) {
        add(3);
        add(3);
        add(2);
        add(5);
        System.out.println(find(6));
    }
}
