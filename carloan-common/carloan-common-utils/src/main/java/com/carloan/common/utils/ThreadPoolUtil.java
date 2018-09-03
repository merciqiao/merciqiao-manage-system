package com.carloan.common.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyl on 2018/8/8
 */
public class ThreadPoolUtil {
    private static class AsynJobThreadPoolHolder {
        private static final ThreadPoolUtil instance = new ThreadPoolUtil();
    }

    public static ThreadPoolUtil getInstance() {
        return AsynJobThreadPoolHolder.instance;
    }

    /**
     * 功能:得到线程池实例
     *
     * @param corePoolSize    线程池维护线程的最少数量
     * @param maximumPoolSize 线程池维护线程的最大数量
     * @param keepAliveTime   线程池维护线程所允许的空闲时间
     * @param unit            线程池维护线程所允许的空闲时间的单位
     * @param workQueue       线程池所使用的缓冲队列
     * @return
     */
    public ThreadPoolExecutor getThreadPool(int corePoolSize,
                                            int maximumPoolSize,
                                            long keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static void main(String[] args) {
        System.out.println(100/5);
    }
}
