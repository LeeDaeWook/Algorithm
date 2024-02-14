
import java.util.Scanner;

public class Main {
    static long[][] origin = {{1, 1}, {1, 0}};
    static long MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long[][] result = recursive(origin, n);
        System.out.println(result[1][0]);
    }

    private static long[][] recursive(long[][] matrix, long exp) {
        if (exp == 1 | exp == 0) {
            return matrix;
        }

        matrix = recursive(matrix, exp / 2);

        matrix = multiply(matrix, matrix);

        if (exp % 2 == 1) {
            matrix = multiply(matrix, origin);
        }

        return matrix;
    }

    private static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] matrix = new long[2][2];

        matrix[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD;
        matrix[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD;
        matrix[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD;
        matrix[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD;

        return matrix;
    }
}
