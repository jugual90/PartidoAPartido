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
import com.example.juangutierrezalvarez.futbolaction.adapters.ClasificacionAdapter;
import com.example.juangutierrezalvarez.futbolaction.model.Clasificacion;
import com.example.juangutierrezalvarez.futbolaction.model.Table;
import com.example.juangutierrezalvarez.futbolaction.utils.UrlsClasificaciones;
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
public class ClasificacionListFragment extends ListFragment
{
                                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=tables&key=29e84b2983e471c912f660674f66d887&league=1&group=1
    private final String URL="http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=tables&key=29e84b2983e471c912f660674f66d887&league=1&group=1";
    private ProgressBar mProgressBar;
    private ClasificacionAdapter mAdapter;


    boolean mDualPane;
    int currentPosition;
    List<Clasificacion> clasificacionJSON;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_clasificacion_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        mProgressBar = (ProgressBar) getView().findViewById(R.id.progressBar1);
        setListAdapter(mAdapter);

        new MyJSONAsyntask().execute(UrlsClasificaciones.URLSpain);

        /*View detailsFrame = getActivity().findViewById(R.id.flClasificacionWeb);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeb(currentPosition);
        }
*/
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        showWeb(position);
    }


    private void showWeb(int position)
    {
       /* currentPosition = position;

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


    //visibilidad de la progress bar
    private void setLoading(boolean loading)
    {
        if (loading) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }

    }

    private  List<Clasificacion> getClasificacion(String json)
    {
        Gson gson = new Gson();
        Table table = gson.fromJson(json,Table.class);

        return new ArrayList(Arrays.asList(table.getTable()));
    }


    private class MyJSONAsyntask  extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute()
        {
            setLoading(true);

        }



        @Override
        protected String doInBackground(String... params)
        {

            return getInputStream(params[0]);
        }

        private String getInputStream(String url)
        {

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
                clasificacionJSON = getClasificacion(json);
                mAdapter = new ClasificacionAdapter(getActivity(), clasificacionJSON);
                setListAdapter(mAdapter);
            }

            if (json == null)
            {
                Toast.makeText(getActivity(), "OCURRIO UN ERROR INESPERADO", Toast.LENGTH_SHORT).show();
            }
        }


    }


}
