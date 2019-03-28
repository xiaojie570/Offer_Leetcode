import java.util.Arrays;
// 三个数相加最接近目标 
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) throws Exception {
        if(nums == null || nums.length == 0)
            throw new Exception("数组输入错误");
        Arrays.sort(nums);
        int sum = nums[0] + nums[nums.length - 1];
        int min = sum - target;
        for(int left = 0; left < nums.length; left++) {
            int right = nums.length - 1;
            int medium = left + 1;
            while(medium < right) {
                sum = nums[left] + nums[medium] + nums[right];
                if(Math.abs(sum - target) < Math.abs(min));
                    min = sum - target;
                if(sum == target)
                    return sum;
                else if(sum < target)
                    medium++;
                else
                    right --;
            }
        }
        return min + target;
    }
}
