package com.example.juangutierrezalvarez.futbolaction.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */

public class Clasificacion
{
    @SerializedName("shield")
    private String shield;
    @SerializedName("team")
    private String team;
    @SerializedName("points")
    private String points;
    @SerializedName("pos")
    private String pos;
    @SerializedName("round")
    private String round;
    @SerializedName("wins")
    private String wins;
    @SerializedName("draws")
    private String draws;
    @SerializedName("losses")
    private String losses;
    @SerializedName("gf")
    private String gf;
    @SerializedName("ga")
    private String ga;




    public Clasificacion(String shield, String team, String points, String pos, String round, String wins, String draws, String losses, String gf, String ga) {
        this.shield = shield;
        this.team = team;
        this.points = points;
        this.pos = pos;
        this.round = round;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.gf = gf;
        this.ga = ga;
    }


    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }
}
