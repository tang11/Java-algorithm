package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shenli
 * @date 2021/11/24
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 */
public class FindMode {
    List<Integer> res = new ArrayList<>();
    int base;
    int count;
    int maxcount;
    public int[] findMode(TreeNode root) {
        dfs(root,res);
        int[] mode = new int[res.size()];
        for(int i =0;i< res.size();i++) {
            mode[i] = res.get(i);
        }
        return mode;
    }
    public void dfs(TreeNode root,List<Integer> res) {
        if(root == null) {
            return;
        }
        dfs(root.left,res);
        update(root.val);
        dfs(root.right,res);
    }
    public void update(int x) {
        if(x == base) {
            count++;
        } else {
            count=1;
            base=x;
        }
        if(count == maxcount) {
            res.add(base);
        }
        if(count > maxcount) {
            maxcount  = count;
            res.clear();
            res.add(base);
        }
    }

    public static void main(String[] args) {
        HashMap <Character,Integer> map = new HashMap<>();
        String s = "456";
        char d1 = 'c';
        char d2= 'c';
        System.out.println(d1==d2);
        System.out.println(Integer.parseInt(s.substring(0,3)));
    }
}
