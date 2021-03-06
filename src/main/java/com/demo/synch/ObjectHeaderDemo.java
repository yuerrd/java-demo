package com.demo.synch;

import org.openjdk.jol.info.ClassLayout;


/**
 * @author yangyong
 */
public class ObjectHeaderDemo {

    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
