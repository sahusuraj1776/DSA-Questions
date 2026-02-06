package BackTracking;
// N-Queens - Problem-51

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: n = 1
// Output: [["Q"]]

// Constraints:

// 1 <= n <= 9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueen{

    public static void main(String[] args) {
        int n=4;
        List<List<String>> res = nQueen(n);
        for (List<String> ans : res) {
            System.out.println(ans + " ");
        }
    }

    private static List<List<String>> nQueen(int n) {
         List<List<String>> res = new ArrayList<>();
         char [][]board = new char[n][n];
         for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
         placeQueen(0,n,board,res);
         return res;
    }

    private static void placeQueen(int r, int n, char[][] board, List<List<String>> res) {
        if(r==n){
            List<String> rows = new ArrayList<>();
            for(char[] row:board){
                rows.add(new String(row));
            }
            res.add(rows);
        }
        for(int c=0;c<n;c++){
            if(isSafe(n,r,c,board)){
                board[r][c]='Q';
                placeQueen(r+1, n, board, res);
                board[r][c]='.';
            }
        }
    }

    private static boolean isSafe(int n, int r, int c, char[][] board) {
        // Check this col on upper side
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        // Check upper diagonal on left side
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Check upper diagonal on right side
        for(int i=r-1,j=c+1; j < n && i >= 0; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}