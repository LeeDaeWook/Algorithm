package programmers.p176962;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;

        Queue<Subject> q = new PriorityQueue<>();

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            q.add(new Subject(plan[0], Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]), Integer.parseInt(plan[2])));
        }

        Deque<Subject> s = new ArrayDeque<>();

        int curTime = 0;
        while (!q.isEmpty()) {
            if (s.isEmpty()) {
                s.push(q.poll());
                curTime = s.peek().startTime;
            }
            else {
                Subject temp = s.pop();
                if (curTime + temp.workTime <= q.peek().startTime) {
                    answer[idx++] = temp.name;
                    curTime += temp.workTime;
                }
                else {
                    temp.workTime -= q.peek().startTime - curTime;
                    curTime += q.peek().startTime - curTime;
                    s.push(temp);
                    s.push(q.poll());
                }
            }
        }

        while (!s.isEmpty()) {
            answer[idx++] = s.pop().name;
        }

        return answer;
    }
}

class Subject implements Comparable<Subject> {
    public String name;
    public int startTime;
    public int workTime;

    public Subject(String name, int startTime, int workTime) {
        this.name = name;
        this.startTime = startTime;
        this.workTime = workTime;
    }

    @Override
    public int compareTo(Subject s) {
        if (this.startTime > s.startTime)
            return 1;
        else if (this.startTime < s.startTime)
            return -1;
        return 0;
    }
}
