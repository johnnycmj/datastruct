package com.cmj.datastract.heap;

/**
 * ================================================
 * Description:  堆
 *
 * Created by chmj on 2019/5/7
 *
 * ================================================
 */
public class Heap {

    private int[] a; // 堆数组，下标从1开始
    private int n; // 堆可以存的最大数据个数
    private int count; // 堆中已存储的个数


    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 堆中插入数据
     * @param data
     */
    public void insert(int data) {
        if(count >= n) {
            // 堆满了
            return;
        }

        ++count; // 个数加1
        a[count] = data; // 给数组赋值
        int i = count;
        // 当不时堆顶，并且当前数据大于父节点数据。由于当树的父节点是i，则它的左子节点为2i，右子节点为2i + 1
        // 自下往上堆化
        while (i/2 >0 && a[i] > a[i/2]) {
            // 交换
            swap(a, i, i/2);
            i = i/2;
        }
    }

    public void removeMax() {
        // 堆中没有元素
        if (count == 0) {
            return;
        }

        // 将最后一个节点放在堆顶
        a[1] = a[count];
        --count;
        heapify(a, count, 1);

    }

    /**
     * 交换位置
     * @param a
     * @param i
     * @param n
     */
    private void swap(int[] a, int i, int n) {
        int tem = a[i];
        a[i] = a[n];
        a[n] = tem;
    }

    /**
     * 堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            // 当父节点大于子节点的数据时
            if(i*2 <= n && a[i] > a[i*2]) {
                maxPos = i*2;
            } else if(i*2+1 <= n && a[maxPos] < a[i*2+1]) {
                maxPos = i*2 +1;
            } else if(maxPos == i){
                break;
            }
            swap(a, i , maxPos);
            i = maxPos;
        }
    }
}
