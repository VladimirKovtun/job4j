package ru.job4j.array;

public class MatrixCheck {

    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            char sign = board[i][i];
            if (sign == 'X') {
                int count = 0;
                if (((i < 4) && board[i][i + 1] == 'X') || ((i > 1) && board[i][i - 1] == 'X')) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][k] == 'X') {
                            count++;
                        }
                    }
                } else if (((i < 4) && board[i + 1][i] == 'X') || ((i > 1) && board[i - 1][i] == 'X')) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[k][i] == 'X') {
                            count++;
                        }
                    }
                }
                if (count == board.length) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
