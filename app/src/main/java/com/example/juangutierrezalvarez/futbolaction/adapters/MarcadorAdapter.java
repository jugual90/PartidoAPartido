package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.model.Marcador;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by juangutierrezalvarez on 7/5/15.
 */
public class MarcadorAdapter extends BaseAdapter
{

    private Context context;
    private List<Marcador> items;

    public MarcadorAdapter(Context context, List<Marcador> items)
    {
        this.context = context;
        this.items = items;
    }



    @Override
    public int getCount()
    {
        return this.items.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //inflamos el layout correspondiente
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.marcador_item,parent,false);

        ImageView ivEscudo = (ImageView) view.findViewById(R.id.ivEscudo);
        ImageView ivEscudo2 = (ImageView) view.findViewById(R.id.ivEscudo2);
        TextView tvEquipo1 = (TextView) view.findViewById(R.id.tvEquipo1);
        TextView tvResultado= (TextView) view.findViewById(R.id.tvResultado);
        TextView tvEquipo2 = (TextView) view.findViewById(R.id.tvEquipo2);
        TextView tvCompetitionName = (TextView) view.findViewById(R.id.tvCompetitionName);
        TextView tvHour = (TextView) view.findViewById(R.id.tvHour);
        TextView tvMinute= (TextView) view.findViewById(R.id.tvMinute);
        TextView tvLiveMinute= (TextView) view.findViewById(R.id.tvLiveMinute);
        TextView tvExtraTxt= (TextView) view.findViewById(R.id.tvExtraTxt);


        Marcador item = this.items.get(position);

        if ( item != null)
        {
            tvEquipo1.setText(item.getLocal());
            tvEquipo2.setText(item.getVisitor());
            tvResultado.setText(item.getResult());
            tvCompetitionName.setText(item.getCompetition_name());
            tvHour.setText(item.getHour());
            tvMinute.setText(item.getMinute());
            tvLiveMinute.setText(item.getLive_minute());
            tvExtraTxt.setText(item.getExtraTxt());



            if ( item.getLocal_shield() != null)
            {
                Picasso.with(context).load(item.getLocal_shield()).into(ivEscudo);
            }
            if ( item.getVisitor_shield() != null)
            {
                Picasso.with(context).load(item.getVisitor_shield()).into(ivEscudo2);
            }
        }

        return view;
    }
}

