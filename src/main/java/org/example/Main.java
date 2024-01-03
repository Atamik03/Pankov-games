package org.example;

import org.example.Utils.DB;
import org.example.Utils.Parser;
import org.example.entity.Game;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Game> games = Parser.parseFile();
        try {
            DB.connect();
            DB.createTable();
//            DB.addData(games);
            DB.firstTask();
            DB.secondTask();
            DB.thirdTask();
            DB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}