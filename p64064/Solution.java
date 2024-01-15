package programmers.p64064;

import java.util.*;

class Solution {
    List<Integer> already = new ArrayList<>();
    List<int[]> existingComb = new ArrayList<>();
    int answer = 0;

    public int solution(String[] user_id, String[] banned_id) {

        dfs(user_id, banned_id, 0);

        return answer;
    }

    private void dfs(String[] user_id, String[] banned_id, int depth) {
        if (depth == banned_id.length) {
            if (!isExisted(already.stream().mapToInt(e -> e).toArray())) {
                existingComb.add(already.stream().mapToInt(e -> e).toArray());
                answer++;
            }
            return ;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!already.contains(i) && isMatched(user_id[i], banned_id[depth])) {
                already.add(i);
                dfs(user_id, banned_id, depth + 1);
                already.remove(already.indexOf(i));
            }
        }
    }

    private boolean isExisted(int[] already) {
        Arrays.sort(already);

        for (int[] existing : existingComb) {
            Arrays.sort(existing);
            int length = 0;
            for (int i = 0; i < existing.length; i++) {
                if (existing[i] == already[i])
                    length++;
            }
            if (length == existing.length)
                return true;
        }
        return false;
    }

    private boolean isMatched(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*')
                continue;
            else if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
}