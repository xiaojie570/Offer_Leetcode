package tree;

import java.util.*;

public class Hua {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];int i = 0;
        String s = scanner.nextLine();
        String[] c = s.split(" ");
        for(String st : c) {
            arr[i ++] = Integer.parseInt(st);
        }
        List<Integer> list = new ArrayList<>(5);
        for(i = 1; i < arr.length - 1; i+=2) {
            list.add(arr[i]);
        }
        Collections.sort(list);

        int right = list.get(3);
        int ret = (int)Math.sqrt(right * right + arr[0] * arr[0]) + right + arr[0];
        System.out.println(ret);
    }
}
