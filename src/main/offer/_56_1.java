public class _56_1 {
    public int findNumber(int number[]) throws Exception {
        if(number == null || number.length == 0)
            throw new Exception("无效输入");
        int length = number.length;
        int bitSum[] = new int[32];
        for(int i = 0; i < length; i++) { // 每一个数字都要映射到32位上
            int mask = 1;
            for(int j = 31; j >= 0; j --) { // 把一个数字映射为二进制
                int bit = mask & number[i];
                if(bit != 0) // 如果对应的位的值不位0，就加1；
                    bitSum[j] += 1;
                bit = bit << 1; // 映射下一位
            }
        }
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            ret = ret << 1; // 依次往左判断
            ret += bitSum[i]%3;
        }
        return ret;
    }
}
