package com.zach.frequency;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2022年01月24日 19:46:00
 */
public class IsStraight {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 2, 6, 4, 5, 7,8};
        System.out.println(isStraight(nums));
    }

    /**
     * 排序+癞子填补相邻元素的差值
     *
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int cnt = 0;
        //统计癞子数量
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }

        //使用癞子填补相邻的不连续的数字之间差值,如果存在相同的牌,则也不能构成顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            //使用癞子填补差距
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        return cnt >= 0;
    }

    //集合Set+遍历集合,五张牌成为顺子的条件: 1. 没有重复; 2. max-min<5
    public static boolean isStraight2(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        HashSet<Integer> repeat = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                //跳过癞子
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    //排序 + 遍历
    public static boolean isStraight3(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                cnt++;
            }
            if (nums[i + 1] == nums[i]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[cnt] < 5;

    }

}
