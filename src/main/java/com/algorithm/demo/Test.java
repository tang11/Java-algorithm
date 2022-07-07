package com.algorithm.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * @date 2022/2/14
 */
public class Test {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SceneItem {
        String name;
        List<SceneItem> children;
    }


    public static void main(String[] args) {
        List<SceneItem> scnenLists = new ArrayList<SceneItem>();
        List<SceneItem> children = new ArrayList<>();
        SceneItem child1 = new SceneItem("采购协议", null);
        children.add(child1);
        SceneItem child2 = new SceneItem("销售协议", null);
        children.add(child2);
        SceneItem item1 = new SceneItem("通用场景", children);
        List<SceneItem> children1 = new ArrayList<>();
        SceneItem child3 = new SceneItem("汽车协议", null);
        children.add(child3);
        SceneItem child4 = new SceneItem("协议", null);
        children.add(child4);
        SceneItem item2 = new SceneItem("汽车",children1);
        scnenLists.add(item1);
        scnenLists.add(item2);
//        System.out.println(JSON.toJsonString(scnenLists));


    }
}
