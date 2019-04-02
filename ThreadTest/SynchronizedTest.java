public class SynchronizedTest {
    //synchronized 只有俩种情况退出 并释放锁
    //一是当程序正常执行完 另一种是遭遇异常
    public static void main(String[] args) {
        SynchronizedTest s1 = new SynchronizedTest();
        SynchronizedTest s2 = new SynchronizedTest();
        new Thread("thread1"){
            @Override
            public void run() {
                synchronized (s1){
                    System.out.println(this.getName()+"is  running ..");
                    try {
                        Thread.sleep(2000);
                        //int i = 1/0;
                        System.out.println(this.getName()+"醒了！");
                        System.out.println(this.getName()+"end!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        new Thread("thread2"){
            @Override
            public void run() {
                synchronized (s1){
                    System.out.println(this.getName()+"is  running ..");
                }
            }
        }.start();
    }

}
