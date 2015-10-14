package com.example.juangutierrezalvarez.futbolaction.viewpager;

/**
 * Created by Juan Gutierrez on 24/06/2015.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juangutierrezalvarez.futbolaction.R;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_clasificacion_list,container,false);




        return v;
    }
}