package com.demo.synch;

public class ClassByteSynchronized {

    public int i = 0;

    public synchronized void add() {
        i++;
    }

    public void decrement() {
        synchronized (this) {
            i--;
        }
    }

}
