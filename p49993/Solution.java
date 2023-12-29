package programmers.p49993;

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Set<Character> s = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            s.add(skill.charAt(i));
        }

        for (int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            int j = 0;
            for (j = 0; j < skill_trees[i].length(); j++) {
                if (s.contains(skill_trees[i].charAt(j))) {
                    if (skill.charAt(index) == skill_trees[i].charAt(j)) {
                        index++;
                    }
                    else
                        break;
                }
            }
            if (j == skill_trees[i].length())
                answer++;
        }

        return answer;
    }
}