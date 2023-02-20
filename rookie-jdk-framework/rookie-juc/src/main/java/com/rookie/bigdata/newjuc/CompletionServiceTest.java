package com.rookie.bigdata.newjuc;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Classname CompletionService
 * @Description https://blog.csdn.net/sermonlizhi/article/details/123314335?spm=1001.2014.3001.5502
 * @Author rookie
 * @Date 2023/2/17 10:05
 * @Version 1.0
 */
public class CompletionServiceTest {

    /**
     * 任务会按照执行完成的结果进行阻塞
     * @throws Exception
     */
    @Test
    public void testCompletionService() throws Exception {

        BlockingQueue q = new LinkedBlockingDeque();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 6, 3, TimeUnit.SECONDS, q);
        //CompletionService能够让异步任务的执行结果有序化。先执行完的先进入阻塞队列，利用这个特性，你可以轻松实现后续处理的有序性，避免无谓的等待，同时还可以快速实现诸如Forking Cluster这样的需求。CompletionService能够让异步任务的执行结果有序化。先执行完的先进入阻塞队列，利用这个特性，你可以轻松实现后续处理的有序性，避免无谓的等待，同时还可以快速实现诸如Forking Cluster这样的需求。
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        long starTime = System.currentTimeMillis();
        cs.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                Thread.sleep(2000);
                return 1;
            }
        });

        cs.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                Thread.sleep(1000);
                return 2;
            }
        });

        for (int i = 0; i < 3; i++) {
            Integer integer = cs.take().get();
            System.out.println(integer);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - starTime);
        }

    }

    /**
     * 任务会按照执行的顺序进行阻塞
     *
     * @throws Exception
     */
    @Test
    public void testExecutorService() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long starTime = System.currentTimeMillis();
        Future<Integer> f1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                Thread.sleep(2000);
                return 1;
            }
        });
        Future<Integer> f2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                Thread.sleep(2000);
                return 2;
            }
        });



        Integer integer = f1.get();
        Integer integer1 = f2.get();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - starTime);

    }

}
