import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread("thread1"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                boolean trylock = lock.tryLock();
                System.out.println(thread.getName()+trylock);
                if(trylock){
                    System.out.println(thread.getName()+"得到了锁");
                    for(int i =0;i<5;i++){
                        arrayList.add(i);
                    }
                    System.out.println(thread.getName()+"释放了锁");
                    lock.unlock();
                }
            }
        }.start();
        new Thread("thread2"){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                boolean trylock = lock.tryLock();
                System.out.println(thread.getName()+trylock);
                if(trylock){
                    System.out.println(thread.getName()+"得到了锁");
                    for(int i =0;i<5;i++){
                        arrayList.add(i);
                    }
                    System.out.println(thread.getName()+"释放了锁");
                    lock.unlock();
                }
            }
        }.start();
    }
}
