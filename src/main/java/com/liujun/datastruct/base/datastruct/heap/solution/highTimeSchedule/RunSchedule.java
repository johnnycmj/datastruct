package com.liujun.datastruct.base.datastruct.heap.solution.highTimeSchedule;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2018/12/02
 */
public class RunSchedule {

  public static final RunSchedule INSTANCE = new RunSchedule();

  public final long getCurrTime() {
    return System.currentTimeMillis();
  }

  public void runTask(long runtime, Runnable task) {

    long currTime;

    while (true) {
      currTime = this.getCurrTime();
      long needTime = runtime - currTime;

      if (needTime > 0) {
        try {
          long startTime = System.currentTimeMillis();
          System.out.println("开始" + startTime);
          Thread.sleep(needTime);
          task.run();
          long endTime = System.currentTimeMillis();
          System.out.println("结束" + (endTime - startTime));
          // 继续执行下一个
          MySchedule.INSTANCE.runSchedu();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        break;
      }
    }

  }
}
