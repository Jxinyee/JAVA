import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MylockInterupt {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MylockInterupt test = new MylockInterupt();
        Mythread thread1 = new Mythread(test);
        Mythread thread2 = new Mythread(test);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread2.interrupt();
        System.out.println("===============");
    }

    public  void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName()+"得到了锁");
            long startTime = System.currentTimeMillis();
            while (true){
                if(System.currentTimeMillis()-startTime>=Integer.MAX_VALUE){
                    break;
                }
            }
        }finally {
            System.out.println(thread.getName()+"z执行finnally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }

    }

}
class Mythread extends Thread{
    private MylockInterupt test;
    public Mythread(MylockInterupt test){
        this.test= test;
    }
    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        }catch (Exception e){
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}

