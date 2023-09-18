package com.zach.leetcode;

/**
 * 寻找比目标字母大的最小字母
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 *
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 * 示例 1：
 *
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 解释：letters 中字典上比 'a' 大的最小字符是 'c'。
 * 示例 2:
 *
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。
 * 示例 3:
 *
 * 输入: letters = ["x","x","y","y"], target = "z"
 * 输出: "x"
 * 解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。
 *
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        String[] letters = {"c","f","j"};
        String target = "c";
        String rest = nextGreatestLetter(letters, target);
        System.out.println(rest);
    }

    /**
     *
     * @param letters
     * @param target
     * @return
     */
    public static String nextGreatestLetter(String[] letters,String target){
        int low = 0;
        int high = letters.length-1;
        //先判断最后一个元素，若最后一个元素都小于等于target，则数组中不存在比target大的元素
        if(letters[high].charAt(0)<=target.charAt(0)){
            return letters[low];
        }
        while (low<high){
          int mid = low + (high-low)/2;
          if(letters[mid].charAt(0)<=target.charAt(0)){
              low = mid+1;
          }else {
              high=mid;
          }
        }
        return letters[low];
    }

    /**
     * 线性查找
     * @param letters
     * @param target
     * @return
     */
    public static String nextGreatestLetter2(String[] letters,String target){
        int len = letters.length-1;
        for (int i = 0; i <=len; i++) {
            if(letters[i].charAt(0)>target.charAt(0)){
                return letters[i];
            }
        }
        return letters[0];
    }
}
