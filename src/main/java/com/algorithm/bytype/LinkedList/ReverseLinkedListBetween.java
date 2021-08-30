package com.algorithm.bytype.LinkedList;

/**
 * @author tanglijuan
 * @date 2021/8/30
 * 1、我们定义两个指针，分别称之为 g(guard 守卫) 和 p(point)。
 * 我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。我们以 m=2，n=4为例。
 * 2、将 p 后面的元素删除，然后添加到 g 的后面。也即头插法。
 * 3、根据 m 和 n 重复步骤（2）
 * 4、返回 dummyHead.next
 */
public class ReverseLinkedListBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for (int step = 0; step < m - 1; step++) {
            g = g.next;
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
    
}
