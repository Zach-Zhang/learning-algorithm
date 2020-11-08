package com.zach;

/**
 * Created by Zach
 * Date :2020/11/7 15:02
 * Description :
 * Version :1.0
 */
public class Main {
    public static void main(String[] args) {
        f();
    }
    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }
}
