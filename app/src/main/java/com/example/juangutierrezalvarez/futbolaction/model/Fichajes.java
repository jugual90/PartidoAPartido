package com.example.juangutierrezalvarez.futbolaction.model;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class Fichajes
{

    private String id;

    private String name;

    private String year;

    private String value_transfers;

    private String shield;

    private Transfers transfers;

    public Fichajes(String id, String name, String year, String value_transfers, String shield, Transfers transfers) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.value_transfers = value_transfers;
        this.shield = shield;
        this.transfers = transfers;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue_transfers() {
        return value_transfers;
    }

    public void setValue_transfers(String value_transfers) {
        this.value_transfers = value_transfers;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public Transfers getTransfers() {
        return transfers;
    }

    public void setTransfers(Transfers transfers) {
        this.transfers = transfers;
    }
}
