package com.liujun.datastruct.base.datastruct.heap.solution.highTimeSchedule;

import com.liujun.datastruct.base.datastruct.heap.solution.highTimeSchedule.pojo.ScheduleBusi;

import java.util.PriorityQueue;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2018/12/02
 */
public class MySchedule {

  public static final MySchedule INSTANCE = new MySchedule();

  /** 使用小顶堆来存储任务队列 */
  private PriorityQueue<ScheduleBusi> queue =
      new PriorityQueue<>(
          8,
          (o1, o2) -> {
            if (o1.getRunTime() > o2.getRunTime()) {
              return 1;
            } else if (o1.getRunTime() < o2.getRunTime()) {
              return -1;
            }
            return 0;
          });

    /**
     * 添加定时任务
     * @param time
     * @param run
     */
  public void delayRun(long time, Runnable run) {
    // 将任务加入队列
    queue.offer(new ScheduleBusi(time, run));

  }

    /**
     * 启动定时器
      */
  public void runSchedu() {
      // 从任务中获取第一时间，然后当前定时器设置在runtime后唤醒进行执行
      ScheduleBusi schedQueue = queue.poll();
      // long runTime = schedQueue.getRunTime()-currTime;
      if(schedQueue != null) {
          System.out.println("取出执行任务" + schedQueue.getRunTime());
          RunSchedule.INSTANCE.runTask(schedQueue.getRunTime(), schedQueue.getRunable());
      }
  }
}
