import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr2[0].length;
        int common = arr1[0].length; // arr1의 열의 수 = arr2의 행의 수
        int[][] answer = new int[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {                
                for (int i = 0; i < common; i++) {
                    answer[row][col] += arr1[row][i] * arr2[i][col];
                }
            }
        }
        
        return answer;
    }
}