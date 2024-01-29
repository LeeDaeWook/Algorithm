import java.util.*;

public class Solution {
        
    public int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
            if (n % 2 != 0) {
                n -= 1;
                ans++;
            }
            else
                n /= 2;
        }
        
        return ans;
    }
    
//     private void dfs(int depth, int moves, int curDist, int n, int previous) {
//         // previous == 0 이동 , previous == 1 순간이동
//         if (flag == true)
//             return ;
//         if (curDist == n) {
//             flag = true;
//             return ;
//         }
//         if (curDist > n)
//             return ;
        
//         for (int i = 0; i < 2; i++) {
//             if (depth >= 1 && moves > 0 && previous == 1)
//                 dfs(depth+1, moves - 1, curDist + 1, n, 0);
//             dfs(depth+1, moves, curDist * 2, n, 1);
//         }
//     }
}