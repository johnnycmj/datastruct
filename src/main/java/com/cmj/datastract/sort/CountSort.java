package com.cmj.datastract.sort;

/**
 * ================================================
 * Description:  计数排序
 *
 * Created by chmj on 2019/4/10
 *
 * ================================================
 */
public class CountSort {

    public void countSort(int[] a, int n) {

        // 1、先创建一个桶数组，数组的大小为待排数组中的最大值+1.
        int max = a[0];
        for(int i=1;i <n; ++i) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        // 创建大小为max+1的数组
        int[] c = new int[max+1];
        for(int i=0; i< max; ++i) {
            c[i] = 0;
        }

        // 2、遍历待排数组，将值放到C数组中
        for(int i=0; i<n; ++i) {
            // a 中的值就是c中的下角标，如果遇到一次则加1.最终c中的每个角标对应的值就是a中的值出现的次数
            c[a[i]]++;
        }

        // 3、对C中的数组顺序求和，c[k] 里存储的便是小于等于k的个数
        for(int i=1; i<max; i++) {
            c[i] = c[i] + c[i-1];
        }

        // 4、创建一个临时数组，存储排序之后的数据
        int[] r = new int[n];

        // 5、 反向遍历数组a
        for(int i=n-1; i>0; --i) {
            // a中取出的值，便是c的下角标, 然后从c中取出的值-1 ，当角标放大r的位置
            r[c[a[i]]-1] = a[i];
            // 当r中放入一个数据之后，c中的位置值要减1
            c[a[i]]--;
        }

        // 6、将排序我的结果拷贝给a
        for(int i=0; i<n; ++i) {
            a[i] = r[i];
        }
    }
}
