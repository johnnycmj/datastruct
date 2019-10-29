package com.cmj.datastract.sort;

/**
 * ================================================
 * Description:  快排
 *
 * Created by chmj on 2019/4/9
 *
 * ================================================
 */
public class QuickSort {

    public void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    private void quickSortInternally(int[] a, int p, int r) {
        if(p >= r) {
            return;
        }

        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private int partition(int[] a, int p, int r) {
        // pivot 取a的最后一个数
        int pivot = a[r];
        // p 是开始的脚标, 通过游标i将数组a分为a[p,i-1](这个是小于pivot的值)， a[i,r-1](这个是未处理的区间)
        // 每次都去从未处理区间拿出一个元素a[j] 与 pivot比较，如果是小于pivot，则将其加入到已处理区间
        int i = p;
        // 遍历数组a
        for(int j=p; j<r; ++j) {
            if(a[j] < pivot) {
                if(i == j) {
                    ++i;
                } else {
                    // 进行交换
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        // 将最后一个pivot的值交换到i的位置，这样 a[p,i-1]都是小于pivot，a[i] 是pivot， a[i+1, r-1]是大于pivot。
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }
}
