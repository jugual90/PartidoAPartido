package com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class Squad
{
    private String id;
    private String nick;
    private String squadNumber;
    private String year;

    public Squad(String id, String nick, String squadNumber, String year) {
        this.id = id;
        this.nick = nick;
        this.squadNumber = squadNumber;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
