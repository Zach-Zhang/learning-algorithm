package com.zach.frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname FindMaxSubStr
 * @Description: 给定一个字符串，输出不含有重复字符的最长子串的长度。
 * 例如： 输入: "abcabcbb"  输出: 3； 输入："aaaaa" 输出：1
 * @Date 2020/7/12 17:26
 * @Author: Zach
 * @version: V1.0
 */
public class FindMaxSubStr {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(mehtod4(str));
    }

    //使用allUnique()函数,能检测字符串中的子串都是唯一的,无重复的
    public static int method1(String str) {
        int n = str.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(str, i, j))
                    ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    private static boolean allUnique(String str, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = str.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    //滑动窗口思想
    /*如果确定子串s[i,j]（假设表示字符串的第i个字符到第j-1个字符表示的子串），那么只需要比较s[j]是否与子串s[i,j]重复即可

    若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值。然后滑动窗口大小重定义为1，头位置不变，并右移一个单位。

    若不重复：滑动窗口头不变，结尾+1，整个窗口加大1个单位。继续比较下一个。*/

    //使用hashSet
    public static int mehtod2(String str) {
        int n = str.length();
        int ans = 0, i = 0, j = 0;
        HashSet set = new HashSet();
        while (i < n && j < n) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(str.charAt(i++));
            }
        }
        return ans;
    }

    //使用HashMap
    public static int mehtod3(String str) {
        int n = str.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(str.charAt(i))) {
                j = Math.max(map.get(str.charAt(i)), j);
            }
            ans = Math.max(ans, i - j + 1);
            map.put(str.charAt(i), i + 1);
        }
        return ans;
    }

    //使用数组
    public static int mehtod4(String str) {
        int n = str.length(), ans = 0;
        int[] index = new int[128];
        //try to extend the range;[i,j];
        for (int j = 0, i = 0; j < n; j++) {
            //取出元素在数组中对应的索引,并取最大值,
            i = Math.max(index[str.charAt(j)], i);
            //求出滑动窗口的最大长度
            ans = Math.max(ans, j - i + 1);
            index[str.charAt(j)] = j + 1;
        }
        return ans;
    }

}
