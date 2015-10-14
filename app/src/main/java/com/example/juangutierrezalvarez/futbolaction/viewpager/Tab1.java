package com.example.juangutierrezalvarez.futbolaction.viewpager;

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
public class Tab1 extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_clasificacion_list,container,false);


        return v;


    }
}