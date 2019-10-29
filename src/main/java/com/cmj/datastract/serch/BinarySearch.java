package com.cmj.datastract.serch;

/**
 * ================================================
 * Description:  二分查询
 *
 * Created by chmj on 2019/4/12
 *
 * ================================================
 */
public class BinarySearch {

    /**
     * 一般写法
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int bintrySearch(int[] a, int n, int t) {

        // 最低的角标
        int low = 0;
        // 最高
        int high = n-1;

        while (low <= high) {
            int mid = low + ((high - low) >> 2 );
            if(a[mid] == t) {
                return mid;
            } else if(a[mid] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] a, int n, int t) {

        return search1(a, 0, n-1, t);
    }

    private int search1(int[] a, int low, int high, int t) {

        if(low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 2 );
        if(a[mid] == t) {
            return mid;
        } else if(a[mid] > t) {
            return search1(a, low, mid-1, t);
        } else {
            return search1(a, mid+1, high, t);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int bintryFirst(int[] a, int n, int t) {
        int low = 0;
        int high = n-1;
        while (low >= high) {
            int mid = low + (high-low)>>1;
            if(a[mid] > t) {
                high = mid - 1;
            } else if(a[mid] < t){
                low = mid + 1;
            } else {
                if(mid == 0 || (a[mid-1] != t) ) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


    /**
     * 查找最后一个元素等于给定值的元素
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int bintryLast(int[] a, int n, int t) {
        int low = 0;
        int high = n-1;
        while (low >= high) {
            int mid = low + (high-low)>>1;
            if(a[mid] > t) {
                high = mid - 1;
            } else if(a[mid] < t){
                low = mid + 1;
            } else {
                if(mid == n-1 || (a[mid+1] != t) ) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
    /**
     * 获取第一个值大于等于给定值的元素
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int bintryFirstEqu(int[] a, int n, int t) {
        int low = 0;
        int high = n-1;
        while (low >= high) {
            int mid = low + (high-low)>>1;
            if(a[mid] >= t) {
                if(mid == 0 || (a[mid-1] < t) ) {
                    return mid;
                }
                high = mid - 1;
            } else if(a[mid] < t){
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值小于等于给定值的元素
     * @param a
     * @param n
     * @param t
     * @return
     */
    public int bintryLastEqu(int[] a, int n, int t) {
        int low = 0;
        int high = n-1;
        while (low >= high) {
            int mid = low + (high-low)>>1;
            if(a[mid] > t) {
                high = mid - 1;
            } else if(a[mid] <= t){
                if(mid == n-1 || (a[mid+1] > t) ) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String args[]) {
        int a[] = {1,3,6,8,11,13,15,18,19,21,22,24,25,27,29};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("n= 18 的 index：" + binarySearch.bintrySearch(a, a.length, 18));
        System.out.println("n= 18 的 index：" + binarySearch.search(a, a.length, 18));
    }

}
