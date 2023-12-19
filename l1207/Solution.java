package leetcode.l1207;

import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);

        Set<Integer> occurrence = new HashSet<>();
        int count = 1;
        int kind = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                occurrence.add(count);
                count = 0;
                kind++;
            }
            count++;
        }
        occurrence.add(count);

        return occurrence.size() == kind;
    }
}
