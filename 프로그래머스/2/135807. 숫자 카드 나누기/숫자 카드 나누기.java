import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {        
        // 각 배열에서 가장 작은 수 찾기
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        // 각 배열에서 가장 작은 수의 약수들 찾기
        List<Integer> divisorsOfA = findDivisors(arrayA[0]);
        List<Integer> divisorsOfB = findDivisors(arrayB[0]);
        
        int a = findAnswer(divisorsOfA, arrayA, arrayB);
        int b = findAnswer(divisorsOfB, arrayB, arrayA);
        
        return a > b ? a : b;
    }
            
    public int findAnswer(List<Integer> divisors, int[] A, int[] B) {
        int len = divisors.size();
        for (int i = 0; i < len; i++) {
            if (isAllDivisible(divisors.get(i), A) && isNotAllDivisible(divisors.get(i), B)) {
                return divisors.get(i);
            }
        }
        return 0;
    }
    
    public boolean isAllDivisible(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num != 0)
                return false;
        }
        return true;
    }
    
    public boolean isNotAllDivisible(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num == 0)
                return false;
        }
        return true;
    }
    
    public List<Integer> findDivisors(int num) {
        List<Integer> divisors = new ArrayList<>(Arrays.asList(num));
        for (int i = 2; i * i <= num ; i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }        
        divisors.sort(Comparator.reverseOrder());
        return divisors;
    }
}