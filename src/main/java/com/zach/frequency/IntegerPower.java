package com.zach.frequency;

/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class IntegerPower {
    public static void main(String[] args) {

    }

    /**
     * 快速幂迭代+递归
     * 如果要计算x^64=x->x^2->x^4->x^8->X^16->X^32->X^64;
     * 从X开始,每次直接把上一次的结果进行平方,计算6次就可以得到X^64的值,而不需要X乘以63次X
     * 因此要计算x^n 可先递归的计算y=X^n/2,n为偶数,则x^n=y^2,如果n为奇数,那么X^n=y^2*x;
     * 递归的边界为n=0,任意数的0次方均为1,由于每次递归,都会使得指数减少为一半,因此递归层数为O(logn)
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }
}
