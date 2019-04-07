package com.zach.geekbang.alogrithm;

/**
 * 二分法搜索
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,9};
        //System.out.println(binarySearch(a,5));
        System.out.println(1+(3-1)>>1);
    }

    public static int binarySearch(int[]A,int value) {
        int low = 0;
        int len = A.length;
        int high = len -1;

        while(low <= high) {
            int mid =low+((high - low)>>1);
            if(A[mid] == value)
                return mid;
            else if (A[mid] < value)
                low = mid +1;
            else
                high = mid -1;
        }
        return -1;
    }

    /**
     * 二分法搜索的递归实现
     */
    public static int bsearch(int[] a,int n,int val) {
        return bsearchInternally(a,0,n-1,val);
    }

    private static int bsearchInternally(int[] a,int low,int high,int value) {
        if(low >high)
            return -1;
        int mid = low +((high - low)>> 1);
        if(a[mid] == value) {
            return mid;
        }else if(a[mid] < value)
            return bsearchInternally(a,mid+1,high,value);
        else {
            return bsearchInternally(a,low,mid-1,value);
        }
    }


    /**
     * 二分法变形: 查找第一个值等于给定值得元素;
     */
    public int findFirstValue(int[] a, int n,int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if(a[mid]>=value) {
                high = mid -1;
            }else {
                low = mid +1;
            }
        }

        if(low <n && a[low] == value)
            return low;
        else
            return -1;

    }

    /**
     * 二查找第一个值等于给定值得元素(二);
     */
    public int getFirstValue(int[] a,int n,int value) {
        int low = 0;
        int high = n -1;
        while (low <= high){
            int mid  = low +((high - low)>> 1);
            if(a[mid]>value)
                high = mid -1;
            else if (a[mid]< value)
                low = mid +1;
            else {
                if(mid == 0 || a[mid -1] != value)
                    return mid;
                else
                    high = mid -1;
            }
        }
        return -1;
    }

    /**
     * 二分查找最后一个值等于给定值的元素;
     */
    public int findLastValue(int[] a,int n,int value) {
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low +((high-low)>>1);
            if(a[mid]>value)
                high = mid -1;
            else if (a[mid]<value)
                low = mid +1;
            else {
                if(mid == n-1 || a[mid+1] != value)
                    return mid;
                else
                    low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 二分查找: 查找第一个大与等于给定值的元素
     */
    public int findGreateOrEqual(int[] a,int n,int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if(a[mid]>= value) {
                if(mid == 0 || a[mid-1]<value)
                    return mid;
                else
                    high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public int bsearch7(int[] a,int n,int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low)>> 1);
            if(a[mid]>value)
                high = mid -1;
            else {
                if(mid == n-1 || a[mid+1]>value)
                    return mid;
                else
                    low = mid +1;
            }
        }
        return -1;
    }

}

