package programmers.p68645;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] result = s.solution(6);

        String output = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
// aaaa
// aaaaa aaaae aaaai aaaao aaaau
// aaae
