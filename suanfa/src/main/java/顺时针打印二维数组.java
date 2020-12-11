public class 顺时针打印二维数组 {

    public static void solution(int[][]nums ,int rows,int columns){
        if (nums==null||rows<=0||columns<=0){
            return;
        }

        int start = 0;
        while (rows>start*2&&columns>start*2){
            printNums(nums,rows,columns,start);
            start+=1;
        }
    }

    static void printNums(int[][]nums ,int rows,int columns,int start){

        int endX = columns-1-start;
        int endY = rows-1-start;
        // 从左到右打印
        for (int i=start;i<columns-start;i++){
            System.out.println(nums[start][i]);
        }
        // 从上到下打印
        if (endY>start){
            for (int i =start+1;i<rows-start;i++){
                System.out.println(nums[i][columns-start-1]);
            }
        }

        //从右到左打印
        if (endY>start&&endX>start){
            for (int i=columns-start-2;i>=start;i--){
                System.out.println(nums[rows-start-1][i]);
            }
        }

        //从下到上打印
        if (endX>start&& endY-1>start){
            for (int i =rows-start-2;i>=start+1;i--){
                System.out.println(nums[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[]a = new int[]{1};
        int[]b = new int[]{2};

        int[][]nums = new int[][]{a,b};
        solution(nums,nums.length,nums[0].length);

    }
}
