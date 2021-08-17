package com.zach.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 和为 S 的连续正数序列
 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 * @Author Zach
 * @Date 2021/8/17 7:45
 * Version :1.0
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        List<List<Integer>> continuousSequence = findContinuousSequence(15);
        System.out.println(continuousSequence);
    }

    public static List<List<Integer>> findContinuousSequence(int target) {
        //滑动窗口左边界
        int start = 1;
        //滑动窗口右边界
        int end = 2;
        //滑动窗口的和
        int curSum = 3;
        List<List<Integer>> continuousList = new ArrayList<>();
        while (end < target) {
            if (curSum < target) {
                //滑动窗口右边界向右移动
                end++;
                curSum += end;
            } else if (curSum > target) {
                //左边界向右移动
                curSum -= start;
                start++;
            } else {
                //取出窗口中的元素
                List<Integer> res = new ArrayList<>(end - start);
                for (int i = start; i <= end; i++) {
                    res.add(i);
                }
                continuousList.add(res);
                //左右边界整体向右移动
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return continuousList;
    }
}
