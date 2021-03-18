/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minesweeper;

/**
 *
 * @author simon
 */
public class MinesweeperBoard {
    
    private boolean[][] board;
    private int[][] bombCounter;
    
    public MinesweeperBoard() {
        board = placeBombs(7, 16, 0.2);
    }
    
    public static int[][] calcBombCoutn(boolean[][] bombs) {
        int[][] bombCount = new int[bombs.length][bombs[0].length]; // Stopper-Trick
        
        for(int r = 1; r <= bombs.length; r++) {
            for(int c = 1; c <= bombs[0].length; c++) {
                if(!bombs[r][c]) {
                    
                } else {
                    
                }
            }
        }
        
        return bombCount;
    }
    
    public static boolean[][] placeBombs(int rows, int columns, double probability) {
        boolean[][] bombs = new boolean[rows + 2][columns + 2];
        
        for(int r = 1; r <= bombs.length - 2; r++) {
            for(int c = 1; c <= bombs[0].length - 2; c++) {
                bombs[r][c] = Math.random() < probability;
            }       
        }       
        return bombs;
    }
    
    public void printBoard() {
        for(int r = 1; r <= board.length - 2; r++) {
            for(int c = 1; c <= board[0].length - 2; c++) {
                System.out.print(board[r][c] ? "*" : ".");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        MinesweeperBoard board = new MinesweeperBoard();
        board.printBoard();
    }
}
