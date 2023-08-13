package com.zach.leetcode;

/**
 * @Description: 荷兰国旗问题，红白蓝三种颜色
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @Author Zach
 * @Date 2023-08-10 21:15
 * Version :1.0
 */
public class SortColors {
    public static void main(String[] args) {

        int[] array = new int[]{2,0,2,1,1,0};
        sortColors3(array);
        for (int num : array) {
            System.out.println(num);
        }
    }

    /**
     * 方法一，单指针
     * @param nums
     * @return
     */
    public static void sortColors1(int[] nums){
        int p0=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                swap(p0,i,nums);
                p0++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                swap(p0,i,nums);
                p0++;
            }
        }
    }

    /**
     * 方法二：双指针
     * @param nums
     */
    public static void sortColors2(int[] nums){
        int p0=0;
        int p1=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                //进行第一次交换
                swap(p0,i,nums);
                if(p0<p1){
                    //nums[i]此时为1，因为连续的0后面是连续的1,需要将nums[i]重新放到头部的末端
                    swap(p1,i,nums);
                }
                //因为p0与p1都是从0开始，所以p0移动时，p1也要同步移动，否则可能会将头部的0替换到1的后面
                p1++;
                p0++;
            }else if(nums[i]==1){
                swap(p1,i,nums);
                //只需要移动p1,p0在前面不影响
                p1++;
            }
        }
    }

    /**
     * 方法二：双指针优化
     * @param nums
     */
    public static void sortColors3(int[] nums){
        int p0=0;
        //指向元素2
        int p2=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                //进行第一次交换
                swap(p0,i,nums);
                p0++;
            }
            //当nums[i]==2时，若只交换一次，则交换后的nums[i]可能为0或者2，因为nums[p2]本来可能指向0或者2,所以p2需要不断从右往左移动，找到第一个不等于2的元素
            while (i<=p2&&nums[i]==2){
                swap(i,p2,nums);
                --p2;
            }
        }
    }

    public static void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
