
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
//        String input = br.readLine();
        String input = sc.nextLine();
        if (input.length() % 2 == 1 || input.length() > 30) {
            System.out.println(0);
            return ;
        }

        // 입력된 string을 정수형으로 변환
        int[] arr = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(')
                arr[i] = -1;
            else if (c == ')')
                arr[i] = -2;
            else if (c == '[')
                arr[i] = -3;
            else
                arr[i] = -4;
        }
        // stack을 이용한 계산
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int par = arr[i];
            if (par == -1 || par == -3) {
                stack.addFirst(par);
            }
            else if (stack.isEmpty() || (par == -2 && stack.peek() != -1 && stack.peek() < 0)
                    || (par == -4 && stack.peek() != -3 && stack.peek() < 0)) {
                System.out.println(0);
                return ;
            }
            else if (par == -2) {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    sum += stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return ;
                }
                stack.pop();
                stack.addFirst(sum == 0 ? 2 : sum * 2);
            }
            else if (par == -4) {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != -3) {
                    sum += stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return ;
                }
                stack.pop();
                stack.addFirst(sum == 0 ? 3 : sum * 3);
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < 0) {
                System.out.println(0);
                return;
            }
            answer += num;
        }
        System.out.println(answer);
    }
}
