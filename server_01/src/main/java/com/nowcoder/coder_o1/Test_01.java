package com.nowcoder.coder_o1;

import java.util.HashMap;
import java.util.Map;

public class Test_01 {

    public static void main(String[] args) {

        String str = new String("abc");
        String  str1 = "abc";
        System.out.println(str == str1);

        String str2 = new String("abc");
        System.out.println(str1 == str2);

        String str3 = "ab\0c";
     System.out.println(str3);
//        System.out.println(str1 == str3);
//
//        String str4 = str1.intern();
//        System.out.println(str1 == str4);
//        System.out.println(str == str4);
//
//        String str5 = str.intern();
//        System.out.println(str == str5);
//        System.out.println(str1 == str5);

    }
}
