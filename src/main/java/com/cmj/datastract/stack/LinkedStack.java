package com.cmj.datastract.stack;


/**
 * ================================================
 * Description:  链式栈
 *
 * Created by chmj on 2019/3/29
 *
 * ================================================
 */
public class LinkedStack<T> {

    // 栈顶节点
    private Node<T> topStack;

    /**
     * 入栈
     * @param t
     */
    public void push(T t) {
        Node<T> newNode = new Node<>(t, topStack);
        topStack = newNode;
    }

    /**
     * 出栈
     * @return
     */
    public boolean pop(){
        if(topStack == null) {
            return false;
        } else {
            topStack = topStack.next;
        }

        return true;
    }

    public void printAll() {
        Node p = topStack;
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


        LinkedStack stack = new LinkedStack();
        stack.push("1");
        stack.push("2");
        stack.printAll();
        System.out.println("-----------------------");
        stack.pop();
        stack.printAll();
    }
}
