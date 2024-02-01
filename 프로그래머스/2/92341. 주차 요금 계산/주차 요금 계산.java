import java.util.*;
import java.text.*;

class Solution {
    int LIMIT_TIME = 1439;
    
    public int[] solution(int[] fees, String[] records) throws Exception {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (int i = 0; i < records.length; i++) {
            String[] each = records[i].split(" ");
            Date date = dateFormat.parse(each[0]);
            int carNumber = Integer.parseInt(each[1]);
            if (hash.get(carNumber) == null)
                hash.put(carNumber, new ArrayList<>());
            hash.get(carNumber).add(date.getHours() * 60 + date.getMinutes());
            q.add(carNumber);
        }
        
        int[] cars = q.stream().distinct().mapToInt(e -> e).toArray();
        Arrays.sort(cars);
        int[] answer = new int[cars.length];
        
        for (int i = 0; i < cars.length; i++) {
            List<Integer> times = hash.get(cars[i]);
            if (times.size() % 2 != 0)
                times.add(LIMIT_TIME);
            int parkingTime = 0;
            for (int j = 0; j < times.size(); j += 2)
                parkingTime += times.get(j+1) - times.get(j);
            if (parkingTime <= fees[0])
                answer[i] = fees[1];
            else if ((parkingTime - fees[0]) % fees[2] != 0)
                answer[i] = fees[1] + (Math.floorDiv((parkingTime - fees[0]), fees[2]) + 1) * fees[3];
            else
                answer[i] = fees[1] + Math.floorDiv((parkingTime - fees[0]), fees[2]) * fees[3];
        }
        
        return answer;
    }
}