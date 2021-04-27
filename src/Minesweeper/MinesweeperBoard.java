package Minesweeper;

public class MinesweeperBoard {
    
    private boolean[][] board;
    private int[][] bombCounter;
    
    public MinesweeperBoard(int r, int c, float prob) {
        board = placeBombs(r, c, prob);
        bombCounter = calcBombCount(board);
    }
    
    public static int[][] calcBombCount(boolean[][] bombs) {
        int[][] bombCount = new int[bombs.length][bombs[0].length]; // Stopper-Trick
        
        for(int r = 1; r <= bombs.length - 2; r++) {
            for(int c = 1; c <= bombs[0].length - 2; c++) {
                if(!bombs[r][c]) {
                    for(Direction d : Direction.values()) {
                        if(bombs[r + d.dy][c + d.dx]) {
                            bombCount[r][c]++;
                        }
                    }
                } else {
                    bombCount[r][c] = 9;
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
            
            System.out.print(" ");
            
            for(int c = 1; c <= board[0].length - 2; c++) {
                System.out.print(bombCounter[r][c]);
            }
            System.out.println("");
        }
    }
}
