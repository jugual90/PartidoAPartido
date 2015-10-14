package com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class TeamDetail implements Parcelable {
    private Equipo team;

    public TeamDetail() {
    }

    public TeamDetail(Equipo team) {
        this.team = team;
    }

    public Equipo getTeam() {
        return team;
    }

    public void setTeam(Equipo team) {
        this.team = team;
    }

    protected TeamDetail(Parcel in) {
        team = (Equipo) in.readValue(Equipo.class.getClassLoader());
    }



    @SuppressWarnings("unused")
    public static final Creator<TeamDetail> CREATOR = new Parcelable.Creator<TeamDetail>() {
        @Override
        public TeamDetail createFromParcel(Parcel parcel) {
            TeamDetail equipo = new TeamDetail();
            equipo.team = (Equipo) parcel.readValue(Equipo.class.getClassLoader());

            return equipo;
        }

        @Override
        public TeamDetail[] newArray(int size) {
            return new TeamDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(team);
    }
}
