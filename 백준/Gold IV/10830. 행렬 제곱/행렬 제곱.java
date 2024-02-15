
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[][] a;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        long b = sc.nextLong();
        a = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextLong();
            }
        }

        long[][] result = pow(a, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }

    private static long[][] pow(long[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        matrix = pow(matrix, exp / 2);

        matrix = mul(matrix, matrix);

        if (exp % 2 == 1) {
            matrix = mul(matrix, a);
        }

        return matrix;
    }

    private static long[][] mul(long[][] m1, long[][] m2) {
        long[][] matrix = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                matrix[i][j] = sum % 1000;
            }
        }

        return matrix;
    }
}
