import java.util.ArrayDeque;

/**
 * Task4
 */
public class Task4 {
    public static int[][] createArr(int a, int b) {
        int[][] matrix = new int[a][b];
        return matrix;
    }
    public static void printArr(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void FillArr(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 8;
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 8;
                for (int k = 0; k < matrix.length; k++) {
                    matrix[k][matrix[0].length - 1] = 8;
                    for (int l = 0; l < matrix.length; l++) {
                        matrix[matrix.length - 1][l] = 8;
                    }
                }
            }
        }
    }
    public static void findPath(int matrix[][], int x, int y, int step) {
        ArrayDeque<Integer> steps = new ArrayDeque<>();
        if (matrix[x - 1][y] == 0 && x > 1) {
            matrix[x - 1][y] = step;
            steps.addLast(x - 1);
            steps.addLast(y);
            step++;
            findPath(matrix, steps.poll(), steps.poll(), step);
        }
        if (matrix[x][y + 1] == 0 && y < 9) {
            matrix[x][y + 1] = step;
            steps.addLast(x);
            steps.addLast(y + 1);
            step++;
            findPath(matrix, steps.poll(), steps.poll(), step);
        }
        if (matrix[x + 1][y] == 0 && x < 9) {
            matrix[x + 1][y] = step;
            steps.addLast(x + 1);
            steps.addLast(y);
            step++;
            findPath(matrix, steps.poll(), steps.poll(), step);
        }
        if (matrix[x][y - 1] == 0 && y > 1) {
            matrix[x][y - 1] = step;
            steps.addLast(x);
            steps.addLast(y - 1);
            findPath(matrix, steps.poll(), steps.poll(), step);
        }
    }

    public static void main(String[] args) {
        printArr(createArr(10, 10));
        int[][] matrix = createArr(10, 10);
        FillArr(matrix);
        findPath(matrix, 5, 4, 1);
        System.out.println("_________");
        printArr(matrix);
    }
}