/**
 * Created by sahilpujari on 10/27/16.
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for(int i = 0; i < rowsA; i++) {
            for(int j = 0; j < colsB; j++) {
                int sum = 0;
                for(int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}