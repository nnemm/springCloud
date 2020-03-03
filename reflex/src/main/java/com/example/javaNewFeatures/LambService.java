package com.example.javaNewFeatures;

/**
 * FunctionalInterface
 * 主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。
 */
@FunctionalInterface
public interface LambService {

    void show(String s);
}
