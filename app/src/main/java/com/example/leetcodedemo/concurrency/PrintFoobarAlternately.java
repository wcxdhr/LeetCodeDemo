package com.example.leetcodedemo.concurrency;
/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wcxdhr on 2020-04-01.
 */
public class PrintFoobarAlternately {


    class FooBar {
        private int n;
        private int flag;
//        private String lock = new String();

        public FooBar(int n) {
            this.n = n;
            flag = 0;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag != 0)
                        wait();
                    flag = 1;
                    printFoo.run();
                    notify();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag != 1)
                        wait();
                    printBar.run();
                    flag = 0;
                    notify();
                }
            }
        }
    }

    /**
     * 试了下Atomic说超出时间限制
     */
    class FooBar1 {
        private int n;
        private AtomicInteger flag = new AtomicInteger(0);

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag.get() != 0){}
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag.incrementAndGet();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag.get() != 1){}
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag.decrementAndGet();
            }
        }
    }
}
