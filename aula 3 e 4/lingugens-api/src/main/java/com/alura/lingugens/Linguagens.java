package com.alura.lingugens;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "principaisLinguagens")
public class Linguagens {
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;


    public Linguagens(){}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    public Linguagens(String id, String title, String image, int ranking) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }


}
