package org.example.Utils;

import org.example.entity.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Parser {
    public static ArrayList<Game> parseFile(){
        ArrayList<Game> games = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(
                Path.of("src/main/resources/games.csv"))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()){
                String[] string = bufferedReader.readLine().split(",");
                try {
                    int rank = Integer.parseInt(string[0]);
                    String name = string[1];
                    String platform = string[2];
                    int year = Integer.parseInt(string[3]);
                    String genre = string[4];
                    String publisher = string[5];
                    double na_sales = Double.parseDouble(string[6]);
                    double eu_sales = Double.parseDouble(string[7]);
                    double jp_sales = Double.parseDouble(string[8]);
                    double other_sales = Double.parseDouble(string[9]);
                    double global_sales = Double.parseDouble(string[10]);
                    games.add(new Game(rank, name, platform, year, genre, publisher,
                            na_sales, eu_sales, jp_sales, other_sales, global_sales));
                }
                catch (NumberFormatException e){
                    System.out.println("Не удалось распарсить");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return games;
    }
}
