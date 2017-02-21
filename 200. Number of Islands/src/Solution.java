/**
 * Created by sahilpujari on 10/29/16.
 */
public class Solution {

    public final int[] xDir = {1, 0, -1, 0};
    public final int[] yDir = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '0' || visited[i][j])
                    continue;
                explore(grid, i, j, row, col, visited);

                result++;
            }
        }
        return result;
    }

    public boolean shouldVisit(char[][] grid, int i, int j, int row, int col, boolean[][] visited) {
        if(i >=0 && i < row && j >= 0 && j < col && grid[i][j] == '1' && !visited[i][j])
            return true;
        return false;

    }

    public void explore(char[][] grid, int i, int j, int row, int col, boolean[][] visited) {
        if(!shouldVisit(grid, i, j, row, col, visited))
            return;

        visited[i][j] = true;
        for(int x =0; x < 4; x++) {
            explore(grid, i + xDir[x], j + yDir[x], row, col, visited);
        }
    }
}