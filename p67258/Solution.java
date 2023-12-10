package programmers.p67258;

import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemsKind = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemsBag = new HashMap<>();

        int l = 0;
        int minRange = Integer.MAX_VALUE;
        Integer currentValue;
        for (int r = 0; r < gems.length; r++) {
            currentValue = gemsBag.get(gems[r]);
            gemsBag.put(gems[r], currentValue == null ? 1 : currentValue + 1);
            while (gemsBag.size() == gemsKind.size()) {
                if (minRange > r - l) {
                    minRange = r - l;
                    answer[0] = l + 1;
                    answer[1] = r + 1;
                }
                currentValue = gemsBag.get(gems[l]);
                if (currentValue > 1)
                    gemsBag.put(gems[l++], currentValue - 1);
                else
                    gemsBag.remove(gems[l++]);

            }
        }
        return answer;
    }
}