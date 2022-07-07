package com.algorithm.grab;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenli
 * @date 2022/7/2
 */
public class Bulbs {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> missing = new HashSet<>();
        Set<Integer> store = new HashSet<>();
        int result = 0;
        for(int i =0;i< A.length;i++) {
            if(!store.contains(i+1) && i+1!=A[i]) {
                missing.add(i+1);
            }
            if(i+1 < A[i]){
                store.add(A[i]);
            } else{
                missing.remove(A[i]);
                if(missing.isEmpty()){
                    result++;
                }
            }
        }
        return result;
    }
}
