package com.example.juangutierrezalvarez.futbolaction.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */
public class Table
{
    @SerializedName("table")
    private Clasificacion[] table;


    public Clasificacion[] getTable() {
        return table;
    }

    public void setTable(Clasificacion[] table) {
        this.table = table;
    }
}


