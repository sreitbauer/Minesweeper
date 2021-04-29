package Minesweeper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public int[][] load(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int rows = Integer.parseInt(br.readLine());
        int columns = Integer.parseInt(br.readLine());
        
        int[][] bombCounter = new int[rows][columns];
        
        String line;
        int r = 0;
        while(( line = br.readLine()) != null) {
            for(int i = 0; i < line.length(); i++) {
                int n = Integer.parseInt(""+ line.charAt(i));
                bombCounter[r][i] = n;
            }
            r++;
        }
        
        br.close();
        return bombCounter;
    }
}
