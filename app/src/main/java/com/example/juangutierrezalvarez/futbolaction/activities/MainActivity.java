package com.example.juangutierrezalvarez.futbolaction.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.MyAdapter;
import com.example.juangutierrezalvarez.futbolaction.fragments.DetalleEquipoListFragment;
import com.example.juangutierrezalvarez.futbolaction.fragments.DirectoListFragmentRetrofit;
import com.example.juangutierrezalvarez.futbolaction.fragments.FichajesListFragment;
import com.example.juangutierrezalvarez.futbolaction.fragments.MarcadorListFragment;


public class MainActivity extends ActionBarActivity
{
    //Declaramos los titulos y los iconos para el navigation drawer en un array

    String TITLES[] = {"Partidos del dia", "En Directo", "Ligas Europeas ", "Ligas América", "Fichajes"};
    int ICONS[] = {R.drawable.ic_calendario, R.drawable.ic_endirecto, R.drawable.ic_europa, R.drawable.ic_ligaamerica, R.drawable.ic_botafutbol};

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    //Creamos los recursos de la cabecera, Texview y para la imagen

    String NAME = "";
    String EMAIL = "";
    int PROFILE; //= R.drawable.ic_action;
    Context CONTEXT;

    //private Toolbar toolbar;                              // Decaramos el objeto toolbar

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToggle;
    ActionBarDrawerToggle mDrawerToggle2;                  // Declaring Action Bar Drawer Toggle
    private View v;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Futbol España");
        actionBar.setSubtitle("Live");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)//Para los que no tengan lollipop

            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar));
//            getWindow().setNavigationBarColor(getResources().getColor(R.color.statusbar));



        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); //inflamos la vista del recycler view

        mRecyclerView.setHasFixedSize(true);                            // decimos al sistema que los objetos de la lista son de tamaño fijo

        mAdapter = new MyAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE, this);     // Crear el adaptador de la clase MyAdapter (que vamos a ver en un momento)
        // Y pasando los títulos , iconos , imagen header

        mRecyclerView.setAdapter(mAdapter);  //configuramos el recyclerview

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener()
        {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });



        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
        {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());



                if (child == null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    /*MarcadorListFragment marcadorListFragment = new MarcadorListFragment();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.flClasificacion,marcadorListFragment);
                    ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft3.commitAllowingStateLoss();
*/
                    return true;


                }


                if (child == recyclerView.getChildAt(1) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    MarcadorListFragment marcadorListFragment = new MarcadorListFragment();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.flClasificacion,marcadorListFragment);
                    ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft3.commitAllowingStateLoss();

                    return true;

                }

                if (child == recyclerView.getChildAt(2) && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    DirectoListFragmentRetrofit directoListFragmentRetrofit = new DirectoListFragmentRetrofit();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.flClasificacion, directoListFragmentRetrofit);
                    ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft4.commitAllowingStateLoss();


                    return true;

                }

                if ( child == recyclerView.getChildAt(3) && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    Intent ligas = new Intent(MainActivity.this,LigasActivity.class);
                    MainActivity.this.startActivity(ligas);


                    return true;

                }

                if ( child == recyclerView.getChildAt(4) && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                   /* CompeticionesListFragment competicionesListFragment = new CompeticionesListFragment();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.flClasificacion, competicionesListFragment);
                    ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft4.commitAllowingStateLoss();*/

                    DetalleEquipoListFragment detalleEquipoListFragment = new DetalleEquipoListFragment();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.flClasificacion, detalleEquipoListFragment);
                    ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft4.commitAllowingStateLoss();



                    return true;

                }
                if ( child == recyclerView.getChildAt(5) && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    FichajesListFragment fichajesListFragment = new FichajesListFragment();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.flClasificacion, fichajesListFragment);
                    ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft4.commitAllowingStateLoss();

                    return true;

                }

                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)

            {

            }
        });


        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed

                mDrawerToggle.setDrawerIndicatorEnabled(true);
                Drawer.setDrawerListener(mDrawerToggle);

            }


        };

        // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State


        MarcadorListFragment marcadorListFragment = new MarcadorListFragment();
        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
        ft3.replace(R.id.flClasificacion,marcadorListFragment);
        ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft3.commitAllowingStateLoss();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //para cerrar el drawer con la flecha
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == android.R.id.home)
        {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        if (id == R.id.info)
        {
            startActivity(new Intent(this, infoActivity.class));
        }

        if (id == R.id.directo)
        {
            DirectoListFragmentRetrofit directoListFragmentRetrofit = new DirectoListFragmentRetrofit();
            FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
            ft4.replace(R.id.flClasificacion, directoListFragmentRetrofit);
            ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft4.commitAllowingStateLoss();


        }

        return super.onOptionsItemSelected(item);
    }
}
