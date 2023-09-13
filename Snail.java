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
                //System.out.println("next " + next + " first " + first + " last " + last);
            } else {
                for (int i = first; i < last; i++) {
                    snail[next] = matrix[first][i];
                    next++;
                    //System.out.println(Arrays.toString(snail));
                    //System.out.println("loop 1 next " + next + " first " + first + " last " + last);
                }
                for (int j = first; j < last; j++) {
                    snail[next] = matrix[j][last];
                    next++;
                    //System.out.println(Arrays.toString(snail));
                    //System.out.println("loop 2 next " + next + " first " + first + " last " + last);
                }
                for (int i = last; i > first; i--) {
                    snail[next] = matrix[last][i];
                    next++;
                    //System.out.println(Arrays.toString(snail));
                    //System.out.println("loop 3 next " + next + " first " + first + " last " + last);
                }
                for (int j = last; j > first; j--) {
                    snail[next] = matrix[j][first];
                    next++;
                    //System.out.println(Arrays.toString(snail));
                    //System.out.println("loop 4 next " + next + " first " + first + " last " + last);
                }
                first++;
                last--;
            }
        }
        return snail;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {
                1,
                2,
                3
            },
            {
                4,
                5,
                6
            },
            {
                7,
                8,
                9
            }
        };

        System.out.println(Arrays.toString(snail(matrix)));
    }
}