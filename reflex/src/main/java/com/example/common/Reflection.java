package com.example.common;

import java.lang.reflect.Field;

public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = ReflectTest.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            System.out.println(field.getName());
        }

        ClassLoader classLoader = clazz.getClassLoader();

        Class<?> name = clazz.forName("com.example.common.ReflectTest");
        Object o = name.newInstance();
        System.out.println(o);


    }





}
