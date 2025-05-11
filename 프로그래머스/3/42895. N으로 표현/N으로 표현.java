import java.util.*;

class Solution {    
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 1; i <= 8; i++) {
            dp.add(new HashSet<>());
            dp.get(i-1).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            Set<Integer> set = dp.get(i-1);
            for (int j = 1; j < i; j++) {
                for (int num1: dp.get(i-1-j)) {
                    for (int num2: dp.get(j-1)) {
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if (num2 != 0)
                            set.add(num1 / num2);
                    }
                }
            }
            
            if (set.contains(number))
                return i;
        }
        
        return -1;
    }
}