package com.cmj.datastract.queue;


/**
 * ================================================
 * Description:  链式队列
 *
 * Created by chmj on 2019/3/31
 *
 * ================================================
 */
public class LinkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * 入队
     * @param t
     * @return
     */
    public void enqueue(T t) {

        Node<T> newNode = new Node<>(t, null);

        if(tail == null) {
            // 如果尾节点为空,则说明队列里没有数据
            head = newNode;
            tail = newNode;
        } else {
            // 将尾节点的后置指针指向新的节点
            tail.next = newNode;
            // 将尾节点指针指向新的节点
            tail = newNode;
        }
    }

    /**
     * 出队
     */
    public T dequeue(){
        // 如果头结点为空，则队列里为空
        if(head == null) {
            tail = null;
            return null;
        }

        T dequeueItem = head.item;
        head = head.next;

        return dequeueItem;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }



    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T t, Node next) {
            this.item = t;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.printAll();
        System.out.println("-----------------------");
        System.out.println(queue.dequeue() + "");
        System.out.println(queue.dequeue() + "");
        System.out.println(queue.dequeue() + "");
        queue.printAll();
        System.out.println("-----------------------");
        queue.enqueue("1");
        queue.printAll();

    }
}
