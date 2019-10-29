package com.cmj.datastract.stack;

/**
 * ================================================
 * Description:  顺序栈
 *
 * Created by chmj on 2019/3/29
 *
 * ================================================
 */
public class ArrayStack {

    private String[] items;
    /**
     * 栈容量
     */
    private int capacity;

    //栈中元素数量
    private int count;

    public ArrayStack(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 入栈
     * @param s
     */
    public boolean push(String s) {
        // 先判断栈内是否还有空余的容量
        if(count == capacity) {
            return false;
        }

        items[count] = s;
        ++count;

        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {
        // count为0 说明栈内没有元素
        if(count == 0) {
            return null;
        }

        String temp = items[count-1];
        --count;

        return temp;
    }
}
