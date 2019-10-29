package com.cmj.datastract.sort;

public class SortFirst {

    /**
     * 冒泡排序
     * @param a 数组a
     * @param n 数组大小 n
     */
    public void bubbleSort(int[] a , int n) {
        if(n < 1) {
            return;
        }

        for(int i = 0; i < n; ++i) {
            boolean flag = false;
            for(int j = 0; j < n - 1 - i; ++j) {
                if(a[j] > a[j+1]) {
                    // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if(!flag) {
                break;  // 没数据交换直接退出循环
            }
        }
    }

    /**
     * 插入排序
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        if(n < 1) {
            return;
        }
        // 从第一个开始跟前面的比较
        for(int i = 1; i < n; ++i) {

            // 取出待排的元素
            int value = a[i];
            // j 从i的前一位开始往前遍历
            int j = i-1;

            for(; j >= 0; --j) {
                // 如果前一个大于后面的就移动数据
                if(a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            System.out.println("j = " + j);
            // 插入数据
            a[j+1] = value;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public void selectionSort(int a[], int n) {
        if(n < 1) {
            return;
        }
        for(int i = 0; i < n ; ++i) {
            int tem = a[i];
            int index = i;
            for(int j = i; j < n-1; ++j) {
                if(tem > a[j+1]) {
                    tem = a[j+1];
                    index = j+1;
                }
            }
            a[index] = a[i];
            a[i] = tem;
        }
    }

    public static void main(String[] args) {
        SortFirst sortFirst = new SortFirst();
        int a[] = {4, 5, 6, 1, 3, 2};
//        sortFirst.bubbleSort(a, a.length);
//        sortFirst.insertionSort(a, a.length);
        sortFirst.selectionSort(a, a.length);
    }
}
