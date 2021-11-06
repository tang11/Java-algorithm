package com.algorithm;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/11/6
 */
public class Twitter {

    class Tweet {
        private int id;

        private int timeStamp;
        private Tweet next;

        public Tweet(int id, int timeStamp) {
            this.id = id;
            this.timeStamp = timeStamp;
        }
    }

    /**
     * 用户 id 和推文（单链表）的对应关系
     */
    private Map<Integer, Tweet> twitterMap;
    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;
    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;
    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     */
    private static PriorityQueue<Tweet> maxHeap;


    public Twitter() {
        twitterMap = new HashMap<>();
        followings = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.timeStamp - o1.timeStamp);
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitterMap.containsKey(userId)) {
            Tweet oldHead = twitterMap.get(userId);
            Tweet newTweet = new Tweet(tweetId, tweetId);
            newTweet.next = oldHead;
            twitterMap.put(userId, newTweet);
        } else {
            twitterMap.put(userId, new Tweet(tweetId, tweetId));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitterMap.containsKey(userId)) {
            maxHeap.offer(twitterMap.get(userId));
        }
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitterMap.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> followingList = followings.get(followeeId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }

    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> followingList = followings.get(followeeId);
        if (followingList == null) {
            return;
        }
        if (followingList.contains(followeeId)) {
            followingList.remove(followeeId);
        }
    }
}
