class Solution {
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];        
        
        for (int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder(s[i]);
            
            // 110 삭제
            int countOneOneZero = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (j >= 2 && sb.charAt(j-2) == '1' && sb.charAt(j-1) == '1' && sb.charAt(j) == '0') {
                    sb.delete(j-2, j+1);
                    countOneOneZero++;
                    j -= 3;
                }
            }

            // 110 삽입
            int countOne = 0;
            for (int j = sb.length()-1; j >= 0; j--) {
                if (countOneOneZero <= 0)
                    break;
                if (sb.charAt(j) == '1') {
                    sb.delete(j, j+1);
                    countOne++;
                }
                else {
                    sb.append("110");
                    j = sb.length();
                    countOneOneZero--;
                }
            }
            
            while (countOneOneZero-- > 0)
                sb.insert(sb.length(), "110");
            
            for (int j = 0; j < countOne; j++)
                sb.append('1');
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}