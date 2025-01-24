import java.util.*;
import java.math.BigInteger;

class Solution {
    public long solution(int n) {
        BigInteger answer = BigInteger.ZERO;
        
        for (int y = 0; y <= n/2; y++) {
            // n을 만들기 위해 사용할 1(x)과 2(y)의 개수 계산 
            int x = n - 2*y;
            answer = calculateComb(x+y, x).add(answer);
        }
                
        return answer.remainder(BigInteger.valueOf(1234567)).longValue();
    }
    
    // 같은 것이 있는 순열 (=조합) 계산
    public BigInteger calculateComb(int n, int k) {
        return calculateFacto(k+1, n).divide(calculateFacto(1, n-k));
    }
    
    // 팩토리얼 계산
    public BigInteger calculateFacto(int start, int end) {
        BigInteger result = BigInteger.ONE;
        for (int i = start; i <= end; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}