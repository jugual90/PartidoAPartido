package com.example.juangutierrezalvarez.futbolaction.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.FichajesAdapter;
import com.example.juangutierrezalvarez.futbolaction.interfaces.Futbol_interface;
import com.example.juangutierrezalvarez.futbolaction.model.Leagues;
import com.example.juangutierrezalvarez.futbolaction.retrofit.ServiceGenerator;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class FichajesListFragment extends ListFragment
{
    public static  final String  APIURL = "http://www.resultados-futbol.com/scripts/api";
    public static  final String  KEY = "29e84b2983e471c912f660674f66d887";
    public static  final String  JSON = "json";

    private Futbol_interface futbol_interface;


    private ProgressBar mProgressBar;
    private FichajesAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view =   inflater.inflate(R.layout.fragment_fichaje_list,container,false);

       //inicializar interface
        futbol_interface = ServiceGenerator.createService(Futbol_interface.class,APIURL);
        futbol_interface.getFichajes2("Europe/Madrid", JSON, "transfer_leagues", KEY, new Callback<Leagues>() {


            @Override
            public void success(Leagues leagues, Response response)
            {
                mAdapter = new FichajesAdapter(getActivity(), leagues.getLeagues());
                setListAdapter(mAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

                Log.i("futbol", "error : " + error.getMessage());
            }
        });

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        mProgressBar = (ProgressBar) getView().findViewById(R.id.progressBar1);
        setListAdapter(mAdapter);

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


}