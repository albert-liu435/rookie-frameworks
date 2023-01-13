package com.rookie.bigdata.thread;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AlipayThreadPoolUtil
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/26 17:35
 * @Version 1.0
 */
public class AlipayThreadPoolUtil {

//    private static final Log logger = LogFactory.getLog(AlipayThreadPoolUtil.class);
    private volatile static AlipayThreadPoolUtil threadPool;
    private ThreadPoolExecutor executor;
    private TimeUnit unit = TimeUnit.SECONDS;
    private static int corePoolSize = 1;
    private static int keepAliveTime = 60;
    private static int maximumPoolSize = 1;
    private static int workQueue = 20000;


    public AlipayThreadPoolUtil(int corePoolSize, long keepAliveTime, int maximumPoolSize, LinkedBlockingQueue<Runnable> workQueue) {
        final ThreadFactory threadFactory = new AlipayThreadPoolUtil.DefaultThreadFactory();
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("CS线程池初始化成功");
    }

    //获得单例对象
    public static AlipayThreadPoolUtil init() {
        if (threadPool == null) {
            synchronized (AlipayThreadPoolUtil.class) {
                if (threadPool == null) {
                    LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(workQueue);
                    threadPool = new AlipayThreadPoolUtil(corePoolSize,keepAliveTime,maximumPoolSize,queue);
                }
            }
        }
        return threadPool;
    }
    private static AlipayThreadPoolUtil init(int corePoolSize, long keepAliveTime, int maximumPoolSize, LinkedBlockingQueue<Runnable> workQueue) {
        if (threadPool == null) {
            threadPool = new AlipayThreadPoolUtil(corePoolSize,keepAliveTime,maximumPoolSize,workQueue);
        }
        return threadPool;
    }
    public void awaitTermination() throws InterruptedException {
//        logger.info("Thread pool ,awaitTermination started, please wait till all the jobs complete.");
        long timeout = 10;
        executor.awaitTermination(timeout, unit);
    }
    public void execute(Runnable t) {
        executor.execute(t);
    }
    public void execute(Thread t) {
        executor.execute(t);
    }
    //封装了executor.invokeAll(Collection<? extends Callable<T>> tasks)方法
    public List<Future<String>> execute(List<Callable<String>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }

    //封装了executor.invokeAll(Collection<? extends Callable<T>> tasks)方法
    public List<Future<Integer>> executeInteger(List<Callable<Integer>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }

    public int getQueueSize() {
        return executor.getQueue().size();
    }
    public void shutdown() {
        getExecutor().shutdown();
    }
    private ThreadPoolExecutor getExecutor() {
        return executor;
    }
    public Future<?> submit(Runnable t) {
        return executor.submit(t);
    }
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> Future<T> submit(Callable<T> t) {
        return getExecutor().submit(t);
    }

    /**
     * The default thread factory
     */
    class DefaultThreadFactory implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "CSpool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
