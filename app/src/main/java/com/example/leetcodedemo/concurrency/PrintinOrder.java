package com.example.leetcodedemo.concurrency;
/**
 * 1114. 按序打印
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *
 *
 * 注意:
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 *
 * 你看到的输入格式主要是为了确保测试的全面性。
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wcxdhr on 2020-03-31.
 */
public class PrintinOrder {

    /**
     * 官方题解：atomic保证原子性
     */
    class Foo {

        private AtomicInteger flag = new AtomicInteger(0);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();
            flag.incrementAndGet();

        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (flag.get() != 1){}
            printSecond.run();
            flag.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (flag.get() != 2){}
            printThird.run();
        }
    }


    /**
     * 我的解法：synchronized加锁，官方题解直接用atomic包
     */
    class Foo1 {

        private volatile int flag;

        private Object lock = new Object();

        public Foo1() {
            flag = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (lock) {
                while (flag != 1)
                    lock.wait();
                printFirst.run();
                flag = 2;
                lock.notifyAll();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.

        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (flag != 2)
                    lock.wait();
                printSecond.run();
                flag = 3;
                lock.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (flag != 3)
                    lock.wait();
                printThird.run();
                flag = 0;
                lock.notifyAll();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
        }
    }
}
