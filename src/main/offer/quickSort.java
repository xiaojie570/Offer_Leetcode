public class quickSort {
    private static int[] quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int p = patition(arr, left, right);//基数
            quicksort(arr, left, p - 1);
            quicksort(arr, p + 1, right);
        }
        return arr;
    }
    private static int patition(int[] arr, int left, int right) {// 分区操作
        int temp = left;
        while (left < right) {
            //从右边开始找到比主键值a[0]小的值，移到左边
            while (left < right && arr[right] >= arr[temp])
                right--;
            while (left < right && arr[left] <= arr[temp])
                //从左边开始找到比主键值a[0]大的值，移到右边
                left++;
            swap(arr,left,right);
        }
        //最终将基准数归位
        swap(arr, temp, right);
        return right;

    }
    private static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,666,33,44,13,32,443};
        quickSort.quicksort(arr,0,arr.length - 1);
        for(int a:arr)
            System.out.println(a);
    }
}
