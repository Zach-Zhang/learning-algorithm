package com.zach.leetcode;

import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * @Author Zach
 * @Date 2023-08-04 21:49
 * Version :1.0
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,3,3,3};

        int[] nums2 = new int[]{1,2,3,4,5};
        Integer[] nums3 = new Integer[]{1,1,1,2,2,3,3,3,3};
        int k = 2;
        int[] ret = new int[k];
        topKFrequent2(nums3,k,ret);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
    public static int[] topKFrequent2(Integer[] nums,int k,int[] ret){
        Map<Integer,Integer> frequentMap = new HashMap<>(nums.length);
        for (int num : nums) {
            int frequent = frequentMap.getOrDefault(num,0)+1;
            frequentMap.put(num,frequent);
        }
        List<int[]> pairList = new ArrayList<>(frequentMap.size());
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            pairList.add(new int[]{num,count});
        }
        quickSort(pairList,ret,0,0,pairList.size()-1,k);
        return ret;
    }
    public static int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> frequentMap = new HashMap<>(nums.length);
        for (int num : nums) {
            int frequent = frequentMap.getOrDefault(num,0)+1;
            frequentMap.put(num,frequent);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            Integer num = entry.getKey();
            Integer frequent = entry.getValue();
            if (heap.size()==k){
                 int[] peer = heap.peek();
                 if(peer==null){
                     continue;
                 }
                 if(peer[1]<frequent){
                     heap.poll();
                     heap.offer(new int[]{num,frequent});
                 }
            }else {
                heap.offer(new int[]{num,frequent});
            }
        }
        int[] result = new int[heap.size()];
        for (int j = 0; j < k; j++) {
            if(heap.size()==0){
                break;
            }
            result[j] = heap.poll()[0];
        }
        return result;
    }

    public static void quickSort(List<int[]> pairList,int[] ret,int retIndex,int start,int end,int k){

       int pivot =  calIndex(pairList,start,end);
       if(k<=pivot-start){
           quickSort(pairList,ret,retIndex,start,pivot-1,k);
       }else {
           for (int i = start; i <= pivot; i++) {
               ret[retIndex++]=pairList.get(i)[0];
           }
           if(k>pivot-start+1){
               quickSort(pairList,ret,retIndex,pivot+1,end,k-(pivot-start+1));
           }
       }
    }

    private static int calIndex(List<int[]> pairList, int low, int high) {
        int temp = pairList.get(low)[1];
        while (low<high){
            while (low<high&&pairList.get(high)[1]<=temp){
                high--;
            }
            pairList.get(low)[1]=pairList.get(high)[1];
            while (low<high&&pairList.get(low)[1]>=temp){
                low++;
            }
            pairList.get(high)[1]=pairList.get(low)[1];
        }
        pairList.get(low)[1]= temp;
        return low;
    }

    private static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }



}
