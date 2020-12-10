package 三个线程顺序打印;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    static Lock lock = new ReentrantLock(false);
    static Condition[] conditions = new Condition[]{lock.newCondition(),lock.newCondition(),lock.newCondition()};
    static volatile int flag=0;
    static volatile int count = 0;
    public static void main(String[] args) {
        Solution s = new Solution();

        Thread thread1 = new Thread1(1,"l");
        Thread thread2 = new Thread1(2,"i");
        Thread thread0 = new Thread0(4,"a",new Thread[]{thread1,thread2});
        thread0.start();
        thread1.start();
        thread2.start();

    }

    static class Thread0 extends Thread{
        public int privateCount = 0;
        public int privateFlag = 0;
        public String text;
        public Thread[] threads;
        public Thread0(int privateCount,String text,Thread[] threads){
            this.privateCount = privateCount;
            this.text = text;
            this.threads = threads;
        }
        @Override
        public void run(){
            lock.lock();
            while (count<=privateCount){
                  if(privateFlag==flag%3){
                      if(count == privateCount){
                          break;
                      }
                      System.out.println(text);

                      flag+=1;
                      count+=1;
                  }else {
                      conditions[flag%3].signal();
                      try {
                          conditions[privateFlag].await();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
            }
                for (Thread t:threads
                ) {
                    t.interrupt();
                }


            lock.unlock();

        }
    }

   static class Thread1 extends Thread{
        public int privateFlag;
        public String text;
       public Thread1(int privateFlag,String text){
           this.privateFlag=privateFlag;
           this.text=text;
       }

       @Override
        public void run(){
           lock.lock();

               while (!isInterrupted()){

                   if(privateFlag==flag%3){
                       System.out.println(text);
                       flag+=1;
                   }else {
                       conditions[flag%3].signalAll();
                       try {
                           conditions[privateFlag].await(10, TimeUnit.SECONDS);
                       } catch (InterruptedException e) {
                           interrupt();
                       }
                   }

               }
           lock.unlock();
       }
       }
}

