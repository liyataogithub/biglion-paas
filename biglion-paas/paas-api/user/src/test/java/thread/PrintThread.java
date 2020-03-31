package thread;

public class PrintThread extends Thread{

    public void run(){

        System.out.println("当前线程名："+Thread.currentThread().getName());

    }
}
