public class leetcode_53_ {
    int sum = Integer.MIN_VALUE;  // 返回的最大值
    int sumLocal = 0; // 当前数组中的和，
    public int maxSubArray(int[] nums) {
        for(int num: nums) {
            if(sumLocal < 0) // 当循环的过程中发现之前的和已经小于0，丢弃。
                sumLocal = num;
            else
                sumLocal += num;
            sum = Math.max(sum,sumLocal);
        }
        return sum;
    }
}
