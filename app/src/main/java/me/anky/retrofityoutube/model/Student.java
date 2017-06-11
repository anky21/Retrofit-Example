package me.anky.retrofityoutube.model;

/**
 * Created by Anky An on 8/06/2017.
 * anky25@gmail.com
 */

public class Student {

    private String name;
    private String hobby;

    /**
     * No args constructor for use in serialization
     *
     */
    public Student() {
    }

    /**
     *
     * @param name
     * @param hobby
     */
    public Student(String name, String hobby) {
        super();
        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
