public class leetcode_746_ {
    int sum = 0;
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i - 1];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length]);
    }



    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);
        return max;
    }

    public void dp(char[] arrs,int i,String s) {
        if(i == arrs.length)
            System.out.println(s);
        else {
            dp(arrs,i+1,s);
            dp(arrs,i+1,s+arrs[i]);
        }
    }
    public static void main(String[] args) {
        leetcode_746_ l = new leetcode_746_();
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        String s = "abc";
        l.dp(s.toCharArray(),0,"");
    }
}
