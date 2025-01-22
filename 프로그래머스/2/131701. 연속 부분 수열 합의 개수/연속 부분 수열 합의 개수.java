import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length, doubleLen = elements.length * 2;
        Set<Integer> set = new HashSet<>();
        int[] doubleElements = new int[doubleLen];
        
        // elements배열의 모든 원소들이 2번 반복된 배열 생성 -> 원형 배열처럼 사용하기 위함
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < len; j++)
                doubleElements[i * len + j] = elements[j];
        }

        // 길이가 1부터 elements의 길이까지의 부분수열 찾기
        for (int partSeriesLen = 1; partSeriesLen <= len; partSeriesLen++) {
            // 부분수열의 합 계산
            int start = 0, end = 0, sum = 0;
            while(true) {
                sum += doubleElements[end++];
                if (end - start == partSeriesLen) {
                    set.add(sum);
                    sum -= doubleElements[start++];
                }
                if (end == partSeriesLen + len - 1)
                    break;
            }
        }
        
        return set.size();
    }
}