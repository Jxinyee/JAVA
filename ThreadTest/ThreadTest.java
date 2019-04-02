import java.util.Random;

public class ThreadTest extends Thread{
    String flag;
    public ThreadTest(String flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        String tname = Thread.currentThread().getName()+"线程的run 方法正在调用";
        Random random =new Random();
        for(int i = 0;i<20;i++){
            try {
                Thread.sleep(random.nextInt(10)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tname+"..."+this.flag);
        }
    }

    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest("a");
        ThreadTest thread2 = new ThreadTest("b");
        //thread1.start();
        //thread2.start();
        //thread1.run();
        //thread2.run();
    }


}
