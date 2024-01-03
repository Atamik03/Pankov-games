package org.example.entity;

public class Game {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double na_sales;
    private double eu_sales;
    private double jp_sales;
    private double other_sales;
    private double global_sales;

    public Game(int rank, String name, String platform, int year, String genre,
                String publisher, double na_sales, double eu_sales, double jp_sales,
                double other_sales, double global_sales) {
        this.rank = rank;
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.na_sales = na_sales;
        this.eu_sales = eu_sales;
        this.jp_sales = jp_sales;
        this.other_sales = other_sales;
        this.global_sales = global_sales;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNa_sales() {
        return na_sales;
    }

    public void setNa_sales(double na_sales) {
        this.na_sales = na_sales;
    }

    public double getEu_sales() {
        return eu_sales;
    }

    public void setEu_sales(double eu_sales) {
        this.eu_sales = eu_sales;
    }

    public double getJp_sales() {
        return jp_sales;
    }

    public void setJp_sales(double jp_sales) {
        this.jp_sales = jp_sales;
    }

    public double getOther_sales() {
        return other_sales;
    }

    public void setOther_sales(double other_sales) {
        this.other_sales = other_sales;
    }

    public double getGlobal_sales() {
        return global_sales;
    }

    public void setGlobal_sales(double global_sales) {
        this.global_sales = global_sales;
    }

    @Override
    public String toString() {
        return "Game{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", na_sales=" + na_sales +
                ", eu_sales=" + eu_sales +
                ", jp_sales=" + jp_sales +
                ", other_sales=" + other_sales +
                ", global_sales=" + global_sales +
                '}';
    }
}
