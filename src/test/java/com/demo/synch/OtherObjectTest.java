package com.demo.synch;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class OtherObjectTest {

    @Test
    public void test_object_hashcode() {
        Object o = new Object();
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


    @Test
    public void test_object_layout() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5L);
        Object o = new Object();
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }

    @Test
    public void test_syn_lock() throws InterruptedException {
        Object o = new Object();
        for (int i = 0; i < 5; i++) {
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }
    }

    @Test
    public void test_syn_heavy_lock() throws InterruptedException {
        Object o = new Object();
        // Simulate multithreading competition
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronized (o) {
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(5L);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        TimeUnit.SECONDS.sleep(100L);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
