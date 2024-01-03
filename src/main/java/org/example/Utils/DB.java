package org.example.Utils;

import org.example.entity.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB {
    private static Connection conn;
    private static Statement statement;

    public static void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
        statement = conn.createStatement();
    }

    public static void close() throws SQLException {
        statement.close();
        conn.close();
    }

    public static void createTable() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS Games (" +
                "rank INT, " +
                "name TEXT," +
                "platform TEXT, " +
                "year INT, " +
                "genre TEXT, " +
                "publisher TEXT, " +
                "na_sales FLOAT, " +
                "eu_sales FLOAT, " +
                "jp_sales FLOAT, " +
                "other_sales FLOAT, " +
                "global_sales FLOAT);"
        );
    }

    public static void addData(ArrayList<Game> games) {
        games.forEach(game -> {
            try {
                statement.execute(String.format("INSERT INTO Games " +
                                "VALUES ('%d', '%s', '%s', '%d', '%s', '%s', '%f', '%f', '%f', '%f', '%f');",
                        game.getRank(), game.getName().replace("'", ""), game.getPlatform(), game.getYear(),
                        game.getGenre(), game.getPublisher().replace("'", ""), game.getNa_sales(), game.getEu_sales(),
                        game.getJp_sales(), game.getOther_sales(), game.getGlobal_sales()));
            } catch (SQLException e) {
                System.out.println(game);
                throw new RuntimeException(e);
            }
        });
    }

    public static void firstTask() throws SQLException {
        String sql = "SELECT platform, AVG(global_sales) as avg_sales FROM Games " +
                "GROUP BY platform;";
        ResultSet res = statement.executeQuery(sql);
        Map<String, Double> map = new HashMap<>();
        while (res.next()){
            map.put(res.getString(1), Double.parseDouble(res.getString(2)));
        }
        Graphic graphic = new Graphic(map);
        graphic.setVisible(true);
    }

    public static void secondTask() throws SQLException {
        String sql = "SELECT name FROM Games WHERE (year = 2000) " +
                "ORDER BY eu_sales DESC LIMIT 1";
        String res = statement.executeQuery(sql).getString("name");
        System.out.printf("Игра с самыми высокими показателеми продаж в Европе за 2000 год: %s\n", res);
    }

    public static void thirdTask() throws SQLException {
        String sql = "SELECT name FROM Games WHERE (year >= 2000 AND year <= 2006)" +
                "AND (genre = 'Sports') ORDER BY jp_sales DESC LIMIT 1";
        String res = statement.executeQuery(sql).getString("name");
        System.out.printf("Игра, созданная в промежутке с 2000 по 2006 год с самым высоким показателем продаж в Японии из жанра спортивных игр: %s\n", res);
    }
}
