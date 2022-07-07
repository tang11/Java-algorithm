package com.algorithm.zalado;

import java.util.*;

/**
 * @author shenli
 * @date 2022/6/29
 *
 * 1
 *
 * steps to implement I have used Multiple steps to sort out the problem below are the steps.
 *
 * Step 1: convert the each String to Integer List and add each integer list to a Map object with Key as index and Value is a created List
 *
 * Step 2: Iterate the Map to find out how many repeated days in each List and take the counts for those dates.
 *
 * Step3: find out the repeated date occurrences in input Strings for each employee.
 *
 * final you get the actual count
 */
public class TwoDays {
    public int solution(String[] E) {
        // write your code in Java SE 8
        if(E == null || E.length==0) {
            return 0;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;

        for(String avaliableTime : E) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j< avaliableTime.length(); j++) {
                int time = Integer.parseInt(String.valueOf(avaliableTime.charAt(j)));
                list.add(time);
                map.put(index,list);
                index++;
            }
            Map<Integer,Long> counts = new HashMap<>();
            for(List<Integer> temp: map.values()) {
                for(int n : temp) {
                    Long c =counts.get(n);
                    if(c==null){
                        c = 0L;
                    }
                    counts.put(n,c+1);
                }
            }
            Iterator<Long> it = counts.values().iterator();
            while(it.hasNext()) {
                long d = it.next();
                if(d == 1L){
                    it.remove();
                }
            }
            Map<String ,Integer> map1 = new HashMap<>();
            Set<Integer> set = counts.keySet();
            for(String s: E) {
                for (int a: set) {
                    if(s.contains(a+"")) {
                        map1.put(s,a);
                    }
                }
            }
            return (int) map1.entrySet().stream().count();

        }
        int emptySum =0;
        int[] result = new int[10];
        int[] resultBack = new int[10];
        for(int i =0; i< E.length; i++) {
            String avaliableTime = E[i];

            //special case
            if(avaliableTime== null || avaliableTime.length() ==0) {
                emptySum++;
                continue;
            }
            for(int j = 0; j< avaliableTime.length(); j++) {

                result[index]++;
                resultBack[index]++;
            }
        }



        //choose two days which most people can attend
        int index1 = findMaxIndex(resultBack);
        resultBack[index1] = 0;
        int index2 = findMaxIndex(resultBack);

        Arrays.sort(result);

        int sum = result[result.length-1]+ result[result.length-2];
        for(int k =0; k< E.length; k++) {
            String avaliableTime = E[k];
            if(avaliableTime.contains(String.valueOf(index1)) && avaliableTime.contains(String.valueOf(index2))) {
                sum--;
            }
        }

        if( sum >= E.length) {
            return E.length - emptySum;
        }
        return sum;
    }

    public int findMaxIndex(int[] result) {
        int max =0;
        int index =0;
        for(int i=0; i< result.length; i++) {
            if(result[i] > max) {
                max = result[i];
                index = i;
            }
        }
        return index;
    }

}
