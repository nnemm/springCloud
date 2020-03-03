package com.example.javaNewFeatures;

import java.io.OutputStream;

public class Lambda_01 {

    public static void main(String[] args) {

        new Thread() {
            public void run() {
                System.out.println("一个线程！");
            }
        }.start();

        new Thread( () -> System.out.println("两个线程!")).start();
    }

    LambService lambService = new LambService() {
        @Override
        public void show(String s) {
            System.out.println(s);
        }
    };

    LambService lambService1 = s -> System.out.println("lamb" + s);
}
