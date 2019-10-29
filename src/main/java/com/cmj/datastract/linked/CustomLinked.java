package com.cmj.datastract.linked;

/**
 * 单链表结构
 * 增删查
 */
public class CustomLinked<T> {

    /**
     * 头结点.
     */
    private Node<T> first;
    /**
     * 尾节点.
     */
    private Node<T> last;

    /**
     * 数量.
     */
    private int size;

    public CustomLinked(){

    }

    /**
     * 插入头部
     * @param t
     */
    public void addFirst(T t) {
        // 1、将first的值保存
        Node<T> next = first;
        // 2、构建新的节点,值是要添加的t， 后置指针是next
        Node<T> newNode = new Node<T>(t, next);
        // 将 first指针指向 新建的节点
        first = newNode;
        if(next == null) {
            // 说明链表里没有数据,要添加的是第一个
            last = newNode;
        }
        size++;

    }

    /**
     * 插入尾部
     * @param t
     */
    public void addLast(T t) {
        // 1、将last的只保存
        Node<T> pre = last;
        // 2、构建新的节点,值是要添加的t，后置指针是null
        Node<T> newNode = new Node<>(t, null);
        last = newNode;
        if(pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }

        size++;
    }

    /**
     * 插入某个位置
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        checkIndex(index);
        if(index == 0) {
            addFirst(t);
        } else if(index == size-1) {
            addLast(t);
        } else {
            // 获取index的节点
            Node<T> pre = node(index-1);
            Node<T> next = node(index);
            Node<T> newNode = new Node<T>(t, next);

            pre.next = newNode;
            size++;
        }
    }

    /**
     * 删除头结点
     */
    public void removeFirst() {
        Node<T> pre = first;
        if(pre == null) {
            //说明链表里面已经没有数据
            last = null;
        } else {
            first = pre.next;
            pre.next = null;
            pre.item = null;
            size--;
        }
    }

    /**
     * 删除尾节点
     */
    public void removeLast() {
        Node<T> next = last;
        if(next == null) {
            // 说明链表里没有数据
            first = null;
        } else {
            // 获取倒数第二个
            Node<T> pre = node(size-1);
            if(pre == null) {
                // 如果倒数第二个为空，则链表里只有一个数据
                first = null;
                last = null;
                next.next = null;
                next.item = null;
            } else {
                pre.next = null;
                last = pre;
            }
            size--;
        }
    }

    /**
     * 删除某个节点
     * @param index
     */
    public void remove(int index) {
        if(index == 0) {
            removeFirst();
        } else if(index == size -1) {
            removeLast();
        } else {
            Node<T> current = node(index);
            Node<T> pre = node(index-1);
            Node<T> next = node(index+1);

            pre.next = next;
            current.next = null;
            current.item = null;
            size--;
        }

    }

    /**
     * 获取节点值
     * @param index
     * @return
     */
    public T get(int index) {
        return node(index).item;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 获取某个节点
     * @param index
     * @return
     */
    private Node<T> node(int index) {

        // 遍历到 index的前一个停止，前一个节点的next就是 index的值
        Node<T> node = first;
        for(int i=0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * 判断index
     * @param index
     */
    private void checkIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound ， index = " + index);
        }
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
        CustomLinked linked = new CustomLinked();
        linked.addFirst("1");
        linked.addLast("2");
        linked.addLast("3");
        linked.addLast("4");

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0 ; i < linked.size(); i++) {
            stringBuilder.append(linked.get(i) + "-> ");
        }
        stringBuilder.append("null");

        System.out.println(stringBuilder.toString());

        linked.remove(2);
        linked.removeLast();
        linked.removeFirst();
        linked.removeFirst();

        StringBuilder string2 = new StringBuilder();
        for(int i=0 ; i < linked.size(); i++) {
            string2.append(linked.get(i) + "-> ");
        }
        string2.append("null");

        System.out.println(string2.toString());
    }

}
