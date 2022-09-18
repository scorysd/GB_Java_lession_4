
/**
 * Task4
 */
public class Task4 {
    public static int[][] createArr(int a, int b) {
        int[][] matrix = new int[a][b];
        return  matrix;
    }
    public static void printArr(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int  j= 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        System.out.println();
        }
    }
    public static void findPath(int matrix[][], int x, int y) {
        
        if (matrix[x][y]==0) {
            matrix[x][y]=1;
            findPath(matrix, x-1, y-1);
        } else {
            
        }
    }
    
    public static void main(String[] args) {
        // printArr(createArr(10,10));
        int[][] matrix = createArr(10, 10);
        matrix[3][4] = 1;
        matrix[7][9] = 99;
        printArr(matrix);
        findPath(matrix, 3, 4);
    }
}