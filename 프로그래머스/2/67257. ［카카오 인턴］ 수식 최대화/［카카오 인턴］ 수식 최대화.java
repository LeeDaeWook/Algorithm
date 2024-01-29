import java.util.*;

class Solution {
    long answer = 0;
    List<Integer> operator = new ArrayList<>();
    List<Long> operand = new ArrayList<>();
    int[] permutation;
    List<int[]> allPermutation = new ArrayList<>();

    public long solution(String expression) {

        // + : 1 / - : 2 / * : 3
        StringBuilder num = new StringBuilder();
        int operatorIdx = 0;
        int operandIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operand.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
            }
            if (c == '+')
                operator.add(1);
            else if (c == '-')
                operator.add(2);
            else if (c == '*')
                operator.add(3);
            else
                num.append(expression.charAt(i));
        }
        operand.add(Long.parseLong(num.toString()));
        int[] nums = operator.stream().distinct().mapToInt(e -> e).toArray();
        permutation = new int[nums.length];
        makePermutation(nums, new boolean[nums.length], 0);
        for (int i = 0; i < allPermutation.size(); i++)
            answer = Math.max(answer, Math.abs(calculateAll(allPermutation.get(i), new ArrayList<>(operand), new ArrayList<>(operator))));

        return answer;
    }

    private long calculateAll(int[] operators, List<Long> operand, List<Integer> operator) {
        for (int i = 0; i < operators.length; i++) {
            int opt = operators[i];
            for (int j = 0; j < operator.size(); j++) {
                if (operator.get(j) == opt) {
                    Long result = calculateEach(opt, operand.get(j), operand.get(j+1));                    
                    operand.remove(j+1);
                    operand.remove(j);
                    operand.add(j, result);
                    operator.remove(j);
                    j = -1;
                }
            }
        }
        return operand.get(0);
    }

    private long calculateEach(int opt, long num1, long num2) {
        if (opt == 1)
            return num1 + num2;
        else if (opt == 2)
            return num1 - num2;
        else
            return num1 * num2;
    }

    private void makePermutation(int[] nums, boolean[] used, int depth) {
        if (depth == nums.length) {
            allPermutation.add(permutation.clone());
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            permutation[depth] = nums[i];
            makePermutation(nums, used, depth+1);
            used[i] = false;
        }
    }
}
