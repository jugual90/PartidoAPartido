package com.example.juangutierrezalvarez.futbolaction.model;

import java.util.ArrayList;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class PartidosDirectoRetrofit
{
    private ArrayList<DirectoRetrofit> matches;

    public PartidosDirectoRetrofit(ArrayList<DirectoRetrofit> partidosDirecto) {
        this.matches = partidosDirecto;
    }

    public ArrayList<DirectoRetrofit> getPartidosDirecto() {
        return matches;
    }

    public void setPartidosDirecto(ArrayList<DirectoRetrofit> partidosDirecto) {
        this.matches = partidosDirecto;
    }
}
