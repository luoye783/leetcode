public class 打印1到最大的N位数 {

    public static void main(String[] args) {
        solution(2);
    }
    public static void solution(int n){
        if (n<=0){
            return;
        }

        int [] increNums = new int [n];
        for (int i = 0; i <n ; i++) {
            increNums[i] = 0;
        }
        StringBuilder printBuilder = new StringBuilder();
        while (increment(increNums,n-1)){

            int startWithOut0 = 0;
            while (increNums[startWithOut0]==0){
                startWithOut0+=1;
            }
            if (startWithOut0==n-1){
                System.out.println(increNums[startWithOut0]);
            }else {
                for (int i = startWithOut0; i <n ; i++) {
                    printBuilder.append(increNums[i]);
                }
                System.out.println(printBuilder.toString());
                printBuilder.setLength(0);
            }
        }



    }

    public static boolean increment(int [] increNums,int n){
        if (increNums[n]<9){
            increNums[n]+=1;
            return true;
        }else if (increNums[n]==9){
            if (n==0){
                return false;
            }else {
                if (increment(increNums,n-1)) {
                    increNums[n]=0;
                    return true;
                }
                return false;
            }
        }

        return false;

    }
}
