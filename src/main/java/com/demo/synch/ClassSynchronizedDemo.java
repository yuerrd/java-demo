package com.demo.synch;

import java.util.concurrent.TimeUnit;

public class ClassSynchronizedDemo {

    public void codeBlockMethod() throws InterruptedException {
        synchronized (ClassSynchronizedDemo.class) {
            System.out.println("开始线程 " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("结束线程 " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ClassSynchronizedDemo demo1 = new ClassSynchronizedDemo();
        ClassSynchronizedDemo demo2 = new ClassSynchronizedDemo();


        Thread thread1 = new Thread(() -> {
            try {
                demo1.codeBlockMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                demo2.codeBlockMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();

    }
}
