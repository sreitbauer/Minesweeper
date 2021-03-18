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
    
    public MinesweeperBoard() {
        
    }
    
    public static boolean[][] placeBombs(int rows, int columns, double probability) {
        boolean[][] bombs = new boolean[rows + 2][columns + 2];
        
        for(int r = 1; r <= bombs.length - 2; r++) {
            for(int c = 1; c <= bombs[0].length - 2; c++) {
                bombs[r][c] = Math.random() < probability ? true : false;
            }       
        }       
        return bombs;
    }
    
    public static void main(String[] args) {
        
    }
}
