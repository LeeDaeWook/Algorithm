package programmers.p160585;

import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 1;

        ArrayDeque<Pair> stackO = new ArrayDeque<>();
        ArrayDeque<Pair> stackX = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O')
                    stackO.push(new Pair(i, j));
                else if (board[i].charAt(j) == 'X')
                    stackX.push(new Pair(i, j));
            }
        }

        if (isDone(stackO) && isDone(stackX))
            return 0;

        if (stackO.size() - stackX.size() != 1 && stackO.size() - stackX.size() != 0)
            return 0;

        return answer;
    }

    private boolean isDone(ArrayDeque<Pair> stack) {
        for (int i = 0; i < 3; i++) {
            if (isWinningRow(stack, i) || isWinningColumn(stack, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningRow(ArrayDeque<Pair> stack, int row) {
        return stack.stream().filter(pair -> pair.row == row).count() == 3;
    }

    private boolean isWinningColumn(ArrayDeque<Pair> stack, int col) {
        return stack.stream().filter(pair -> pair.col == col).count() == 3;
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
