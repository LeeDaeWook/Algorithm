class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {        
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void dfs(int[][] arr, int startRow, int startCol, int len) {
        int num = arr[startRow][startCol];
        boolean isDiff = false;
                
        for (int i = startRow; i < startRow + len; i++) {
            if (isDiff)
                break;
            for (int j = startCol; j < startCol + len; j++) {
                if (arr[i][j] != num) {
                    isDiff = true;
                    break;
                }
            }
        }
        
        if (isDiff) {
            int halfLen = len/2;
            dfs(arr, startRow, startCol, halfLen);
            dfs(arr, startRow + halfLen, startCol, halfLen);
            dfs(arr, startRow, startCol + halfLen, halfLen);
            dfs(arr, startRow + halfLen, startCol + halfLen, halfLen);
        }
        else 
            answer[num]++;
    }
}