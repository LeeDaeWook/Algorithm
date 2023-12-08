package programmers.p76502;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            brackets.addLast(s.charAt(i));
        }

        String dict = "[{(";
        char temp;
        for (int i = 0; i < s.length(); i++) {
            if (isRight(brackets.clone(), dict))
                answer++;
            temp = brackets.pop();
            brackets.add(temp);
        }

        return answer;
    }

    private boolean isRight(ArrayDeque<Character> brackets, String dict) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int n = brackets.size();
        char temp;
        for (int i = 0; i < n; i++) {
            temp = brackets.pop();
            if (dict.contains(Character.toString(temp))) {
                stack.push(temp);
            }
            else if (!stack.isEmpty() && findCorrespondingBracket(temp) == stack.peek()) {
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private char findCorrespondingBracket(char c) {
        if (c == ']')
            return '[';
        else if (c == '}')
            return '{';
        else
            return '(';
    }
}