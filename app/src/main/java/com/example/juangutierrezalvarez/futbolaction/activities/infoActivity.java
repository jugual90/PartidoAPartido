package com.example.juangutierrezalvarez.futbolaction.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.fragments.DirectoListFragment;

/**
 * Created by juangutierrezalvarez on 27/5/15.
 */
public class infoActivity extends ActionBarActivity
{

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        ActionBar actionBar = getSupportActionBar();

        // Cambiamos el título y el subtítulo del action bar. Por defecto el título es el mismo que
        // el de la actividad (atributo label en el manifest) y el subtítulo no se muestra.
        actionBar.setTitle("Aplicacion Master MIMO ");
        actionBar.setSubtitle("Juan Gutierrez Alvarez");
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)//Para los que no tengan lollipop

            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.statusbar));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == android.R.id.home)
        {
            startActivity( new Intent(this, MainActivity.class));

        }


        return super.onOptionsItemSelected(item);
    }



}


