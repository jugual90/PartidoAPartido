package com.example.juangutierrezalvarez.futbolaction.model;

import java.util.ArrayList;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class Leagues
{
    private ArrayList<Fichajes> leagues;

    public Leagues(ArrayList<Fichajes> leagues)
    {
        this.leagues = leagues;
    }

    public ArrayList<Fichajes> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<Fichajes> leagues)
    {
        this.leagues = leagues;
    }
}
