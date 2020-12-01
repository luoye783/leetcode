public class 查找第K大的数字 {
    public static int solution(int[] arrays,int start,int end,int target){
        if (target>arrays.length){
            return -1;
        }
        int base = arrays[start];
        int startPoint = start;
        int endPoint = end;
        while (startPoint<endPoint){
            while (startPoint<endPoint&&arrays[endPoint]>base){
                endPoint--;
            }
            while (startPoint<endPoint&&arrays[startPoint]<=base){
                startPoint++;
            }
            swap(arrays,startPoint,endPoint);
        }
        swap(arrays,start,startPoint);
        if (startPoint==target-1){
            return base;
        }else if (startPoint>target-1){
            return solution(arrays,start,startPoint-1,target);
        }else {
            return solution(arrays,startPoint+1,end,target);
        }
    }
    private static void swap(int[] numArray,int start,int end){
        int temp = numArray[start];
        numArray[start] = numArray[end];
        numArray[end] = temp;
    }

    public static void main(String[] args) {
        int[] arry = new int[]{3,2,1,5,7,0,10,22,3,1,0,33,34,16,10};

        System.out.println(solution(arry,0,arry.length-1,22));
    }
}
