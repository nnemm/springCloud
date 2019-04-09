package com.leetCode.algorithm;

import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class SolutionLengthOfLongestSubstring {


    public static void main(String[] args) {
        SolutionLengthOfLongestSubstring ss = new SolutionLengthOfLongestSubstring();
        String s =  " dsa dsadsad dsadsa";
        int i = ss.lengthOfLongestSubstring1(s);
        System.out.println(i);
    }


    public int lengthOfLongestSubstring1 (String s) {

        Set<Character> set = new HashSet<>();
        int ans = 0;
        int n = s.length();
        int i =0 ,j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(i++);
            }
        }

        return ans;
    }

    // 方法一
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // hotPonit <=
            for (int j = i + 1; j <= n; j++ ) {
                if (allUnique(s, i, j)) ans = Math.max(ans, j -i);
            }
        }

        return ans;
    }


    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }

        return true;
    }
}
