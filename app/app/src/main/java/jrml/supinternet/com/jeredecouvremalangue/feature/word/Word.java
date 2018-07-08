package jrml.supinternet.com.jeredecouvremalangue.feature.word;

import java.util.ArrayList;

public class Word {
    private Integer id;
    private String name;
    private String description;
    private ArrayList<String> citation;

    public Word(Integer id, String name, String description, ArrayList<String> citation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.citation = citation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId(){
        return this.id;
    }

    public ArrayList<String> getCitation() {
        return citation;
    }
}
