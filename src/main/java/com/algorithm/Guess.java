package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/8
 */
public class Guess {
    static HashMap<Integer, List<Integer>> secretMap = new HashMap<>();

    public static String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return "0A0B";
        }
        for (int i = 0; i < secret.length(); i++) {
            int tmp = Integer.parseInt(String.valueOf(secret.charAt(i)));
            if (secretMap.get(tmp) != null) {
                secretMap.get(tmp).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                secretMap.put(tmp, index);
            }
        }
        int sumBulls = 0;
        int sumCows = 0;
        for (int i = 0; i < guess.length(); i++) {
            int tmp = Integer.parseInt(String.valueOf(guess.charAt(i)));
            if (secretMap.containsKey(tmp)) {
                List<Integer> index = secretMap.get(tmp);
                if (index != null && index.size() > 0) {
                    if (index.contains(i)) {
                        sumBulls++;
                        index.remove(i);
                    } else {
                        sumCows++;
                        index.remove(i);
                    }
                }
                secretMap.put(tmp,index);

            }
        }
        return sumBulls + "A" + sumCows + "B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(getHint(secret, guess));
    }
}
