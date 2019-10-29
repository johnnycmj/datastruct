package com.cmj.datastract.sort;

/**
 * ================================================
 * Description:  归并排序
 *
 * Created by chmj on 2019/4/9
 *
 * ================================================
 */
public class MergeSort {

    /**
     * 递推公式： merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     * 终止条件： p >= r 不用再继续分解
     */


    public void mergeSort(int[] a, int n) {
        mergeSortC(a, 0, n-1);
    }

    private void mergeSortC(int[] a, int p, int r) {
        // 终止条件
        if(p >= r) {
            return;
        }

        // 取 p 到 r的中间位置q
        int q = p + (r - p)/ 2;

        // 分治递归
        mergeSortC(a, p, q);
        mergeSortC(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private void merge(int a[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;

        // 申请一个大小跟a[p...r]一样的临时数组
        int[] temp = new int[r-p+1];
        while (i <= q && j <= r ) {
            if(a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        // 如果 j <= r 则 后半部分里面是有剩余的
        if(j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = temp[i];
        }
    }

    public static void main(String args[]) {
        MergeSort mergeSort = new MergeSort();
        int a[] = {4, 1, 3, 6, 5, 2};
        mergeSort.mergeSort(a, a.length);

        for(int i=0;i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
