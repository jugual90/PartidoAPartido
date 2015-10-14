package com.example.juangutierrezalvarez.futbolaction.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.MarcadorAdapter;
import com.example.juangutierrezalvarez.futbolaction.model.Marcador;
import com.example.juangutierrezalvarez.futbolaction.model.TableMarcador;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */
public class MarcadorListFragment extends ListFragment
{                               //Solo ligas importantes europeas
                                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=matchsday&competitions=1,2,3,7,8,10,16,107,117&key=29e84b2983e471c912f660674f66d887
                                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=matchsday&key=29e84b2983e471c912f660674f66d887
                                //top=!
                                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=matchsday&top=1&key=29e84b2983e471c912f660674f66d887
    private final String URL = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=matchsday&key=29e84b2983e471c912f660674f66d887";
    private ProgressBar mProgressBar;
    private MarcadorAdapter mAdapter;

    boolean mDualPane;
    int currentPosition;
    List<Marcador> marcadorJSON;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_marcador, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mProgressBar = (ProgressBar) getView().findViewById(R.id.progressBar1);
        setListAdapter(mAdapter);

        new MyJSONAsyntask().execute(URL);

        /*View detailsFrame = getActivity().findViewById(R.id.flClasificacionWeb);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeb(currentPosition);
        }
        */
    }

    private void showWeb(int position)
    {
        currentPosition = position;
       /*
        if (mDualPane) {

            String url = "";
            if(clasificacionJSON!=null){
                url = clasificacionJSON.get(position).getShield();
            }

            ClasificacionWebFragment clasificacionWebFragment = ClasificacionWebFragment.newInstance(url);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.flClasificacionWeb, clasificacionWebFragment);

            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), ClasificacionWebActivity.class);
            intent.putExtra("url", clasificacionJSON.get(position).getShield());
            startActivity(intent);
        }*/

    }


    private List<Marcador> getMarcador(String json) //creo la lista que contendra el json
    {
        Gson gson = new Gson();
        TableMarcador tableMarcador = gson.fromJson(json, TableMarcador.class);

        if (tableMarcador.getMatches() == null )
        {
            Toast.makeText(getActivity(), "OCURRIO UN ERROR INESPERADO", Toast.LENGTH_SHORT).show();
        }

        return new ArrayList(Arrays.asList(tableMarcador.getMatches()));
    }


    private class MyJSONAsyntask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            setLoading(true);
        }

        @Override
        protected String doInBackground(String... params) {
            return getInputStream(params[0]);
        }


        private String getInputStream(String url) {

            HttpClient mHttpClient = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            try {
                HttpResponse response = mHttpClient.execute(request);
                BasicResponseHandler handler = new BasicResponseHandler();
                return handler.handleResponse(response);
            } catch (Exception e) {
                request.abort();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String json)
        {


            if (json != null) {
                setLoading(false);
                marcadorJSON = getMarcador(json);
                mAdapter = new MarcadorAdapter(getActivity(), marcadorJSON);
                setListAdapter(mAdapter);
            }

            if (json == null)
            {
                Toast.makeText(getActivity(), "OCURRIO UN ERROR INESPERADO", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private void setLoading(boolean loading)//visibilidad de progressbar
    {
        if (loading) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }

    }
}

