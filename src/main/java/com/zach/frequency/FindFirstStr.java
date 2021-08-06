package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author Zach
 * @Date 2021/7/23 7:30
 * Version :1.0
 */
public class FindFirstStr {
    public static void main(String[] args) {
        int index = findFirstStr("abbaccf");
        System.out.println(index);
    }

    public static int findFirstStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return -1;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.toCharArray().length; i++) {
            char cha = str.charAt(i);
            if (map.get(cha) != null) {
                Integer value = map.get(str.charAt(i));
                map.put(cha, value + 1);
            } else {
                map.put(cha, 1);
            }
        }
        Character target = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                target = entry.getKey();
                break;
            }
        }
        return target == null ? -1 : str.indexOf(target);
    }
}
