package Minesweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class DAL {

    public void save(int[][] bombCounter, File file) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        
        //Reihen
        pw.println(bombCounter.length);
        //Spalten
        pw.println(bombCounter[0].length);
        
        for (int r = 0; r < bombCounter.length; r++) {
            for (int c = 0; c < bombCounter[0].length; c++) {
                pw.print(bombCounter[r][c]);
            }
            pw.println("");
        }
             
        pw.close();
    }   
}
