package com.zach.alogrithm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void printArray(int[] nums){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            if(i != nums.length-1){
                sb.append(nums[i]).append(",");
            }else {
                sb.append(nums[i]).append("]");
            }
        }
        System.out.println(sb.toString());
    }
}
