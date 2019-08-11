package com.zach.geekbang.alogrithm;

/**
 * 二分法搜索
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 9, 10, 11};
        int[] b = {3,4,6,7,10};
        System.out.println("查找第一个等于value的值,实现方案一: "+binarySearchFirstOne(a, 10));
        System.out.println("找第一个等于value的值,实现方案二: "+binarySearchFirstTwo(a, 8));
        System.out.println("查找最后一个等于value得元素: "+binarySearchLast(a, 10));
        System.out.println("查找第一个大于给定值的元素: "+bindSearchFirstGreatOrEqual(b, 5));
        System.out.println("查找最后一位小于等于value的元素: "+bindSearchLastLessOrEqual(a, 0));
    }

    /**
     * 查找第一个等于value的值,实现方案一
     *
     * @param a
     * @param value
     * @return
     */
    public static int binarySearchFirstOne(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 查找第一个等于value的值,实现方案二
     *
     * @param a
     * @param value
     * @return
     */
    public static int binarySearchFirstTwo(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value)
                high = mid - 1;
            else if (a[mid] < value)
                low = mid + 1;
            else {
                //当a[mid]=value时,若mid=0,则mid肯定是第一个元素,或者a[mid-1]!=value,则mid前面的元素都是小于value的,
                // 因为数组是有序的,所以mid就是第一个等于value的值
                if (mid == 0 || a[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于value得元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int binarySearchLast(int[] a, int value) {
        int low = 0;
        int n = a.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value)
                high = mid - 1;
            else if (a[mid] < value)
                low = mid + 1;
            else {
                //当a[mid]=value时,若mid=n-1,则mid肯定是第一个元素,或者a[mid+1]!=value,则mid后面的元素都是大于value的,
                // 因为数组是有序的,所以mid就是最后一个等于value的值
                if (mid == n - 1 || a[mid + 1] != value)
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int bindSearchFirstGreatOrEqual(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value)
                    return mid;
                else
                    high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一位小于等于value的元素
     * @param a
     * @param value
     * @return
     */
    public static int bindSearchLastLessOrEqual(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if(mid==n-1 || a[mid+1]>value){
                    return mid;
                }else{
                    low = mid + 1;
                }

            }
        }
        return -1;
    }
}
