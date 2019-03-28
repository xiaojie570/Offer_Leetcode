public class _39_ {
    public int getMoreHalfNum(int[] arr) throws Exception {
        if(arr == null || arr.length == 0)
            throw new Exception("数组为null");
        int count = 1;
        int ret = arr[0];
        for(int i = 0 ; i < arr.length; i++) {
            if(ret == arr[i])
                count ++;
            else if(count == 0) {
                ret = arr[i];
                count = 1;
            }
            else
                count --;
        }
        return ret;
    }
}
