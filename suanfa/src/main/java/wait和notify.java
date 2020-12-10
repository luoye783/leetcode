public class wait和notify {
    public static int count = 0;
    public static Object object = new Object();
    public static void solution(){

    }

    public static void main(String[] args) {
        char[] lowerChar = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upperChar = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Thread0 thread0 = new Thread0(lowerChar);
        Thread0 thread1 = new Thread0(upperChar);
        thread0.start();
        thread1.start();
    }
    static class Thread0 extends Thread{
        char[] t;
        Thread0(char[] t){
            this.t=t;
        }
        @Override
        public void run(){
            synchronized (object){
                for (char c :
                        t) {
                    System.out.println(c);
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notifyAll();
            }
        }
    }

}
