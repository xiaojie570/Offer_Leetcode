package string;

public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        // ^ 异或：不同为1 ，相同为0；
        StringBuilder sb = new StringBuilder();
        int length1 = a.length();
        int length2 = b.length();
        int temp = 0;
        for(int i = length1 - 1, j = length2 -1; i >= 0 || j >= 0; i--,j--) {
            int tempa = 0, tempb = 0;
            if(i >= 0)
                 tempa= a.charAt(i) - '0';
            if(j >= 0)
                tempb = b.charAt(j) - '0';
            int x = (temp ^ tempa ^ tempb );
            sb.insert(0,x);
            temp = (tempa + tempb + temp) >> 2;
        }
        if(temp >0)
            sb.insert(0,temp);
        return sb.toString();
    }
}
