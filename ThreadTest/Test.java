import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<String>(2);
        Customer customer = new Customer(queue);
        Producer producer =  new Producer(queue);
        for(int i =0;i<3;i++){
            new Thread(producer,"Producer"+(i+1)).start();
        }
        for(int i =0;i<5;i++){
            new Thread(customer,"Customer"+(i+1)).start();
        }

    }
}
