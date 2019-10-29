package com.cmj.datastract.array;

public class CustomArray<T> {

    /**
     * 数组.
     */
    private Object[] data;

    /**
     * 默认大小.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组大小.
     */
    private int size;

    /**
     * 带capacity 的构造函数.
     * @param capacity
     */
    public CustomArray(int capacity) {
        if(capacity > 0) {
            data = new Object[capacity];
            size = 0;
        } else if(capacity == 0){
            data = new Object[DEFAULT_CAPACITY];
            size = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * 默认构造函数.
     */
    public CustomArray() {
        this(DEFAULT_CAPACITY);
    }

    T elementData(int index) {
        return (T) data[index];
    }

    /**
     * 获取大小.
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空.
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取T.
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    /**
     * 设值.
     * @param index
     * @param t
     * @return
     */
    public T set(int index, T t) {
        rangeCheck(index);
        T oldData = elementData(index);
        data[index] = t;

        return oldData;
    }


    /**
     * 添加.
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        rangeCheck(index);
        resizeCapacity(size + 1);
        // 将从index开始的数据往后移一位,即从elementData数组中从index开始，复制元素到elementData中的 index+1, r然后移动的个数是 size - index
        // 这里的时间复杂度为O(n)
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = t;
        size++;

    }

    /**
     * 添加在开头.
     * @param t
     */
    public void addFirst(T t) {
        add(0, t);
    }

    /**
     * 添加在末尾.
     * @param t
     */
    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 删除.
     * @param index
     * @return
     */
    public T remove(int index) {
        rangeCheck(index);
        T oldData = elementData(index);
        // 需要移动的位数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index+1, data, index,
                    numMoved);
        // 最后一个置为null，等待 gc回收
        data[--size] = null; // clear to let GC do its work

        // 返回删除的元素
        return oldData;
    }


    /**
     * 判断是否扩容
     * @param minCapacity
     */
    private void resizeCapacity(int minCapacity) {
        if(minCapacity > DEFAULT_CAPACITY) {
            ensureExplicitCapacity(data.length * 2);
        }
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        if(minCapacity > data.length) {
            // 先创建一个新的数组
            Object[] newData = new Object[minCapacity];
            // 复制原来的数组
            System.arraycopy(data,0, newData, 0, size);

            data = newData;
        }
    }

    /**
     * 检测.
     * @param index
     */
    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index is IndexOutOf : index = " + index);
        }
    }



}
