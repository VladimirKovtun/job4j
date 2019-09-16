package ru.job4j.array;

public class MatrixCheck {

    public static boolean isWin(char[][] board) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            char sign = board[i][i];
            if (sign == 'X') {
                if (((i < 4) && board[i][i + 1] == 'X') || ((i > 1) && board[i][i - 1] == 'X')) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][k] != 'X') {
                            result = false;
                            break;
                        }
                        if (k == board.length - 1) result = true;
                    }
                } else if (((i < 4) && board[i + 1][i] == 'X') || ((i > 1) && board[i - 1][i] == 'X')) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[k][i] != 'X') {
                            result = false;
                            break;
                        }
                        if (k == board.length - 1) result = true;
                    }
                }
                if (result) break;
            } else result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}
