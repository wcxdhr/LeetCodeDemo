package com.example.leetcodedemo.interview.tencent;
/**
 * 优先级队列的实现
 * 现实生活中如去医院排队，有人当天取号，有人提前预约，也有vip号，
 * 会出现当天去的从前到后，提前预约可以插队，vip的可以最高优先级，
 * 所以我们要实现以下数据结构
 * 例如，任大，杨二，张三 1，李四， 王五 1，马六 2
 * 最后的输出是：马六，张三，王五，任大，杨二，李四
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by wcxdhr on 2020-04-09.
 */
public class TencentMusicTwo {
    public static void main(String[] args){

    }


    public class PriorityQueueImpl{

        public class Person{
            String name;
            int priority;
        }

        public class Node{
            Person person;
            Node next;

        }

        private Node head;

        public PriorityQueueImpl(){
            head = new Node();
        }

        public void add(String str) {
            String[] strs = str.split(" ");
            Person person = new Person();
            person.name = strs[0];
            person.priority = strs.length == 1 ? -1 : Integer.valueOf(strs[1]);
            Node cur = head;
            while (cur.next != null) {
                if (person.priority > cur.next.person.priority)
                    break;
                else cur = cur.next;
            }
            Node node = new Node();
            node.person = person;
            node.next = cur.next;
            cur.next = node;
        }

        public void print() {
            Node cur = head.next;
            while (cur != null) {
                System.out.println(cur.person.name);
                cur = cur.next;
            }
        }

    }





//    public static String PriorityQueueImpl(String[] strs) {
//        int len = strs.length;
//        Person[] people = new Person[len];
//        for (int i = 0; i < len; i++) {
//            String[] tmpStrs = strs[i].split(" ");
//            people[i].name = tmpStrs[0];
//            people[i].priority = tmpStrs.length == 1 ? 0 : Integer.valueOf(tmpStrs[1]);
//        }
//        Arrays.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.priority - o1.priority;
//            }
//        });
//    }
//



}
