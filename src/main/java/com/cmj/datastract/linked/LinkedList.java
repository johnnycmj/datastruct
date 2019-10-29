package com.cmj.datastract.linked;

/**
 * @Author :  chenmj
 * @Created :  2019/7/11
 * @Since :  0.1.0
 * @Description 简单的链表实现
 */
public class LinkedList {

    /**
     * 节点信息
     */
    class Node {
        /**
         * 节点值
         */
        Integer value;
        /**
         * 后继指针，指向下一个节点
         */
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

    }

    /**
     * 头结点
     */
    private Node headNode = new Node(null);

    /**
     * 链表大小
     */
    private int size;


    /**
     * 添加节点。
     * 解析：
     *      1、首先构建一个节点信息。
     *      2、循环获取最后一个节点。
     *      3、将新节点添加在最后一个节点的next上
     * @param value
     */
    public void addNode(int value) {
        // 构建节点信息
        Node node = new Node(value);

        // 后继节点
        Node temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
        }

        // 如果 temp.next为null，说明 temp为最后一个节点
        temp.next = node;
    }

    /**
     * 插入头部。
     * 解析：
     *      1、首先构建一个节点信息。
     *      2、如果头结点的后继指针为null，则说明是空链表，则next直接指向新的节点
     *      3、如果后继者不为null，则先将新节点的next指向头结点的next，然后在将头结点的next指向新节点
     *
     * @param value
     */
    public void inserHead(int value) {
        // 构建节点信息
        Node node = new Node(value);

        // 后继节点
        Node temp = headNode;
        if(temp.next == null) {
            // 如果头结点的后继指针为null，说明这个是空链表
            temp.next = headNode;
        } else {
            // 将新节点的后继指针指向原节点的的后继指针
            node.next = temp.next;
            // 将原后继指针指向新的节点
            temp.next = node;
        }
    }

    /**
     * 根据 value查找 节点
     *
     * 解析：
     *      1、循环链表，当节点的value等于要查找的key，则直接返回Node。
     *      2、如果不等，则指向该节点的next
     *      3、遍历停止条件：当node的next为null
     * @param key
     * @return
     */
    public Node findBykey(int value) {

        Node tempNode = headNode.next;
        while (tempNode != null) {
            if(tempNode.value == value) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
            }
        }

        return null;
    }

    /**
     * 根据index查找节点
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        if (index < 0) {
            return null;
        }

        Node tempNode = headNode.next;
        int tempIndex = 0;
        while (tempNode != null && tempIndex != index) {
            tempNode = tempNode.next;
            ++tempIndex;
        }

        return tempNode;
    }

    /**
     * 插入指定节点的后面
     * 解析：
     *      1、现将Node的next保存在tempNode
     *      2、构建新的newNode
     *      3、将原Node的next指向新的newNode，将新的newNode的next指向原node的next
     * @param node
     * @param value
     */
    public void insertAfter(Node node, int value) {
        if(node == null) {
            return;
        }

        // 现将node的next记录下来
        Node tempNode = node.next;

        // 构建新的Node
        Node newNode = new Node(value);

        // 将原node的next指向新的Node，将新的Node的next指向原node的next
        node.next = newNode;
        newNode.next = tempNode;

    }

    /**
     * 插入指定节点的前面
     * @param node
     * @param value
     */
    public void insertBefore(Node node, int value) {
        if(node == null) {
            return;
        }
        // 先找到node的前一个节点
        Node tempNode = headNode;
        while (tempNode.next != node) {
            tempNode = tempNode.next;
        }

        insertAfter(tempNode, value);
    }

    /**
     * 移除首节点
     */
    public void removeHead() {

        // 如果首节点为null，则直接返回
        if(headNode.next == null) {
            return;
        }

        // 获取首节点的next
        Node tempName = headNode.next;
        if(tempName.next != null) {
            // 将首节点的next指向第3个节点
            headNode.next = tempName.next;
        }
    }

    /**
     * 删除尾节点
     * 解析：
     *      1、尾节点和他的上一个节点找出
     *      2、将上一个节点的next指向null
     */
    public void removeLast() {
        // 前一个节点
        Node prevNode = headNode;
        // 尾节点
        Node lastNode = headNode.next;

        // 循环找到尾节点和他的上一个节点
        while (lastNode != null && lastNode.next != null) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        // 将上一个节点的next指向null
        prevNode.next = null;

    }

    /**
     * 删除指定的节点
     * 解析：
     *      1、找出指定节点的上一个节点
     *      2、上一个节点的next指向指定节点的next
     *
     * @param node
     */
    public void removeNode(Node node) {
        if(node == null) {
            return;
        }

        // 找到node的上一个节点
        Node tempNode = headNode;
        while (tempNode.next != node) {
            tempNode = tempNode.next;
        }

        // 将上一个节点的next指向node的next
        tempNode.next = node.next;
    }

    /**
     * 链表反转
     */
    public void reverse() {
        Node prevNode = null;
        Node nextNode = null;
        Node currentNode = headNode.next;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        headNode.next = prevNode;
    }


    /**
     * 打印
     * @param node
     * @param index
     */
    public void printTree() {

        Node tempNode = headNode;
        StringBuilder stringBuilder = new StringBuilder();
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            stringBuilder.append(tempNode.value).append(" -> ");
        }
        System.out.print(stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length()-1).toString());
    }

    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(3);
        linkedList.addNode(7);
        linkedList.addNode(9);

        System.out.print("原链表： ");
        linkedList.printTree();

//        System.out.println(" ");
//        linkedList.reverse();
//        System.out.print("新链表： ");
//        linkedList.printTree();

        System.out.println(" ");
        linkedList.inserHead(4);
        System.out.print("新链表： ");
        linkedList.printTree();
//
//        System.out.println(" ");
//        Node node = linkedList.findBykey(7);
//        System.out.println("Node： " + node.value);
//
//        Node node_index = linkedList.findByIndex(1);
//        System.out.println("Node： " + node_index.value);
//
////        linkedList.insertAfter(node_index, 5);
//        linkedList.insertBefore(node_index, 5);
//        System.out.print("新链表： ");
//        linkedList.printTree();
//
//        System.out.println(" ");
//        linkedList.removeHead();
//        System.out.print("新链表： ");
//        linkedList.printTree();
//
//        System.out.println(" ");
//        linkedList.removeLast();
//        System.out.print("新链表： ");
//        linkedList.printTree();
//
//        System.out.println(" ");
//        Node node1 = linkedList.findByIndex(1);
//        linkedList.removeNode(node1);
//        System.out.print("新链表： ");
//        linkedList.printTree();
    }
}
