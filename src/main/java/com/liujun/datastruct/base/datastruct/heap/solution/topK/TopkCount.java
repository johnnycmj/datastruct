package com.liujun.datastruct.base.datastruct.heap.solution.topK;

import java.util.PriorityQueue;

/**
 * 进行求topK的问题
 *
 * @author liujun
 * @version 0.0.1
 * @date 2018/12/02
 */
public class TopkCount {

  /**
   * 求数据中前K大数据
   *
   * @param data
   * @param k
   * @return
   */
  public int[] topk(int[] data, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k);

    // 遍历data数据
    for (int i = 0; i < data.length; i++) {
      // 当堆中个数小于k时，直接加到堆中
      if (queue.size() < k) {
        queue.offer(data[i]);
      } else {
        // 从堆中取出
        int value = queue.peek();
        // 如果发现数据比堆顶元素大，则加入到小顶堆中
        if (data[i] > value) {
          queue.poll();
          queue.offer(data[i]);
        }
      }
    }

    int[] result = new int[k];
    int index = 0;
    // 遍历完成后，小顶堆的数据就为需要求得的topk的数据
    while (!queue.isEmpty()) {
      result[index++] = queue.poll();
    }

    return result;
  }
}
