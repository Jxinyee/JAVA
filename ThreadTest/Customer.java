import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {
    BlockingQueue<String> queue;
    public Customer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            System.out.println("I am a  Customer" +Thread.currentThread().getName());
            //String temp = "a Product 生产线程"+Thread.currentThread().getName();
            String temp =queue.take();//如果队列是空的会阻塞线程
            //Thread.sleep(200);
            System.out.println("从生产者那拿的"+temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
