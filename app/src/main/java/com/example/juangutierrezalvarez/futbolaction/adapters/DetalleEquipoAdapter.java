package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.model.detalleEquipo.TeamDetail;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Juan Gutierrez on 01/07/2015.
 */
public class DetalleEquipoAdapter extends BaseAdapter {
    private Context context;
    private TeamDetail equipo;

    public DetalleEquipoAdapter(Context context, TeamDetail equipo) {
        this.context = context;
        this.equipo = equipo;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
        View view = inflater.inflate(R.layout.detalle_equipo,parent,false);

        CircleImageView ivEscudo = (CircleImageView) view.findViewById(R.id.circleViewEscudo);
        ImageView ivEstadio = (ImageView) view.findViewById(R.id.ivEstadio);
        TextView tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
        TextView tvLigaTemporada = (TextView) view.findViewById(R.id.tvLigaTemporada);
        TextView tvNombreClub = (TextView) view.findViewById(R.id.tvNombreClub);
        TextView tvNombrePresidente = (TextView) view.findViewById(R.id.tvNombrePresidente);




        if (equipo != null) {
            tvTitulo.setText(equipo.getTeam().getFullName());
            tvLigaTemporada.setText(equipo.getTeam().getCategory().getCompleteName());
            tvNombreClub.setText(equipo.getTeam().getFullName());
            tvNombrePresidente.setText(equipo.getTeam().getChairman());

            if (equipo.getTeam().getImg_stadium() != null) {
                Picasso.with(context).load(equipo.getTeam().getImg_stadium()).into(ivEstadio);
            }
            if (equipo.getTeam().getShield() != null) {
                Picasso.with(context).load(equipo.getTeam().getShield()).into(ivEscudo);
            }
        }

        return view;
    }
}