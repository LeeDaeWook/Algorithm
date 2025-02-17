import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String subStr = phone_book[i].substring(0, j+1);
                if (map.containsKey(subStr) && !map.get(subStr).equals(phone_book[i]))
                    return false;
            }
        }
        
        return true;
    }
}