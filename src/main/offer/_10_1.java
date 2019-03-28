public class _10_1 {
    long fibonacci(int n) {
        int result[] = {0,1};
        if(n < 2)
            return result[n];
        long findNOne = 1;
        long findNtwo = 0;
        long findN = 0;
        for(int i = 2; i <= n; i++) {
            findN = findNOne + findNtwo;
            findNtwo = findNOne;
            findNOne = findN;
        }
        return findN;
    }
}
