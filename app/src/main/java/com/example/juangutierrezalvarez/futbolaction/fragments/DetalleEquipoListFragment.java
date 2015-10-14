package com.example.juangutierrezalvarez.futbolaction.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.DetalleEquipoAdapter;
import com.example.juangutierrezalvarez.futbolaction.interfaces.Futbol_interface;
import com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo.TeamDetail;
import com.example.juangutierrezalvarez.futbolaction.retrofit.ServiceGenerator;
import com.example.juangutierrezalvarez.futbolaction.utils.Utilidades;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class DetalleEquipoListFragment extends ListFragment
{

    public static  final String  APIURL = "http://www.resultados-futbol.com/scripts/api";
    public static  final String  KEY = "29e84b2983e471c912f660674f66d887";
    public static  final String  JSON = "json";

    private Futbol_interface futbol_interface;


    private ProgressBar mProgressBar;
    private DetalleEquipoAdapter mAdapter;



    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view =   inflater.inflate(R.layout.fragment_fichaje_list,container,false);

        //inicializar interface
        futbol_interface = ServiceGenerator.createService(Futbol_interface.class, APIURL);
        futbol_interface.getDetalleEquipo("Europe/Madrid", JSON, "team", KEY, "2107", new Callback<TeamDetail>() {


            @Override
            public void success(TeamDetail teamDetail, Response response) {
                String json=Utilidades.getDataFromResponse(response);
                mAdapter = new DetalleEquipoAdapter(getActivity(), teamDetail);
                setListAdapter(mAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

                Log.i("futbol", "error : " + error.getMessage());
                Toast.makeText(getActivity(), "No hay detalle de equipo disponible", Toast.LENGTH_LONG).show();
            }
        });


        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
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


