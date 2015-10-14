package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.model.Fichajes;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Juan Gutierrez on 30/06/2015.
 */
public class FichajesAdapter extends BaseAdapter {

    private Context context;
    private List<Fichajes> items;

    public FichajesAdapter(Context context, List<Fichajes> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //inflamos el layout correspondiente
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fichajes,parent,false);

        ImageView ivEscudo = (ImageView) view.findViewById(R.id.ivEscudo);
        TextView tvNombreEquipo = (TextView) view.findViewById(R.id.tvNombreEquipo);
        TextView tvPrecioTraspaso = (TextView) view.findViewById(R.id.tvPrecioTraspaso);
        TextView tvNomJugador1 = (TextView) view.findViewById(R.id.tvNomJugador1);
        TextView tvNomJugador2 = (TextView) view.findViewById(R.id.tvNomJugador2);
        TextView tvNomJugador3 = (TextView) view.findViewById(R.id.tvNomJugador3);


        ImageView ivLlegadas = (ImageView) view.findViewById(R.id.ivLlegadas);
        ImageView ivSalidas = (ImageView) view.findViewById(R.id.ivSalidas);
        ImageView ivRumores = (ImageView) view.findViewById(R.id.ivRumores);



        Fichajes item = this.items.get(position);


        if ( item != null)
        {
            tvNombreEquipo.setText(item.getName());
            tvPrecioTraspaso.setText(item.getValue_transfers());
            tvNomJugador1.setText(item.getTransfers().getArrivals().getName());
            tvNomJugador2.setText(item.getTransfers().getDepartures().getName());
            tvNomJugador3.setText(item.getTransfers().getRumors().getName());

            if ( item.getShield() != null)
            {
                Picasso.with(context).load(item.getShield()).into(ivEscudo);
            }

            if ( item.getTransfers().getArrivals().getPicture() != null)
            {
                Picasso.with(context).load(item.getTransfers().getArrivals().getPicture()).into(ivLlegadas);
            }

            if ( item.getTransfers().getDepartures().getPicture() != null)
            {
                Picasso.with(context).load(item.getTransfers().getDepartures().getPicture()).into(ivSalidas);
            }

            if ( item.getTransfers().getRumors().getPicture() != null)
            {
                Picasso.with(context).load(item.getTransfers().getRumors().getPicture()).into(ivRumores);
            }
        }


        return view;
    }
}
