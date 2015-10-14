package com.example.juangutierrezalvarez.futbolaction.fragments;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.CompeticionesViewAdapter;
import com.example.juangutierrezalvarez.futbolaction.model.Competicion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompeticionesListFragment extends Fragment
{
    private final String URL = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=leagues&key=29e84b2983e471c912f660674f66d887&top=1&year=2015";
    private ProgressBar mProgressBar;

    public CompeticionesViewAdapter adapter;
    RecyclerView recyclerView;
    List<Competicion> competicionesJSON =  new ArrayList<>();

    public CompeticionesListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_competiciones_list, container, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        recyclerView = (RecyclerView) view.findViewById(R.id.myList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(adapter);
        new MyJSONAsyncTask().execute(URL);

    }

    public class MyJSONAsyncTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            setLoading(true);
        }

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
                    JSONObject respuestaJSON = new JSONObject(respuesta);
                    JSONArray arrayJSON = respuestaJSON.getJSONArray("league");


                    for (int i = 0; i < arrayJSON.length(); i++)
                    {
                        Competicion competicion;
                        String id = arrayJSON.getJSONObject(i).getString("id");
                        String nombre = arrayJSON.getJSONObject(i).getString("name");
                        String logo = arrayJSON.getJSONObject(i).getString("logo");
                        String bandera_pais = arrayJSON.getJSONObject(i).getString("flag");
                        String pais = arrayJSON.getJSONObject(i).getString("country");

                        if (!pais.equals("ue") && !pais.equals("n2"))
                        {
                            competicion = new Competicion(id, nombre, logo, bandera_pais, pais);
                            competicionesJSON.add(competicion);
                        }
                    }

                    Collections.sort(competicionesJSON, new Comparator<Competicion>() {
                        @Override
                        public int compare(Competicion a, Competicion b) {

                            return a.getPais().compareToIgnoreCase(b.getPais());
                        }
                    });

                    setLoading(false);
                    adapter = new CompeticionesViewAdapter(getActivity(), competicionesJSON);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

    private void setLoading(boolean cargando)
    {
        if (cargando)
        {
            mProgressBar.setVisibility(View.VISIBLE);
        }else
        {
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
