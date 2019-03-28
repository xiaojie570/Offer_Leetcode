import java.util.HashMap;
import java.util.Map;

public class Heap {
    static int[] arr = {1, 2, 5, 10, 20, 50, 100};
    public int f(int money) {
         int moneyTemp = money; // 总价钱
         int remaining = 0;
         int max = 0;
         int count = 0;  // 最少零钱的数目
         for (int i = arr.length - 1; i >= 0; i--) {
             max = moneyTemp / arr[i]; // 从最大的取，可以取多少个最大面额的钱
             remaining = moneyTemp % (arr[i]); // 除去最大的应该取多少钱
             moneyTemp = remaining;  // 更新价钱
             count = count + max;
             if(remaining == 0)
                 break;
         }
         return count;
    }
    public static void main(String[] args) {
        Heap m = new Heap();
        System.out.println(m.f(188));
    }


   /* public int countPark(int[][] list){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(Integer i =0; i<list.length; i++){
            map.put(list[i][0],map.getOrDefault(list[i][0], 0)+1);
            map.put(list[i][1]+12,map.getOrDefault(list[i][1]+12, 0)+1);
        }
        int ins = 0;
        for(Integer j =1; j<=12;j++){
            map.put(j, map.getOrDefault(j, 0));
            map.put(j+12, map.getOrDefault(j+12, 0));
            res = Math.max(res, ins = ins+map.get(j)-map.get(j+12));
        }
        return res;
    }*/
}
