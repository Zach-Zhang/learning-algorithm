package com.zach.alogrithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/*Write a class RecentCounter to count recent requests.
    It has only one method: ping(int t), where t represents some time in milliseconds.

    Return the number of pings that have been made from 3000 milliseconds ago until now.

    Any ping with time in [t - 3000, t] will count, including the current ping.

    It is guaranteed that every call to ping uses a strictly larger value of t than before.
    Example 1:

    Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
    Output: [null,1,2,3,3]

    Note:

    Each test case will have at most 10000 calls to ping.
    Each test case will call ping with strictly increasing values of t.
    Each call to ping will have 1 <= t <= 10^9.*/
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int ping = recentCounter.ping(30001);
        System.out.println(ping);
    }

        public  int ping(int t) {
            queue.add(t);
            while (queue.peek() <t-3000)
                queue.poll();
            Integer poll = queue.poll();
            System.out.println(poll);
            System.out.println();
            return queue.size();
        }



}
