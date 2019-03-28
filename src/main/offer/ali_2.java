public class ali_2 {
    // 24.给一个无序数组，求排好序后得每个元素在有序序列中的下标，要求原数组元素顺序不变
    public int[] getIndex(int[] arr) {
        int length = arr.length;
        int a = arr[0];
        int[] ret = new int[length];
        for(int j = 0; j < length; j++) {
            int temp = 0;
            a = arr[j];
            for (int i = 0; i < length; i++) {
                if (a > arr[i])
                    temp++;
            }
            ret[j] = temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        ali_2 test = new ali_2();
        int ret[] = test.getIndex(new int[]{20,15,45,5,10,9,11});
        for(int i : ret)
            System.out.println(i + ",");
    }
}
