package com.example.juangutierrezalvarez.futbolaction.interfaces;


import com.example.juangutierrezalvarez.futbolaction.model.Leagues;
import com.example.juangutierrezalvarez.futbolaction.model.PartidosDirectoRetrofit;
import com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo.TeamDetail;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public interface Futbol_interface
{
    //url para fichajes: ultima llegada, ultima salida y ultimo rumor
    @GET("/api.php?")
    void getFichajes2(@Query("tz") String tz, @Query("format") String format,@Query("req") String req , @Query("key") String key,   Callback<Leagues> callback);

    //url para fichajes: liga especifica por id
    @GET("/api.php?")
    void getFichajes3(@Query("tz") String tz, @Query("format") String format,@Query("req") String req , @Query("key") String key,@Query("id") String id,   Callback<Leagues> callback);

    @GET("/api.php?tz=Europe/Madrid&format=json&req=transfer_leagues&key=29e84b2983e471c912f660674f66d887")
    void getFichajes(Callback<Leagues> callback);

   //Partidos en directo
    @GET("/api.php?")
    void getDirecto(@Query("tz") String tz, @Query("format") String format,@Query("req") String req , @Query("key") String key, Callback<PartidosDirectoRetrofit> callback);

    //Detalle de equipo
    @GET("/api.php?")
    void getDetalleEquipo(@Query("tz") String tz, @Query("format") String format,@Query("req") String req , @Query("key") String key,@Query("id") String id, Callback<TeamDetail> callback);


}
