public class 快速排序 {

    public static void main(String[] args) {
        int[] arry = new int[]{3,2,1,5,7,0,10,22,3,1,0,33,34,16,10};
        quickSortMethod(arry,0,arry.length-1);
        for (int i :
                arry) {
            System.out.println(i);
        }
    }
    public static void quickSortMethod(int[] numArray,int start,int end){
        if (end<=start ||end==0||start>=numArray.length){
            return;
        }
        int startPoint = start;
        int endPoint = end;
        int base = numArray[start];
        while (startPoint<endPoint){
            // 之所以让后面的指针先往前走，是因为后面指针会停下来的地方遇见的值必然比BASE小。BASE所在的位置0肯定在分割线的左边
            while (startPoint<endPoint&&numArray[endPoint]>base){
                endPoint--;
            }
            while (startPoint<endPoint&&numArray[startPoint]<=base){
                startPoint++;
            }


            swap(numArray,startPoint,endPoint);
        }
        swap(numArray, start, startPoint);
        quickSortMethod(numArray,start,endPoint-1);
        quickSortMethod(numArray,endPoint+1,end);

    }

    private static void swap(int[] numArray,int start,int end){
        int temp = numArray[start];
        numArray[start] = numArray[end];
        numArray[end] = temp;
    }
}
