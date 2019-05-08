package com.liujun.datastruct.base.datastruct.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2018/10/11
 */
public class MyLinkedListTest {

  /** 测试添加节点 */
  @Test
  public void testMyLinkedListAdd() {
    MyLinkedList list = new MyLinkedList();

    list.add(10);
    list.add(20);
  }

  /** 测试删除尾节点 */
  @Test
  public void testMylinkedListRemoveLast() {

    MyLinkedList list = new MyLinkedList();

    list.add(10);
    list.add(20);

    Integer value = list.removeLast();
    System.out.println(value);

    value = list.removeLast();
    System.out.println(value);

    value = list.removeLast();
    System.out.println(value);
  }

  /** 测试查找节点所对应的node */
  @Test
  public void testMyLinkedListFindByValue() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);

    MyLinkedList.Node node = list.findByValue(50);

    System.out.println(node);
    Assert.assertNotNull(node);

    MyLinkedList.Node node1 = list.findByValue(90);

    System.out.println(node1);

    Assert.assertNull(node1);
  }

  @Test
  public void testMyLinkedListFindByIndex() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);

    MyLinkedList.Node index0 = list.findByIndex(0);
    System.out.println(index0);

    index0 = list.findByIndex(1);
    System.out.println(index0);

    index0 = list.findByIndex(2);
    System.out.println(index0);

    index0 = list.findByIndex(3);
    System.out.println(index0);
  }

  @Test
  public void testInsertToHead() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);

    list.insertToHead(2);

    System.out.println(list);
  }

  @Test
  public void testInsertToAfterValue() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);

    MyLinkedList.Node node = list.findByIndex(1);

    list.insertToAfter(node, 22);

    System.out.println(list);
  }

  @Test
  public void testInsertToBeforeValue() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);

    MyLinkedList.Node beforeNode = list.findByIndex(1);

    list.insertToBefore(beforeNode, 15);
  }

  @Test
  public void testdeleteByValue() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);

    list.deleteByValue(20);

    list.deleteByValue(40);
  }

  @Test
  public void testdeleteByPrint() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);

    list.printTree(null, 0);

    list.deleteByValue(20);

    list.deleteByValue(40);

    list.printTree(null, 0);
  }

  @Test
  public void testReverse() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);

    MyLinkedList.Node node = list.findByIndex(0);

    MyLinkedList.Node nodOut = MyLinkedList.reverse(node);

    list.printTree(nodOut, 0);
  }

  @Test
  public void testReverseSelf() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    list.add(70);

    list.reverse();

    list.printTree(null, 0);

    list.reverse();

    list.printTree(null, 0);
  }

  @Test
  public void checkCircle() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    list.add(70);
    list.add(80);
    list.add(90);
    list.add(100);
    list.add(101);
    list.add(999);

    list.setCircle(107, 999);

    MyLinkedList.Node finde = list.findByIndex(1);

    boolean circle = list.checkCircle(finde);
    System.out.println(circle);
  }

  @Test
  public void marge() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(90);

    MyLinkedList list2 = new MyLinkedList();
    list2.add(50);
    list2.add(60);
    list2.add(70);
    list2.add(80);
    list2.add(120);

    MyLinkedList.Node firstNode = list.findByIndex(0);
    MyLinkedList.Node twoNode = list2.findByIndex(0);

    MyLinkedList.Node head = list.margeLinked(firstNode, twoNode);

    list.printTree(head, 0);
  }

  @Test
  public void deleteLastKth() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(50);
    list.add(60);
    list.add(80);
    list.add(90);

    MyLinkedList.Node firstNode = list.findByIndex(0);

    MyLinkedList.Node head = list.deleteLastIndex(firstNode, 3);

    // MyLinkedList.Node head = list.deleteLastKth(firstNode,3);

    list.printTree(head, 0);
  }


  @Test
  public void findMidNode() {
    MyLinkedList list = new MyLinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(50);
    list.add(60);
    list.add(80);
    list.add(90);

    MyLinkedList.Node firstNode = list.findByIndex(0);

    MyLinkedList.Node head = list.findMidNode(firstNode);

    // MyLinkedList.Node head = list.deleteLastKth(firstNode,3);

    list.printTree(head, 0);
  }
}
