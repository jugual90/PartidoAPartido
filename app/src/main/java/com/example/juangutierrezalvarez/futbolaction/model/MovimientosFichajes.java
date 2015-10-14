package com.example.juangutierrezalvarez.futbolaction.model;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class MovimientosFichajes
{


    private String id = "";
    private String name = "";
    private String picture = "";

    public MovimientosFichajes(String id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
