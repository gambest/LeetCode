package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board)); // ← deve imprimir true
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            row.clear();
            col.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
            }
        }

        for (int blockRow = 0; blockRow < 9; blockRow += 3) {
            for (int blockCol = 0; blockCol < 9; blockCol += 3) {
                Set<Character> block = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char val = board[blockRow + i][blockCol + j];
                        if (val != '.' && !block.add(val)) return false;
                    }
                }
            }
        }

        return true;
    }
}
