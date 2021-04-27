package Minesweeper;

public enum Direction {
    N(0, -1), NE(1, -1), E(1, 0), SE(1, 1), S(0, 1), SW(-1, 1), W(-1, 0), NW(-1, -1);
    
    private Direction(int x, int y) {
        dx = x;
        dy = y;
    }
    
    int dx;
    int dy;
}
