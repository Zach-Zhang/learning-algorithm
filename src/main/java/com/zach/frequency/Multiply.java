package com.zach.frequency;

/**
 * @Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Zach
 * @Date 2022/2/10 22:39
 * Version :1.0
 */
public class Multiply {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] multiply = multiply2(a);
        for (int i = 0; i < multiply.length; i++) {
            System.out.println(multiply[i]);

        }
    }

    public static int[] multiply(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int len = a.length;
        //左边乘积的集合
        int[] left = new int[len];
        left[0] = 1;

        //右边元素乘积的集合
        int[] right = new int[len];
        right[len - 1] = 1;
        int[] res = new int[len];
        //计算左边,不包含当前元素
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        //计算右边的元素,不包含当前元素
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        //计算左边*右边乘积
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;

    }

    /**
     * 方法二,利用一个临时变量,减少一个循环
     * @param A
     * @return
     */
    public static int[] multiply2(int[] A) {
        int len = A.length;
        if (len == 0) {
            return new int[0];
        }
        int[] b = new int[len];
        b[0] = 1;
        //right表示当前元素右边所有元素的乘积（不包含当前元素）,
        int right = 1;
        //左边元素的乘积
        for (int i = 1; i < len; i++) {
            b[i] = b[i-1] * A[i - 1];
        }
        //b[i]表示的是左边的乘积，b[i] *= right;相乘就是除自己意外元素的乘积
        for (int i = len - 1; i >= 0; i--) {
            //左边乘以右边
            b[i] *= right;
            //right表示当前元素右边所有元素的乘积（不包含当前元素）
            right *= A[i];

        }
        return b;
    }
}
