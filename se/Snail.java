package se;

import java.util.Arrays;

public class Snail {

    public static int[] snail(int[][] matrix) {
        int n = matrix.length;
        int[] snail = new int[n * n];
        int next = 0;
        int first = 0;
        int last = n - 1;
        while (next < n * n) {
            if (first == last) {
                snail[next] = matrix[first][last];
                next++;
            } else {
                for (int i = first; i < last; i++) {
                    snail[next] = matrix[first][i];
                    next++;
                }
                for (int j = first; j < last; j++) {
                    snail[next] = matrix[j][last];
                    next++;
                }
                for (int i = last; i > first; i--) {
                    snail[next] = matrix[last][i];
                    next++;
                }
                for (int j = last; j > first; j--) {
                    snail[next] = matrix[j][first];
                    next++;;
                }
                first++;
                last--;
            }
        }
        return snail;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(Arrays.toString(snail(matrix)));
    }
}