/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/12/7 13:18.
 */

package lock.sync;

import org.apache.lucene.util.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/12/7
 */
public class SyncTest {

    static int count = 0;

    public synchronized void inc() {
        count++;
    }

    public static synchronized void inc2() {
        count++;
    }

    public static void main(String[] args) {

//        System.out.println(System.getProperties());
//        System.out.println("=================");
//        A[] a = new A[2];
//        System.out.println(Integer.toHexString(a.hashCode()));
//        System.out.println("=======================");
//        String s = ClassLayout.parseInstance(a).toPrintable();
//        System.out.println(s);
//        System.out.println("+++++++++++++");
        B b = new B();
        A a = new A();
        Object o = new Object();
        System.out.println("hash : " + Integer.toHexString(b.hashCode()));
        String s1 = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s1);
//        C c = new C();
//        A a = new A();
//        B b = new B();
//        String s1 = ClassLayout.parseInstance(c).toPrintable();
//        System.out.println(s1);
//        System.out.println("===================");
//        System.out.println(RamUsageEstimator.sizeOf(c));
        SyncDemo1 syncDemo1 = new SyncDemo1();
        syncDemo1.inc();



        System.out.println(RamUsageEstimator.sizeOf(o));
    }

    static class A {
        int a1;
        int a2;

        boolean flag;

        B b = new B();

        public A() {
        }
    }

    static class B {
        int status;
        int number;

        public B() {
        }
    }

    static class C {
        int a = 10;
        B b = new B();
        D d;
    }

    static class D{
        int d1;
    }
}
