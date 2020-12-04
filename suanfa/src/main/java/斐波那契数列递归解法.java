public class 斐波那契数列递归解法 {
    public static int callTimes = 0;
    public static long fibonacci(int n){
        if (n<=0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        callTimes+=1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(30));
        System.out.println(callTimes);
    }
}
