public class 旋转数组的最小数字 {

    public  static int solution(int[] arrays,int start,int end){
        if (arrays==null||arrays.length==0){
            return -1;
        }
        if (arrays.length==1){
            return arrays[0];
        }
        if (arrays.length==2){
            return arrays[1];
        }
        int middle = (start+end)/2;
        if (arrays[middle]<arrays[middle-1]&&arrays[middle]<arrays[middle+1]){
            return arrays[middle];
        }else if (arrays[middle]>arrays[start]){
            return solution(arrays,middle+1,end);
        }else {
            return solution(arrays,start,middle-1);
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{4,5,1,2,3};
        System.out.println(solution(arr,0,arr.length-1));
    }
}
