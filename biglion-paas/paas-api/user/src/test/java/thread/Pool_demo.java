package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Pool_demo implements Runnable{
    SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
    @Override
    public void run() {
        System.out.println("执行时间："+format.format(new Date())+   "      线程ID：  "+Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Pool_demo demo=new Pool_demo();

        ExecutorService es = Executors.newFixedThreadPool(5);//创建5个线程的线程池
        for (int i = 0; i < 200; i++) {
            es.execute(demo);//执行
        }


    }
}
