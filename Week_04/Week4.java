package lsp.java0.week4;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Week4 {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 异步执行 下面方法
        Future<Integer> future1 = futureExecutors(executor);
        FutureTask<Integer> future2 = futureTask();
        FutureTask<Integer> future3 = futureTaskExecutor(executor);
        CompletableFuture<Integer> future4 = completableFuture();
        CompletableFuture<Integer> future5 = completableFutureExecutor(executor);
        CompletableFuture<Integer> future6 = completableFutureThread();
        CompletableFuture<Integer> future7 = completableFutureSupplier(executor);
        System.out.println("执行前面步骤使用时间："+ (System.currentTimeMillis()-start) + " ms");
        executor.shutdown();
        // 确保  拿到result 并输出
        System.out.println("1：" + future1.get());
        System.out.println("2：" + future2.get());
        System.out.println("3：" + future3.get());
        System.out.println("4：" + future4.get());
        System.out.println("5：" + future5.get());
        System.out.println("6：" + future6.get());
        System.out.println("7：" + future7.get());
        System.out.println("完成使用时间："+ (System.currentTimeMillis()-start) + " ms");


        // 然后退出main线程
    }

    /**
     * 第一种：通过线程池，future
     * @return
     */
    public static Future futureExecutors( ExecutorService executor) {
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        return result;
    }

    /**
     * 第二种：单线程方式执行FutureTask
     * @return
     */
    public static FutureTask futureTask() {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        new Thread(task).start();
        return task;
    }

    /**
     * 第三种：线程池方式执行futureTask
     * @return
     */
    public static FutureTask futureTaskExecutor(ExecutorService executor) {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        executor.submit(task);
        return task;
    }

    /**
     * 第四种：lambda执行CompletableFuture
     * @return
     */
    public static CompletableFuture completableFuture() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sum());
        return completableFuture;
    }
    /**
     * 第五种：lambda 线程池方式执行CompletableFuture
     * @return
     */
    public static CompletableFuture completableFutureExecutor(ExecutorService executor) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sum(), executor);
        return completableFuture;
    }
    /**
     * 第六种：单线程执行CompletableFuture
     * @return
     */
    public static CompletableFuture completableFutureThread() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            int result = sum();
            completableFuture.complete(result);
        }).start();

        return completableFuture;
    }
    /**
     * 第七种：CompletableFutureSupplier
     * @return
     */
    public static CompletableFuture completableFutureSupplier(ExecutorService executor) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return sum();
            }
        }, executor);
        return completableFuture;
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
