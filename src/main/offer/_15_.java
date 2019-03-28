public class _15_ {
    public static void findOne(int n) {
        int count = 0;
        while(n != 0) {
            count ++;
            n = (n - 1) & n;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        _15_.findOne(13);
    }
}
