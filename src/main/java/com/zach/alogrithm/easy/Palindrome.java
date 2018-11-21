package com.zach.alogrithm.easy;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(method(0));
    }

    public static boolean method(int x) {
        int r = x;
        int result = 0;

        if(x <0) {
            return false;
        }
        while(x != 0) {

           int rest =  x % 10;

           int newResult = result*10+rest;

           if((newResult-rest) /10 != result)
               return false;
          result = newResult;
           x /= 10;

        }

        return r==result ? true : false;
    }
}
