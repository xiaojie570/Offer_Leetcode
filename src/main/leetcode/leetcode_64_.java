public class leetcode_64_ {
    // 机器人运动范围->(右下2个方向)
    public int minPathSum(int[][] grid) throws Exception {
        if(grid == null || grid[0].length == 0)
            throw new Exception("矩阵不对");
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for(int i = 0; i < cols; i++)
            dp[i] = grid[0][i] + (i == 0 ? 0 : dp[i - 1]);
        for(int i = 1; i < rows; i++) {
            dp[0] = grid[i][0] + dp[0];
            for(int j = 1; j < cols;j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) throws Exception {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        leetcode_64_ leetcode_64_ = new leetcode_64_();
        int ret = leetcode_64_.minPathSum(arr);
        System.out.println(ret);
    }
}
