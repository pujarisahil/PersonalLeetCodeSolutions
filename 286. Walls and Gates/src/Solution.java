/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j++) {
                if(rooms[i][j] == 0) {
                    helper(rooms, visited, i - 1, j, 0);
                    helper(rooms, visited, i, j + 1, 0);
                    helper(rooms, visited, i + 1, j, 0);
                    helper(rooms, visited, i, j - 1, 0);
                    visited = new boolean[rows][cols];
                }
            }
        }
    }

    public void helper(int[][] rooms, boolean[][] visited, int i, int j, int start) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] <= 0 ||visited[i][j])
            return;

        rooms[i][j] = Math.min(rooms[i][j], start + 1);
        visited[i][j] = true;


        helper(rooms, visited, i - 1, j, start + 1);
        helper(rooms, visited, i, j + 1, start + 1);
        helper(rooms, visited, i + 1, j, start + 1);
        helper(rooms, visited, i, j - 1, start + 1);
        visited[i][j] = false;
    }
}