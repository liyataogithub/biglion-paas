package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 场景：模拟10人赛跑。10人跑完后才喊"Game Over."
 *
 * 介绍
 * CountDownLatch是一个同步辅助类，它允许一个或多个线程一直等待直到其他线程执行完毕才开始执行。
 *
 * 用给定的计数初始化CountDownLatch，其含义是要被等待执行完的线程个数。
 *
 * 每次调用CountDown()，计数减1
 *
 * 主程序执行到await()函数会阻塞等待线程的执行，直到计数为0
 *
 * 回到顶部
 * 实现原理
 * 计数器通过使用锁（共享锁、排它锁）实现
 *
 *
 * 分析：代码中定义了2个计数器，个数分别为1和10。
 *
 * 如果不执行begin.countDown()，进程会一致阻塞在begin.await()
 *
 * 主进程执行到end.awit()阻塞等待end计数器清0，进程中每执行一次CountDown()减1，所有执行完后主进程继续往下执行
 *
 *
 * */
public class CounterTest {
    private static final int RUNNER_COUNT = 10;
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < RUNNER_COUNT; i++) {
            final int NO = i + 1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }

        System.out.println("Game Start ...");
        begin.countDown();
        end.await();
//        end.await(30, TimeUnit.SECONDS);
        System.out.println("Game Over.");

        exec.shutdown();
    }
}
