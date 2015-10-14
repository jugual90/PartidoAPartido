package com.example.juangutierrezalvarez.futbolaction.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juangutierrezalvarez on 8/5/15.
 */
public class Directo
{
    @SerializedName("local")
    private String local;

    @SerializedName("visitor")
    private String visitor;

    @SerializedName("competition_name")
    private String competition_name;

    @SerializedName("local_shield")
    private String local_shield;

    @SerializedName("visitor_shield")
    private String visitor_shield;

    @SerializedName("result")
    private String result;

    @SerializedName("live_minute")
    private String live_minute;

    public Directo(String local, String visitor, String competition_name, String local_shield, String visitor_shield, String result, String live_minute) {
        this.local = local;
        this.visitor = visitor;
        this.competition_name = competition_name;
        this.local_shield = local_shield;
        this.visitor_shield = visitor_shield;
        this.result = result;
        this.live_minute = live_minute;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getLocal_shield() {
        return local_shield;
    }

    public void setLocal_shield(String local_shield) {
        this.local_shield = local_shield;
    }

    public String getVisitor_shield() {
        return visitor_shield;
    }

    public void setVisitor_shield(String visitor_shield) {
        this.visitor_shield = visitor_shield;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLive_minute() {
        return live_minute;
    }

    public void setLive_minute(String live_minute) {
        this.live_minute = live_minute;
    }
}
