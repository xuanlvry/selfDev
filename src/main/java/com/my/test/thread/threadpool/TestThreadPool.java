package com.my.test.thread.threadpool;

/**
 * Created by Chengfei.Sun on 17/03/03.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        // 创建3个线程的线程池
        MyDefineThreadPool t = MyDefineThreadPool.getThreadPool(3);
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        System.out.println(t);
        t.destroy();// 所有线程都执行完成才destory
        System.out.println(t);
    }

    // 任务类
    static class Task implements Runnable {
        private static volatile int i = 1;

        public void run() {// 执行任务
            System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
