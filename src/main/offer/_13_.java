public class _13_ {
    public int getDigitSum(int col) {
        int ret = 0;
        while(col != 0) {
            ret += col % 10;
            col /= 10;
        }
        return ret;
    }// 用来判断这个位置是否符合条件
    public boolean check(int threshold,int cols,int rows,int col,int row,boolean[] visited) {
        if(col < cols && col >=0 && row < rows && row >= 0 && visited[row * cols + col] == false
            && getDigitSum(col) + getDigitSum(row) <= threshold)
            return true;
        return false;
    }// 移动的次数
    public int getCount(int threshold,int cols,int rows,int col,int row,boolean[] visited) {
        int count = 0;
        if(check(threshold, cols, rows, col, row, visited)) {
            visited[row * cols + col] = true;
            count = 1 + getCount(threshold,cols,rows,col - 1,row,visited)
                    + getCount(threshold,cols,rows,col + 1,row,visited)
                    + getCount(threshold,cols,rows,col,row - 1,visited)
                    + getCount(threshold,cols,rows,col,row + 1,visited);
        }
        return count;
    }
}
