/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/12/21 23:05.
 */

package lock.sync;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/12/21
 */
public class SyncDemo1{
    private static int i = 0;

    public synchronized void inc() {
        i ++;
    }

    public void inc2() {
        synchronized (SyncDemo1.class) {
            i ++;
        }
    }

    public void inc3() {
        Object o = new Object();
        synchronized (o) {
            System.out.println("hello");
        }
    }

    public synchronized static void inc4() {
        i ++;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
//    @Override
//    public void run() {
//        for (int i1 = 0; i1 < 1000; i1++) {
//            inc();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        SyncDemo1 syncDemo1 = new SyncDemo1();
//        Thread thread1 = new Thread(syncDemo1);
//        Thread thread2 = new Thread(syncDemo1);
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//    }
}
