import java.util.*;

class Solution {
    int[] spellOrder = new int[11];
    
    public String solution(long n, String[] bans) {
        StringBuilder answer = new StringBuilder();
        int spellLen = 0;
        
        Arrays.sort(bans,
            Comparator.comparingInt(String::length)
                      .thenComparing(Comparator.naturalOrder())
        );
        
        // 주문이 삭제되기 전 n번째 주문보다 길이가 짧은 주문의 개수만큼 n을 뒤로 민다.
        int index = 0;
        for (int i = 0; i < bans.length; i++) {
            if (bans[i].length() < spellLen)
                n++;
            else {
                index = i;
                break;                
            }
        }
        
        // 현재 주문보다 사전순으로 앞에있는 주문이 삭제된 경우 n의 크기를 1씩 증가시킨다.
        for (int i = index; i < bans.length; i++) {
            if (convert(bans[i]) <= n)
                n++;
            else
                break;
        }        
        
        spellLen = findSpellLen(n);
        
        long sum = 0;
        long multiple = 1;
        for (int i = 0; i < spellLen-1; i++) {
            multiple *= 26;
            sum += multiple;        
        }
        
        n = n - sum - 1;
        for (int i = spellLen-1; i >= 0; i--) {
            spellOrder[i] = (int) (n % 26);
            n /= 26;
        }       
        
        for (int i = 0; i < spellLen; i++)
            answer.append((char)(spellOrder[i]+'a'));
        
        return answer.toString();
    }
    
    public long convert(String spell) {
        long num = 0;
        long multiple = 1;
        for (int i = spell.length()-1; i >= 0; i--) {
            num += (spell.charAt(i) - 'a' + 1) * multiple;
            multiple *= 26;
        } 
        return num;
    }
    
    public int findSpellLen(long n) {
        long num = 0;
        long multiple = 1;
        for (int i = 1; i <= 10; i++) {
            num = num + multiple * 26;
            multiple *= 26;
            if (num >= n)
                return i;
        }
        
        return 11;
    }
}