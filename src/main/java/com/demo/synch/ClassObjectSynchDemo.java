package com.demo.synch;

import java.util.concurrent.TimeUnit;

public class ClassObjectSynchDemo {


    public void lockClass() throws InterruptedException {
        synchronized (ClassSynchronizedDemo.class) {
            System.out.println("开始线程 " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("结束线程 " + Thread.currentThread().getName());
        }
    }

    /**
     * 对象方法锁
     */
    public synchronized void lockObject() throws InterruptedException {
        System.out.println("开始线程 " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("结束线程 " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ClassObjectSynchDemo demo1 = new ClassObjectSynchDemo();
        ClassObjectSynchDemo demo2 = new ClassObjectSynchDemo();

        Thread thread1 = new Thread(() -> {
            try {
                demo1.lockClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                demo2.lockObject();
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
