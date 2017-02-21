import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahilpujari on 11/1/16.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0, y = 0;
        int level = 0;

        while(rows > 0 && cols > 0) {
            if(rows == 1) {
                for(int i = 0; i < cols; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if(cols == 1) {
                for(int i = 0; i < rows; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            for(int i = 0; i < cols - 1; i++) {
                result.add(matrix[x][y++]);
            }

            for(int i = 0; i < rows - 1; i++) {
                result.add(matrix[x++][y]);
            }

            for(int i = 0; i < cols - 1; i++) {
                result.add(matrix[x][y--]);
            }

            for(int i = 0; i < rows - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            rows -= 2;
            cols -= 2;
        }

        return result;
    }
}