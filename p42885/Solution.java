package programmers.p42885;

import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            int temp = people[l];
            if (limit >= temp + people[r]) {
                l++;
                r--;
            } else {
                r--;
            }
            answer++;
        }

        return answer;
    }
}


//class Solution {
//    public int solution(int[] people, int limit) {
//        int answer = 0;
//
//        int l = 0;
//        int r = 50000 * 240;
//
//        int sum = Arrays.stream(people).sum();
//        int min = sum / limit;
//        if (sum % limit > 0)
//            min++;
//        int mid = 0;
//        int value = 0;
//        while (l <= r) {
//            mid = (l + r) / 2;
//            value = mid / limit;
//            if (mid % limit > 0)
//                value++;
//            if (value > min)
//                r = mid - 1;
//            else
//                l = mid + 1;
//        }
//        System.out.println(mid);
//        answer = mid / limit;
//        if (mid % limit > 0)
//            answer++;
//
//        return answer;
//    }
//}
//
//import java.util.*;
//
//class Solution {
//    public int solution(int[] people, int limit) {
//        int answer = 0;
//
//        int sum = Arrays.stream(people).sum();
//        int min = sum / limit;
//        if (sum % limit > 0)
//            min++;
//
//        int l = min;
//        int r = people.length;
//
//        int mid = 0;
//        while (l <= r) {
//            mid = (l + r) / 2;
//            if (mid >= min)
//                r = mid - 1;
//            else
//                l = mid + 1;
//        }
//
//        return mid;
//    }
//}