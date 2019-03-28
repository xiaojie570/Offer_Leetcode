public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lengtha = a.length() - 1;
        int lengthb = b.length() - 1;
        int temp = 0;
        int localSum = 0;
        int valuea = 0, valueb = 0;
        while(lengtha != 0 || lengthb != 0) {
            valuea = 0; valueb = 0;
            if(lengtha > 0) {
                valuea = a.charAt(lengtha) - 'a';
                lengtha --;
            }
            if(lengthb > 0){
                valueb = b.charAt(lengthb) - 'a';
                lengthb --;
            }
            localSum = valuea + valueb;
            if(localSum >= 2) {
                sb.append(localSum - 2);
                temp = 1;
            } else {
                sb.append(localSum);
                temp = 0;
            }
        }
        if(temp == 1) sb.append(temp);
        return sb.reverse().toString();
    }
}
