import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class wait和notify两个线程打印大小写 {
    public static int state = 0;
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition[] conditions = new Condition[]{lock.newCondition(),lock.newCondition()};
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        char[] lowerChar = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upperChar = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Thread0 thread0 = new Thread0(lowerChar,0);
        Thread0 thread1 = new Thread0(upperChar,1);
        long start = System.currentTimeMillis();
        thread0.start();
        thread1.start();
        countDownLatch.await();
        System.out.println("主线程用时"+(System.currentTimeMillis()-start));
    }

    public static class Thread0 extends Thread{
        public char[]t;
        public int flag;
        Thread0(char[]t,int flag){
            this.t=t;
            this.flag=flag;
        }
        @Override
        public void run(){
            long start = System.currentTimeMillis();
            try {
                lock.lock();
                for (char c :
                        t) {
                    if (state%conditions.length!=flag){
                        conditions[state%conditions.length].signal();
                        conditions[flag].await();

                    }
                    state+=1;
                    System.out.println(c);

                }
                conditions[state%conditions.length].signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"线程用时"+(System.currentTimeMillis()-start));
            countDownLatch.countDown();


        }
    }
}
