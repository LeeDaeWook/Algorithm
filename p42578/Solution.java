package programmers.p42578;

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> closet = new HashMap<>();
        Integer value;
        for (String[] c : clothes) {
            value = closet.get(c[1]);
            closet.put(c[1], value == null ? 1 : value + 1);
        }

        List<Integer> values = new ArrayList<>(closet.values());
        for (int i = 0; i < values.size(); i++) {
            answer *= (values.get(i) + 1);
        }

        return answer - 1;
    }
}
