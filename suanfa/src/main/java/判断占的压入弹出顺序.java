import java.util.Stack;

public class 判断占的压入弹出顺序 {
    public static boolean solution(int[] input ,int[] output){

        if (input==null||output==null||input.length!=output.length||input.length==0||output.length==0){
            return false;
        }
        Stack<Integer> masterStack = new Stack<Integer>();
        int i =0;
        int p =0;
        while (true){

            if (masterStack.empty()||masterStack.peek()!=output[p]){
                masterStack.push(input[i]);
                i+=1;
            }else {
                masterStack.pop();
                p+=1;
            }
            if (p==output.length){
                return true;
            }
            if (!masterStack.empty()&&(masterStack.peek()!=output[p])&&(i==input.length)){
                return false;
            }
//            if (i<input.length){
//                masterStack.push(input[i]);
//            }
//            if (masterStack.peek()==output[p]){
//                masterStack.pop();
//                p+=1;
//            }else if (i==input.length){
//                return false;
//            }
//            i+=1;
//            if (p==output.length){
//                return true;
//            }

        }
    }

    public static void main(String[] args) {
        int[]input = new int[]{1,2,3,4};
        int[]output = new int[]{1,2,3,4};
        System.out.println(solution(input,output));

    }
}
