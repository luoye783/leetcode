public class 斐波那契数列动态规划解法 {
    public static long solution(int n){
        if (n<=0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        long[] result= new long[n+1];
        result[0]=0;
        result[1]=1;
        for (int i=2;i<=n;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution(30));
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
    }
}
