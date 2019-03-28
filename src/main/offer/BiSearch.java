public class BiSearch {
    public int biSea(int[] arr, int a) throws Exception {
        if(arr == null || arr.length == 0) {
            throw new Exception("无效输入");
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start < end) {
            mid = (start + end) >> 2;
            if(arr[mid] == a) return mid + 1;
            else if(arr[mid] < a) start = mid + 1;
            else if(arr[mid] > a) end = mid - 1;
        }
        return -1;
    }
}
