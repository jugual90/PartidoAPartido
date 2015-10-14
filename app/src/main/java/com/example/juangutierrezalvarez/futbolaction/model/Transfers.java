package com.example.juangutierrezalvarez.futbolaction.model;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class Transfers
{
    private MovimientosFichajes arrivals;
    private MovimientosFichajes departures;
    private MovimientosFichajes rumors;
    //private ArrayList<MovimientosFichajes> rumors = new ArrayList<>();

    public Transfers(MovimientosFichajes arrivals, MovimientosFichajes departures, MovimientosFichajes rumors) {
        this.arrivals = arrivals;
        this.departures = departures;
        this.rumors = rumors;
    }

    public MovimientosFichajes getArrivals() {
        return arrivals;
    }

    public void setArrivals(MovimientosFichajes arrivals) {
        this.arrivals = arrivals;
    }

    public MovimientosFichajes getDepartures() {
        return departures;
    }

    public void setDepartures(MovimientosFichajes departures) {
        this.departures = departures;
    }

//    public MovimientosFichajes getRumors() {



    public void setRumors(MovimientosFichajes rumors) {
        this.rumors = rumors;
    }

    public MovimientosFichajes getRumors() {
        return rumors;
    }
}
