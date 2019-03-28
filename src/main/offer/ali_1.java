public class ali_1 {
    static boolean VerifySquenceOfBST(int array[],int start,int end) {
        int position = array[start];
        int i = start + 1;
        int right = start + 1;
        if(start>=(end-1))
            return true;
        while(i < end) { // 循环找到第一个大于根节点的节点位置
            if(array[i] > position) {
                right = i;
                break;
            }i++;
        }
        i = right + 1;
        while(i < end) {
            if(array[i] > position) return false;
            i++;
        }
        return VerifySquenceOfBST(array,start + 1,right) && VerifySquenceOfBST(array,right,end);
    }

    public static void main(String[] args) {
        int[] a = {5,3,2,4,9,7,10};
        boolean ret = ali_1.VerifySquenceOfBST(a,0,a.length);
        System.out.println(ret);
    }
}
