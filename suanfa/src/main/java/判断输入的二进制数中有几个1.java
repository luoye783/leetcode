public class 判断输入的二进制数中有几个1 {
    public static int solution(int target){
        int count = 0;
        while (target !=0){
            // n&(n-1)可以使n的最后一个1变成0，这是个客观规律，记住就可以了
            target = (target-1)&target;
            count+=1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(solution(9));
    }
}
