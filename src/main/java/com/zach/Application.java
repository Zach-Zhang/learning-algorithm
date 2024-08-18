package com.zach;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description
 * @createTime 2022年02月15日 17:44:00
 */
public interface Application {
     static void main(String[] args) throws Exception {
        int i = 1;
        tryComplete:
        if (true) {
            System.out.println("tryComplete");
            if (i > 0) {
                System.out.println("tryComplete end");
                break tryComplete;
            }
            System.out.println("测试");
            System.out.println("break out");
        }
        System.out.println("finish");
    }
}
