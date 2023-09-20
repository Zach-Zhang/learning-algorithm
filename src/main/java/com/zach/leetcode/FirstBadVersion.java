package com.zach.leetcode;

/**
 * 第一个错误的版本
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 */
public class FirstBadVersion {
    public static int badVersion = 2;
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n){
        int low = 1;
        int high = n;
        while (low<high){
            int mid = low+(high-low)/2;
            if(isBadVersion(mid)){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }

    private static boolean isBadVersion(int mid) {
        return mid==badVersion;
    }
}
;