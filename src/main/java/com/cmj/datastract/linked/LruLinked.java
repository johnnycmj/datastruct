package com.cmj.datastract.linked;

/**
 * 基于链表的LRU缓存算法
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 *    a.如果此时缓存未满，则将此结点直接插入到链表的头部；
 *    b.如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 */
public class LruLinked<T> {

    /**
     * 默认容量
     */
    private static final int CAPACITY = 10;

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

    /**
     * 容量
     */
    private int capacity;


    public LruLinked(){
        this.capacity = CAPACITY;
    }

    public LruLinked(int capacity){
        this.capacity =capacity;
    }


    public void add(T t) {
        // 查找这个节点
        Node node = findPreNode(t);
        // 如果链表里面没有这个节点数据
        if(node == null) {
            if(size < capacity - 1) {
                // 说明还有容量,则直接添加在头部
                addFirst(t);
            } else {
                // 说明容量已满，先删除末尾的，在添加头部
                removeLast();
                addFirst(t);
            }
        } else {
           // 将其从原来的位置删除，然后再插入到链表的头部。
            Node cut = node.next;
            Node next = node.next.next;
            node.next = next;

            cut.next = null;
            cut.item = null;

            addFirst(t);
        }
    }

    /**
     * 获取是否在链表里上一个节点
     * @param t
     * @return
     */
    private Node<T> findPreNode(T t) {
        Node<T> current = first;
        if(current == null) {
            return null;
        }
        // 当有下一个的时候循环往下执行
        while (current.next != null) {
            T ele = current.next.item;
            if(ele.equals(t)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * 删除尾节点
     */
    private void removeLast() {
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
     * 插入头部
     * @param t
     */
    private void addFirst(T t) {
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

    private void printAll() {
        Node node = first;
        while (node != null) {
            System.out.print(node.item + ",");
            node = node.next;
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
        LruLinked lruLinked = new LruLinked();
        lruLinked.add("1");
        lruLinked.add("2");
        lruLinked.add("3");
        lruLinked.add("4");
        lruLinked.add("5");
        lruLinked.add("6");
        lruLinked.add("7");
        lruLinked.add("8");
        lruLinked.add("9");
        lruLinked.add("10");
        lruLinked.add("11");
        lruLinked.add("3");

        lruLinked.printAll();

    }
}
