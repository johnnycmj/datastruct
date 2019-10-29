package com.cmj.datastract.linked;

/**
 * @Author :  chenmj
 * @Created :  2019/7/12
 * @Since :  0.1.0
 * @Description 循环链表
 */
public class LoopLinkedList {

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
     * 尾节点，指向头结点
     */
    private Node lastNode = headNode;


    /**
     * 添加链表
     * @param value
     */
    public void addNode(int value) {
        Node node = new Node(value);

        // 尾节点的next指向新的节点
        lastNode.next = node;

        // 将lastNode尾节点定位到新的节点
        lastNode = node;

        // 将尾节点的next重新指向头结点
        lastNode.next = headNode;
    }

    /**
     * 根据Value查找值对应的Node
     *  解析：
     *      1、b遍历链表，当节点的value等于要查找的key，则直接返回Node。
     *      2、如果不等，则指向该节点的next
     *      3、遍历停止条件：当next指向是头结点时停止
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node tempNode = headNode.next;

        while (tempNode != headNode) {
            if(tempNode.value != null && tempNode.value == value) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }

        return null;
    }

    /**
     * 根据索引查找节点
     * 解析：
     *      1、b遍历链表，tempIndex等于要查找的index，则直接返回Node。
     *      2、如果不等，则指向该节点的next
     *      3、遍历停止条件：当next指向是头结点时停止
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        if(index < 0) {
            return null;
        }

        Node tempNode = headNode.next;
        int tempIndex = 0;
        while (tempNode != headNode) {
            if(tempIndex == index) {
                return tempNode;
            }
            tempNode = tempNode.next;
            ++tempIndex;
        }

        return null;
    }

    /**
     * 插入头部。
     * 解析：
     *      1、首先构建一个节点信息。
     *      2、如果头结点的后继指针为null，则说明是空链表，则添加一个节点
     *      3、如果后继者不为null，则先将新节点的next指向头结点的next，然后在将头结点的next指向新节点
     * @param value
     */
    public void inserHead(int value) {
        if(headNode.next == null) {
            addNode(value);
        } else {
            Node node = new Node(value);
            node.next = headNode.next;
            headNode.next = node;
        }
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
    public void insertAfter(Node node,int value) {
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
        while (lastNode.next != headNode) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        // 将上一个节点的next指向null
        lastNode = prevNode;
        prevNode.next = headNode;

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
     * 打印
     */
    public void printTree() {

        Node tempNode = headNode.next;
        StringBuilder stringBuilder = new StringBuilder();
        while (tempNode.value != null) {
            stringBuilder.append(tempNode.value).append(" -> ");
            tempNode = tempNode.next;
        }
        System.out.print(stringBuilder.delete(stringBuilder.length()-3,stringBuilder.length()-1).toString());
    }

    public static void main(String args[]) {
        LoopLinkedList linkedList = new LoopLinkedList();
        linkedList.addNode(2);
        linkedList.addNode(4);
        linkedList.addNode(5);

        System.out.print("原链表： ");
        linkedList.printTree();

        System.out.println("");
        Node node = linkedList.findByValue(5);
        System.out.print("node： " + node.value);

        System.out.println("");
        Node node_index = linkedList.findByIndex(1);
        System.out.print("node_index： " + node_index.value);

        System.out.println("");
        linkedList.inserHead(6);
        System.out.print("新链表： ");
        linkedList.printTree();

        System.out.println("");
        linkedList.insertAfter(linkedList.findByIndex(2), 8);
        System.out.print("新链表： ");
        linkedList.printTree();

        System.out.println("");
        linkedList.insertBefore(linkedList.findByIndex(2), 7);
        System.out.print("新链表： ");
        linkedList.printTree();

        System.out.println("");
        linkedList.removeHead();
        System.out.print("新链表： ");
        linkedList.printTree();

        System.out.println("");
        linkedList.removeLast();
        System.out.print("新链表： ");
        linkedList.printTree();

        System.out.println("");
        linkedList.removeNode(linkedList.findByIndex(1));
        System.out.print("新链表： ");
        linkedList.printTree();

    }


}
