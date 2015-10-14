package com.example.juangutierrezalvarez.futbolaction.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */
public class TableMarcador
{

    @SerializedName("matches")
    private Marcador[] matches;


    public Marcador[] getMatches()
    {
        return matches;
    }

    public void setMatches(Marcador[] matches)
    {
        this.matches = matches;
    }
}
