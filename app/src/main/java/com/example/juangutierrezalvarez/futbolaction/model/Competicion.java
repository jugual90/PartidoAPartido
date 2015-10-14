package com.example.juangutierrezalvarez.futbolaction.model;

public class Competicion
{
    private String id;
    private String nombre;
    private String logo;
    private String bandera_pais;
    private String pais;

    public Competicion(String id, String nombre, String logo, String bandera_pais, String pais)
    {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.bandera_pais = bandera_pais;
        this.pais = pais;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogo() {
        return logo;
    }

    public String getBandera_pais() {
        return bandera_pais;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Liga: " + id + " - " + nombre + '}';
    }
}
