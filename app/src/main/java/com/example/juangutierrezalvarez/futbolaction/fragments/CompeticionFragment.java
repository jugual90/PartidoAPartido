package com.example.juangutierrezalvarez.futbolaction.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.example.juangutierrezalvarez.futbolaction.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class CompeticionFragment extends Fragment
{
    private String URL = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=tables&key=29e84b2983e471c912f660674f66d887&group=1";
    public String identifier;
    public TextView tvEquipo;
    public TextView tvPuntos;
    public TextView tvGanados;
    public TextView tvEmpatados;
    public TextView tvPerdidos;
    public TextView tvGolesFavor;
    public TextView tvGolesContra;
    public TextView tvAverage;
    public TableLayout tl;
    public TableRow tr;

    public CompeticionFragment(String id)
    {
        this.identifier = id;
        URL = URL + "&league=" + identifier;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.competicion_table_layout, container, false);

        tl = (TableLayout) view.findViewById(R.id.tlClasificacion);
        new MyJSONAsyncTask().execute(URL);
        return view;
    }

    public class MyJSONAsyncTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            java.net.URL url;
            try
            {
                url = new java.net.URL(params[0]);
                HttpURLConnection peticion = (HttpURLConnection) url.openConnection();
                if (peticion.getResponseCode() == HttpURLConnection.HTTP_OK)
                {
                    StringBuilder respuesta = new StringBuilder();
                    BufferedReader input = new BufferedReader(new InputStreamReader(peticion.getInputStream()), 8192);
                    String strLine = null;
                    while ((strLine = input.readLine()) != null)
                    {
                        respuesta.append(strLine);
                    }
                    input.close();
                    return respuesta.toString();
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String respuesta)
        {
            if (respuesta != null)
            {
                try
                {
                    StringBuilder sb = new StringBuilder();
                    JSONObject respuestaJSON = new JSONObject(respuesta);
                    JSONArray arrayJSON = respuestaJSON.getJSONArray("table");

                    for (int i = 0; i < arrayJSON.length(); i++)
                    {
                        tr = new TableRow(getActivity());
                        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                        tr.setLayoutParams(lp);

                        tvEquipo = new TextView(getActivity());

                        tvPuntos = new TextView(getActivity());
                        tvGanados = new TextView(getActivity());
                        tvEmpatados = new TextView(getActivity());
                        tvPerdidos = new TextView(getActivity());
                        tvGolesFavor = new TextView(getActivity());
                        tvGolesContra = new TextView(getActivity());
                        tvAverage = new TextView(getActivity());

                        tvEquipo.setText(arrayJSON.getJSONObject(i).getString("team"));
                        tvPuntos.setText(arrayJSON.getJSONObject(i).getString("points"));
                        String ganados = String.valueOf(arrayJSON.getJSONObject(i).getInt("wins"));
                        tvGanados.setText(ganados);
                        String empatados = String.valueOf(arrayJSON.getJSONObject(i).getInt("draws"));
                        tvEmpatados.setText(empatados);
                        String perdidos = String.valueOf(arrayJSON.getJSONObject(i).getInt("losses"));
                        tvPerdidos.setText(perdidos);
                        tvGolesFavor.setText(arrayJSON.getJSONObject(i).getString("gf"));
                        tvGolesContra.setText(arrayJSON.getJSONObject(i).getString("ga"));
                        String average = String.valueOf(arrayJSON.getJSONObject(i).getInt("avg"));
                        tvAverage.setText(average);

                        tr.addView(tvEquipo);
                        tr.addView(tvPuntos);
                        tr.addView(tvGanados);
                        tr.addView(tvEmpatados);
                        tr.addView(tvPerdidos);
                        tr.addView(tvGolesFavor);
                        tr.addView(tvGolesContra);
                        tr.addView(tvAverage);

                        tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    }

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

}
