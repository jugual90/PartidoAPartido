package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.fragments.CompeticionFragment;
import com.example.juangutierrezalvarez.futbolaction.model.Competicion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class CompeticionesViewAdapter extends RecyclerView.Adapter<CompeticionesViewAdapter.ListCompeticionViewHolder>
{
    private List<Competicion> items;
    private Context context;
    private Fragment mFragment;
    public List<Fragment> fragmentoInicialViewPager = new ArrayList<>();

    public CompeticionesViewAdapter(Context context, List<Competicion> competiciones)
    {
        if (competiciones == null)
        {
            throw new IllegalArgumentException("No se pueden recuperar las Competiciones");
        }
        items = competiciones;
        this.context = context;
    }

    @Override
    public ListCompeticionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.competiciones_item, viewGroup, false);
        return new ListCompeticionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListCompeticionViewHolder viewHolder, final int position)
    {
        final Competicion competicion = items.get(position);
        Picasso.with(context).load(competicion.getBandera_pais()).into(viewHolder.ivPais);
        viewHolder.tvNombre.setText(competicion.getNombre());
        Picasso.with(context).load(competicion.getLogo()).into(viewHolder.ivLogo);

        final String id = competicion.getId();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                CompeticionFragment competicionFragment = new CompeticionFragment(id);
                ft.replace(R.id.flClasificacion, competicionFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                //ft.addToBackStack("detallePartido");
                ft.commit();
            }


        });

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    public class ListCompeticionViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPais;
        TextView tvNombre;
        ImageView ivLogo;

        public ListCompeticionViewHolder(final View itemView)
        {
            super(itemView);
            ivPais = (ImageView) itemView.findViewById(R.id.ivPais);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreLiga);
            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
        }

    }

}
