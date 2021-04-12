package com.demo.synch;

import java.util.concurrent.TimeUnit;

/**
 * @author yangyong
 */
public class ObjectSynchronizedDemo {

    /**
     * 对象方法锁
     */
    public synchronized void methodSyn() throws InterruptedException {
        System.out.println("开始线程 " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("结束线程 " + Thread.currentThread().getName());
    }

    /**
     * 对象的方法块锁
     */
    public void codeBlockMethod() throws InterruptedException {
        synchronized (this) {
            System.out.println("开始线程 " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("结束线程 " + Thread.currentThread().getName());
        }
    }

    /**
     * synchronized 锁其他对象
     *
     * @param otherObject 锁的对象
     */
    public void method(OtherObject otherObject) throws InterruptedException {
        synchronized (otherObject) {
            System.out.println("开始线程 " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("结束线程 " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ObjectSynchronizedDemo demo = new ObjectSynchronizedDemo();
        OtherObject otherObject = new OtherObject();

        Thread thread1 = new Thread(() -> {
            try {
                demo.methodSyn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                demo.codeBlockMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                demo.method(otherObject);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread1.start();
        thread2.start();
//        thread3.start();
    }
}
