package com.zach.alogrithm.easy;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
 * the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was
 * your friends name, with some characters (possibly none) being long pressed.
 *Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 *
 * Note:
 *
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 *
 */
public class LongPressedName {

    public static void main(String[] args) {

        System.out.println( solution("saeed","ssaaedd"));
       //System.out.println(solution("kikcxmvzi","kiikcxxmmvvzz"));
        //System.out.println( solution("alex","aaleex"));
    }

    public static boolean solution(String name,String typed)  {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }
    public static Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i-anchor+1);
                anchor = i+1;
            }
        }

        return new Group(key.toString(), count);
    }


    static class Group {
        String key;
        List<Integer> count;
        Group(String k, List<Integer> c) {
            key = k;
            count = c;
        }
    }
}
