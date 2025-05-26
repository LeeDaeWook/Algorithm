import java.util.*;

class Solution {
    BitSet used;
    
    public int solution(int[] a) {
        used = new BitSet(a.length);
        int answer = 0;
                
        // 2개 숫자의 쌍을 담는 컨테이너
        Set<Integer> bucket = new HashSet<>();
        
        while (true) {
            int count = 0;
            // 입력 배열에서 가장 빈도가 높은 숫자를 구한다.
            int[] nums = findMostFrequentNum(a);
            int x = nums[0];
            int xCount = nums[1];
            used.set(x);
            if (xCount * 2 <= answer)
                break;            
            for (int num: a) {
                if (bucket.isEmpty())
                    bucket.add(num);
                else {
                    // 이미 x를 쌍에 넣었고, 현재 숫자가 x가 아니면
                    if (bucket.contains(x) && num != x)
                        bucket.add(num);
                    // 이미 x가 아닌 숫자를 넣었고, 현재 숫자가 x이면 
                    else if(!bucket.contains(x) && num == x)
                        bucket.add(num);
                    else
                        continue;
                }

                // x를 포함한 숫자 쌍을 완성했으면 수열의 길이를 2 늘린다. -> 숫자 쌍 1개는 수열의 길이를 2만큼 늘리기 때문
                if (bucket.size() == 2) {
                    count += 2;
                    bucket.clear();
                }
            }   
            bucket.clear();
            answer = answer >= count ? answer : count;
        }

        return answer;
    }
    
    public int[] findMostFrequentNum(int[] a) {
        Map<Integer, Integer> frequent = new HashMap<>();
        int maxCount = 0;
        int frequentNum = 0;
        
        for (int num: a) {
            if (used.get(num))
                continue;
            int count = frequent.getOrDefault(num, 0) + 1;
            frequent.put(num, count);
            
            if (maxCount < count) {
                maxCount = count;
                frequentNum = num;
            }
        }
        
        return new int[]{frequentNum, maxCount};
    }
}