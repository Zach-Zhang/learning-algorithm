package com.zach.alogrithm.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 *
 * Example 1:
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 */
public class EmaiAddress {

    public static void main(String[] args) {
        String[] arr = {"test.emailss+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int count = method2(arr);
        System.out.println(count);
    }

    public static int numUniqueEmails(String[] emails) {
        int len = emails.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            String e1 = emails[i];
            for (int j = i+1; j < len; j++) {
                String e2 = emails[j];

                String[] s1 = e1.split("@");
                String[] s2 = e2.split("@");
                if(!Objects.equals(s1[1],s2[1])){
                    count++;
                }else {
                    String str1 = s1[0].replaceAll(".", "");
                    String str2 = s2[0].replaceAll(".", "");
                    int index1 = str1.indexOf("+");
                    int index2 = str2.indexOf("+");
                    if( index1 != -1 && index2 != -1){
                        if(!Objects.equals(str1.substring(index1+1),str1.substring(index2+1)) ){
                            count++;
                        }
                    }else if(index1 != -1 && index2 == -1){
                        if(!Objects.equals(str1.substring(index1+1),str2)){
                            count++;
                        }
                    }else if(index2 != -1 && index1 == -1) {
                        if (!Objects.equals(str2.substring(index2 + 1), str1)) {
                            count++;
                        }
                    }else {
                        if(!Objects.equals(str1,str2)) {
                            count++;
                        }
                    }

                }
            }
        }
        return count;
    }

    public static  int method2 (String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            int i = email.indexOf("@");
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if(local.contains("+")) {
                local = local.substring(0,local.indexOf("+"));
            }

            local = local.replaceAll("\\.","");
            set.add(local+rest);

        }

        return set.size();
    }
}
