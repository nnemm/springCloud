package com.leetCode.algorithm;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class SolutionLengthOfLongestSubstring {


    public static void main(String[] args) {
        SolutionLengthOfLongestSubstring ss = new SolutionLengthOfLongestSubstring();
        String s =  " dsa dsadsad dsadsa";
        int i = ss.lengthOfLongestSubstring2(s);
        System.out.println(i);
    }


    //优化二
    public int lengthOfLongestSubstring2 (String s) {

        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j =0; j < n; j++ ) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    // 优化一
    public int lengthOfLongestSubstring1 (String s) {

        Set<Character> set = new HashSet<>();
        int ans = 0;
        int n = s.length();
        int i =0 ,j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                System.out.println("j:" + j);
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
                System.out.println("i:" + i);
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
