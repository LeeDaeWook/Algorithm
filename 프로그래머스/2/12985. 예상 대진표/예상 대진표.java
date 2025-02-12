import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;        
        
        while (true) {
            if ((a / 2 + a % 2) == (b / 2 + b % 2))
                break;
            answer++;
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
        }

        return answer;
    }
}