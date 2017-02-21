/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {

        if(board == null && word == null || word.equals(""))
            return true;

        if(board == null || board.length == 0) {
            return false;
        }
        char start = word.charAt(0);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        int rows = board.length;
        int cols = board[0].length;

        if(i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }

        if(board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';

            if(word.length() - 1 == k)
                return true;

            else if(dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) ||
                    dfs(board, word, i + 1, j, k + 1) ||
                    dfs(board, word, i, j - 1, k + 1))
                return true;
            board[i][j] = temp;
        }

        return false;
    }
}