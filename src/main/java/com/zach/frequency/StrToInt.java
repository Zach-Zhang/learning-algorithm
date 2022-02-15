package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 * @createTime 2022年02月15日 16:52:00
 */
public class StrToInt {
    public static void main(String[] args) {
        int i = strToInt("-12345W6");
        System.out.println(i);
    }

    /**
     * 字符串转数字
     *
     * @param digit
     * @return
     */
    public static int strToInt(String digit) {
        if (StringUtils.isBlank(digit)) {
            return 0;
        }
        char[] charArray = digit.trim().toCharArray();
        int sign = 1;
        int i = 1;
        if (charArray[0] == '-') {
            sign = -1;
            i = 1;
        } else if (charArray[0] != '+') {
            i = 0;
        }
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        for (int j = i; j < charArray.length; j++) {
            char ch = charArray[j];
            //存在无效字符
            if (ch < '0' || ch > '9') {
                break;
            }
            //判断数字越界问题
            if (res > bndry || res == bndry && charArray[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + charArray[j] - '0';
        }
        return sign * res;
    }

}
