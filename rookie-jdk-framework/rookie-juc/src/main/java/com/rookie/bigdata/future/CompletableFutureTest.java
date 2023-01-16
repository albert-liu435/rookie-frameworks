package com.rookie.bigdata.future;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Classname CompletableFutureTest
 * @Description https://mp.weixin.qq.com/s/ipQLDlCc6a2BeYeEkwOwMg
 * https://www.cnblogs.com/qdhxhz/p/16671089.html
 * @Author rookie
 * @Date 2023/1/13 16:58
 * @Version 1.0
 */
public class CompletableFutureTest {

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "hello";
        });
        System.out.println(future.get());
        System.out.println("end");
    }

    @Test
    public void testCountDownLatch() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch downLatch = new CountDownLatch(2);
        long startTime = System.currentTimeMillis();
        Future<String> userFuture = executorService.submit(() -> {
            //模拟查询商品耗时500毫秒
            Thread.sleep(500);
            downLatch.countDown();
            return "用户A";
        });

        Future<String> goodsFuture = executorService.submit(() -> {
            //模拟查询商品耗时500毫秒
            Thread.sleep(400);
            downLatch.countDown();
            return "商品A";
        });

        downLatch.await();
        //模拟主程序耗时时间
        Thread.sleep(600);
        System.out.println("获取用户信息:" + userFuture.get());
        System.out.println("获取商品信息:" + goodsFuture.get());
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

    }


    @Test
    public void testCompletableInfo() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        //调用用户服务获取用户基本信息
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() ->
                //模拟查询商品耗时500毫秒
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "用户A";
        });

        //调用商品服务获取商品基本信息
        CompletableFuture<String> goodsFuture = CompletableFuture.supplyAsync(() ->
                //模拟查询商品耗时500毫秒
        {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品A";
        });

        System.out.println("获取用户信息:" + userFuture.get());
        System.out.println("获取商品信息:" + goodsFuture.get());

        //模拟主程序耗时时间
        Thread.sleep(600);
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testCompletableGet() throws InterruptedException, ExecutionException {

        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品A";
        });

        // getNow方法测试
        System.out.println(cp1.getNow("商品B"));

        //join方法测试
        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp2.join());
        System.out.println("-----------------------------------------------------");
        //get方法测试
        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp3.get());
    }

    @Test
    public void testCompletableThenRunAsync() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<Void> cp1 = CompletableFuture.runAsync(() -> {
            try {
                //执行任务A
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        CompletableFuture<Void> cp2 = cp1.thenRun(() -> {
            try {
                //执行任务B
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // get方法测试
        System.out.println(cp2.get());

        //模拟主程序耗时时间
        Thread.sleep(600);
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testCompletableThenAccept() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            return "dev";

        });
        CompletableFuture<Void> cp2 = cp1.thenAccept((a) -> {
            System.out.println("上一个任务的返回结果为: " + a);
        });

        cp2.get();
    }

    @Test
    public void testCompletableThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            return "dev";

        }).thenApply((a) -> {
            if (Objects.equals(a, "dev")) {
                return "dev";
            }
            return "prod";
        });

        System.out.println("当前环境为:" + cp1.get());

        //输出: 当前环境为:dev
    }

    @Test
    public void testCompletableWhenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {

            if (Math.random() < 0.5) {
                throw new RuntimeException("出错了");
            }
            System.out.println("正常结束");
            return 0.11;

        }).whenComplete((aDouble, throwable) -> {
            if (aDouble == null) {
                System.out.println("whenComplete aDouble is null");
            } else {
                System.out.println("whenComplete aDouble is " + aDouble);
            }
            if (throwable == null) {
                System.out.println("whenComplete throwable is null");
            } else {
                System.out.println("whenComplete throwable is " + throwable.getMessage());
            }
        });
        System.out.println("最终返回的结果 = " + future.get());
    }

    @Test
    public void testWhenCompleteExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 0.5) {
                throw new RuntimeException("出错了");
            }
            System.out.println("正常结束");
            return 0.11;

        }).whenComplete((aDouble, throwable) -> {
            if (aDouble == null) {
                System.out.println("whenComplete aDouble is null");
            } else {
                System.out.println("whenComplete aDouble is " + aDouble);
            }
            if (throwable == null) {
                System.out.println("whenComplete throwable is null");
            } else {
                System.out.println("whenComplete throwable is " + throwable.getMessage());
            }
        }).exceptionally((throwable) -> {
            System.out.println("exceptionally中异常：" + throwable.getMessage());
            return 0.0;
        });

        System.out.println("最终返回的结果 = " + future.get());
    }

    @Test
    public void testCompletableThenCombine() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 1;
            System.out.println("异步任务1结束");
            return result;
        }, executorService);

        //开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务2，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 1;
            System.out.println("异步任务2结束");
            return result;
        }, executorService);

        //任务组合
        CompletableFuture<Integer> task3 = task.thenCombineAsync(task2, (f1, f2) -> {
            System.out.println("执行任务3，当前线程是：" + Thread.currentThread().getId());
            System.out.println("任务1返回值：" + f1);
            System.out.println("任务2返回值：" + f2);
            return f1 + f2;
        }, executorService);

        Integer res = task3.get();
        System.out.println("最终结果：" + res);
    }

    @Test
    public void testCompletableEitherAsync() {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1，当前线程是：" + Thread.currentThread().getId());

            int result = 1 + 1;
            System.out.println("异步任务1结束");
            return result;
        }, executorService);

        //开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务2，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 2;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步任务2结束");
            return result;
        }, executorService);

        //任务组合
        task.acceptEitherAsync(task2, (res) -> {
            System.out.println("执行任务3，当前线程是：" + Thread.currentThread().getId());
            System.out.println("上一个任务的结果为：" + res);
        }, executorService);
    }

    @Test
    public void testCompletableAallOf() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 1;
            System.out.println("异步任务1结束");
            return result;
        }, executorService);

        //开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务2，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 2;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步任务2结束");
            return result;
        }, executorService);

        //开启异步任务3
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务3，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 3;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步任务3结束");
            return result;
        }, executorService);

        //任务组合
        CompletableFuture<Void> allOf = CompletableFuture.allOf(task, task2, task3);

        //等待所有任务完成
        allOf.get();
        //获取任务的返回结果
        System.out.println("task结果为：" + task.get());
        System.out.println("task2结果为：" + task2.get());
        System.out.println("task3结果为：" + task3.get());
    }

    @Test
    public void testCompletableAnyOf() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 1;
            return result;
        }, executorService);

        //开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 2;
            return result;
        }, executorService);

        //开启异步任务3
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 3;
            return result;
        }, executorService);

        //任务组合
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(task, task2, task3);
        //只要有一个有任务完成
        Object o = anyOf.get();
        System.out.println("完成的任务的结果：" + o);
    }

    @Test
    public void testWhenCompleteExceptionally1() {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            if (1 == 1) {
                throw new RuntimeException("出错了");
            }
            return 0.11;
        });

        //如果不加 get()方法这一行，看不到异常信息
        //future.get();
    }

}
