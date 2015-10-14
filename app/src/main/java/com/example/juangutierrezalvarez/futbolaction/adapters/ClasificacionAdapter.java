package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.model.Clasificacion;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */
public class ClasificacionAdapter extends BaseAdapter
{

    private Context context;
    private List<Clasificacion> items;

    public ClasificacionAdapter(Context context, List<Clasificacion> items) {
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
        View view = inflater.inflate(R.layout.clasificacion_item,parent,false);

        ImageView ivEquipo = (ImageView) view.findViewById(R.id.ivEscudo);
        TextView tvEquipo = (TextView) view.findViewById(R.id.tvEquipo);
        TextView tvPos = (TextView) view.findViewById(R.id.tvPos);
        TextView tvPoints = (TextView) view.findViewById(R.id.tvPoints);
        TextView tvRound = (TextView) view.findViewById(R.id.tvRound);
        TextView tvWins = (TextView) view.findViewById(R.id.tvWins);
        TextView tvDraws = (TextView) view.findViewById(R.id.tvDraws);
        TextView tvLosses = (TextView) view.findViewById(R.id.tvLosses);
        TextView tvGF = (TextView) view.findViewById(R.id.tvGF);
        TextView tvGA = (TextView) view.findViewById(R.id.tvGA);


        Clasificacion item = this.items.get(position);

        if ( item != null)
        {
            tvEquipo.setText(item.getTeam());
            tvPoints.setText(item.getPoints());
            tvPos.setText(item.getPos());
            tvRound.setText(item.getRound());
            tvWins.setText(item.getWins());
            tvDraws.setText(item.getDraws());
            tvLosses.setText(item.getLosses());
            tvGF.setText(item.getGf());
            tvGA.setText(item.getGa());



            if ( item.getShield() != null)
            {
                Picasso.with(context).load(item.getShield()).into(ivEquipo);
            }
        }

        return view;
    }


}
