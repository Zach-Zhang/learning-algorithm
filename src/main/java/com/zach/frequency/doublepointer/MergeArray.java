package com.zach.frequency.doublepointer;

import java.util.Arrays;

/**
 * @Description: 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Zach
 * @Date 2022/2/23 10:18
 * Version :1.0
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge3(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    /**
     * 方法一: 直接合并之后排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针，因为nums1与nums2是已经经过排序了，所以可以将两个数组看成队列，两个指针分别指向队头元素
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (i < m || j < n) {
            if (i == m) {
                cur = nums2[j++];
            } else if (j == n) {
                cur = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
            sorted[i + j - 1] = cur;
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = sorted[k];
        }
    }

    /**
     * 逆向双指针，因为nums1尾部还补全了n个0，可以直接覆盖；
     * 因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 nums1的最后面
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int mergeIndex = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[mergeIndex--] = nums2[j--];
            } else if (j < 0) {
                nums1[mergeIndex--] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[mergeIndex--] = nums2[j--];
            } else {
                nums1[mergeIndex--] = nums1[i--];
            }
        }
    }
}
