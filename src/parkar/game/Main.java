package parkar.game;

import java.util.Scanner;

public class Main {
    // tic-tac-toe game zero kattas(in hindi)

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("player " + player + " enter:");
            int row = in.nextInt();
            int col = in.nextInt();

            if(board[row][col] == ' '){
                board[row][col] =  player;
                gameOver = havewon(board, player);
                if(gameOver){
                    System.out.println("player " + player + " has won");
                    System.out.println("Restart the game now");
                }
                else {
                    player = player == 'X' ? '0' : 'X';
                }

            }else{
                System.out.println("Invalid move. try again");
            }
        }
        printBoard(board);
    }

    private static boolean havewon(char[][] board, char player) {
        //rows win
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //col wins
        for (int col = 0; col < board[0].length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //diagonal wins
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

}