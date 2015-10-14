package com.example.juangutierrezalvarez.futbolaction.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.juangutierrezalvarez.futbolaction.R;

/**
 * Created by Juan Gutierrez on 02/07/2015.
 */
public class ErrorDirectoAdapter extends BaseAdapter
{
    private Context context;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.directo_item,parent,false);


        return view;
    }
}
