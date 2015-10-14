package com.example.juangutierrezalvarez.futbolaction.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juangutierrezalvarez on 8/5/15.
 */
public class TableDirecto
{
    @SerializedName("matches")
    private Directo[] matches;


    public Directo[] getMatches()
    {
        return matches;
    }

    public void setMatches(Directo[] matches)
    {
        this.matches = matches;
    }
}
