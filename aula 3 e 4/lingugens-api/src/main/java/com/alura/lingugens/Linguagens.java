package com.alura.lingugens;

public class Linguagens {
    private String title;
    private String image;
    private int ranking;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    public Linguagens(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

}
