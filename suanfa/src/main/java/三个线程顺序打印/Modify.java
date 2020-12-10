package 三个线程顺序打印;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Modify {
    private static volatile int flag=0;
    private static Lock  lock = new ReentrantLock(true);
    private static Condition[] conditions = new Condition[]{lock.newCondition(),lock.newCondition()};
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {

        char[] lowerChar = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upperChar = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        Thread1 thread1 = new Thread1(0,lowerChar);
        Thread1 thread2 = new Thread1(1,upperChar);
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("总耗时:"+(end-start));

    }
    public static class Thread1 extends Thread {
        int privateFlag = 0;
        char[] text;
        int i =0;

        Thread1(int privateFlag, char[] text) {
            this.privateFlag = privateFlag;
            this.text = text;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            lock.lock();
            while (true) {
                if(flag%2==privateFlag){
                    flag+=1;
                    System.out.println(text[i]);
                    i+=1;
                    if (i>text.length-1){
                        conditions[flag%2].signal();
                        break;
                    }
                }else {
                    conditions[flag%2].signal();
                    try {
                        conditions[privateFlag].await();
                    } catch (InterruptedException e) {
                        interrupt();
                    }

                }
            }
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+":"+(end-start));
            countDownLatch.countDown();
            lock.unlock();
        }
    }
}
