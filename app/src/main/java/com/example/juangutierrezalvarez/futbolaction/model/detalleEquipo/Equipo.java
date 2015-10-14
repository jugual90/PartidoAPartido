package com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class Equipo implements Parcelable {
    private String fullName;
    private String managerNow;
    private String yearFoundation;
    private String chairman;
    private String seats;
    private String yearlyBudget;
    private String yearBuilt;
    private String historical;
    private String twitter;
    private String team_b;
    private String patrocinador;
    private String proveedor;
    private String shield;
    private String stadium;
    private String img_stadium;
    private Category category;
    private Squad squad;

    public Equipo() {}

    public Equipo(String fullName, String stadium, String managerNow, String yearFoundation, String chairman, String seats, String yearlyBudget, String yearBuilt, String historical, String twitter, String team_b, String patrocinador, String proveedor, String shield,  String img_stadium, Category category, Squad squad) {
        this.fullName = fullName;
        this.stadium = stadium;
        this.managerNow = managerNow;
        this.yearFoundation = yearFoundation;
        this.chairman = chairman;
        this.seats = seats;
        this.yearlyBudget = yearlyBudget;
        this.yearBuilt = yearBuilt;
        this.historical = historical;
        this.twitter = twitter;
        this.team_b = team_b;
        this.patrocinador = patrocinador;
        this.proveedor = proveedor;
        this.shield = shield;
        this.img_stadium = img_stadium;
        this.category = category;
        this.squad = squad;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getManagerNow() {
        return managerNow;
    }

    public void setManagerNow(String managerNow) {
        this.managerNow = managerNow;
    }

    public String getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(String yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getYearlyBudget() {
        return yearlyBudget;
    }

    public void setYearlyBudget(String yearlyBudget) {
        this.yearlyBudget = yearlyBudget;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHistorical() {
        return historical;
    }

    public void setHistorical(String historical) {
        this.historical = historical;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getImg_stadium() {
        return img_stadium;
    }

    public void setImg_stadium(String img_stadium) {
        this.img_stadium = img_stadium;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    protected Equipo(Parcel in) {
        fullName = in.readString();
        managerNow = in.readString();
        yearFoundation = in.readString();
        chairman = in.readString();
        seats = in.readString();
        yearlyBudget = in.readString();
        yearBuilt = in.readString();
        historical = in.readString();
        twitter = in.readString();
        team_b = in.readString();
        patrocinador = in.readString();
        proveedor = in.readString();
        shield = in.readString();
        stadium = in.readString();
        img_stadium = in.readString();
        category = (Category) in.readValue(Category.class.getClassLoader());
        squad = (Squad) in.readValue(Squad.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(managerNow);
        dest.writeString(yearFoundation);
        dest.writeString(chairman);
        dest.writeString(seats);
        dest.writeString(yearlyBudget);
        dest.writeString(yearBuilt);
        dest.writeString(historical);
        dest.writeString(twitter);
        dest.writeString(team_b);
        dest.writeString(patrocinador);
        dest.writeString(proveedor);
        dest.writeString(shield);
        dest.writeString(stadium);
        dest.writeString(img_stadium);
        dest.writeValue(category);
        dest.writeValue(squad);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Equipo> CREATOR = new Parcelable.Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };
}