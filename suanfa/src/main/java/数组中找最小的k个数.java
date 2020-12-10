import java.util.ArrayList;

public class 数组中找最小的k个数 {

    public static void main(String[] args) {
        数组中找最小的k个数 a = new 数组中找最小的k个数();
        int [] input = new int[]{4,5,1,6,2,7,3,8};

        ArrayList<Integer> t = a.GetLeastNumbers_Solution(input,9);
        for (int q :
                t) {
            System.out.println(q);
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        if (k==0){
            return arrayList;
        }
        if (k>input.length){
            for (int e :
                    input) {
                arrayList.add(e);
            }
            return arrayList;
        }
        findKPostion(input,0,input.length-1,k);

        for (int i=0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;

    }

    public  int[] findKPostion(int[] input,int start,int end,int k){
        if (k<1){
            return new int[0];
        }
        int startPoint = start;
        int endPoint = end;
        int base = input[start];
        while (startPoint<endPoint){
            while (startPoint<endPoint&&input[endPoint]>base){
                endPoint--;
            }
            while (startPoint<endPoint&&input[startPoint]<=base){
                startPoint++;
            }
            swap(input,startPoint,endPoint);
        }
        swap(input,start,endPoint);
        if (endPoint==k-1){
            return input;
        }else if (endPoint<k-1){
            return findKPostion(input,endPoint+1,end,k);
        }else {
            return findKPostion(input,start,endPoint-1,k);
        }
    }


    private  void swap(int[] numArray,int start,int end){
        int temp = numArray[start];
        numArray[start] = numArray[end];
        numArray[end] = temp;
    }
}
