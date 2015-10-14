package com.example.juangutierrezalvarez.futbolaction.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.adapters.MyAdapter;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragment;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragment2;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentBundesliga;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentLigue1;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentPremier;
import com.example.juangutierrezalvarez.futbolaction.fragments.DirectoListFragmentRetrofit;
import com.example.juangutierrezalvarez.futbolaction.viewpager.SlidingTabLayout;
import com.example.juangutierrezalvarez.futbolaction.viewpager.ViewPagerAdapter;

public class LigasActivity extends ActionBarActivity implements View.OnClickListener
{
    //Declaramos los titulos y los iconos para el navigation drawer en un array

    String TITLES[] = {"Liga BBVA","Liga Adelante", "Premier Ligue", "Bundesliga", "Ligue 1", "Atras"};
    int ICONS[] = {R.drawable.ic_logolfp,R.drawable.ic_logo_liga_adelante ,R.drawable.ic_premier_league_logo, R.drawable.ic_bundesliga1, R.drawable.ic_ligue_1, R.drawable.ic_boton_volver};

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
    ImageButton button;

    ActionBarDrawerToggle mDrawerToggle;
    ActionBarDrawerToggle mDrawerToggle2;                  // Declaring Action Bar Drawer Toggle

    //viewpager
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    //Nombres de los tabs en viewpager
    CharSequence Titles[]={"Liga LFP","Liga adelante"};
    CharSequence TitlesInglaterra[]={"Premier League","Football League Championship"};
    CharSequence TitlesAlemania[]={"Bundesliga","2.Bundesliga"};
    CharSequence TitlesFrancia[]={"Ligue 1","Ligue 2"};
    CharSequence TitlesItalia[]={" Serie A Lega Calcio"," Serie B"};
    CharSequence TitlesPortugal[]={"Primeira Liga","II Divisão"};
    CharSequence TitlesHolanda[]={"Erevidise","Eerste Divisie"};
    int Numboftabs =2;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligas);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Clasificaciones");
        actionBar.setSubtitle("Ligas Europeas");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)//Para los que no tengan lollipop

            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.statusbar));

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tabbar);
        //declaracion de botones
        linearLayout.findViewById(R.id.espana).setOnClickListener(this);
        linearLayout.findViewById(R.id.english).setOnClickListener(this);
        linearLayout.findViewById(R.id.german).setOnClickListener(this);
        linearLayout.findViewById(R.id.francia).setOnClickListener(this);
        linearLayout.findViewById(R.id.italia).setOnClickListener(this);
        linearLayout.findViewById(R.id.portugal).setOnClickListener(this);
        linearLayout.findViewById(R.id.holanda).setOnClickListener(this);





        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Toast.makeText(LigasActivity.this, "AAAA", Toast.LENGTH_LONG).show();
                ClasificacionListFragmentLigue1 clasificacionListFragmentLigue1 = new ClasificacionListFragmentLigue1();
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.flClasificacion, clasificacionListFragmentLigue1);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft1.commitAllowingStateLoss();
            }
        });*/


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); //inflamos la vista del recycler view

        mRecyclerView.setHasFixedSize(true);                            // decimos al sistema que los objetos de la lista son de tamaño fijo

        mAdapter = new MyAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE, this);     // Crear el adaptador de la clase MyAdapter (que vamos a ver en un momento)
        // Y pasando los títulos , iconos , imagen header

        mRecyclerView.setAdapter(mAdapter);  //configuramos el recyclerview

        final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
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

                    ClasificacionListFragment clasificacionListFragment = new ClasificacionListFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flClasificacion, clasificacionListFragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commitAllowingStateLoss();

                    return true;

                }

                if (child == recyclerView.getChildAt(2) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    ClasificacionListFragment2 clasificacionListFragment2 = new ClasificacionListFragment2();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flClasificacion, clasificacionListFragment2);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();

                    return true;

                }

                if (child == recyclerView.getChildAt(3) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    ClasificacionListFragmentPremier clasificacionListFragmentPremier = new ClasificacionListFragmentPremier();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flClasificacion, clasificacionListFragmentPremier);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commitAllowingStateLoss();

                    return true;

                }


                if (child == recyclerView.getChildAt(4) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    ClasificacionListFragmentBundesliga clasificacionListFragmentBundesliga = new ClasificacionListFragmentBundesliga();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flClasificacion, clasificacionListFragmentBundesliga);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commitAllowingStateLoss();

                    return true;

                }

                if (child == recyclerView.getChildAt(5) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    ClasificacionListFragmentLigue1 clasificacionListFragmentLigue1 = new ClasificacionListFragmentLigue1();
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.flClasificacion, clasificacionListFragmentLigue1);
                    ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft1.commitAllowingStateLoss();

                    return true;

                }
                if (child == recyclerView.getChildAt(6) && mGestureDetector.onTouchEvent(motionEvent))
                {
                    Drawer.closeDrawers();

                    Intent ligas = new Intent(LigasActivity.this,MainActivity.class);
                    LigasActivity.this.startActivity(ligas);



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

        //carga al empezar la actividad
        ClasificacionListFragmentLigue1 clasificacionListFragmentLigue1 = new ClasificacionListFragmentLigue1();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.flClasificacion, clasificacionListFragmentLigue1);
        ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft1.commitAllowingStateLoss();

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
            //startActivity( new Intent(this, MainActivity.class));
            return true;

        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
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

    @Override
    public void onClick(View v)
    {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (v.getId())
        {

            case R.id.espana:

                //vista al iniciar VIEWPAGER
                // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs,R.id.espana);

                // Assigning ViewPager View and setting the adapter
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);

                // Assiging the Sliding Tab Layout View
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

                // Setting Custom Color for the Scroll bar indicator of the Tab View
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });


                // Setting the ViewPager For the SlidingTabsLayout
                tabs.setViewPager(pager);



                break;

            case R.id.english:

                /*ClasificacionListFragmentPremier clasificacionListFragmentPremier = new ClasificacionListFragmentPremier();
                ft.replace(R.id.flClasificacion, clasificacionListFragmentPremier);
                Log.i("boton ingles","");*/

                //vista al iniciar VIEWPAGER
                // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesInglaterra,Numboftabs, R.id.english);

                // Assigning ViewPager View and setting the adapter
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);

                // Assiging the Sliding Tab Layout View
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

                // Setting Custom Color for the Scroll bar indicator of the Tab View
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });

                // Setting the ViewPager For the SlidingTabsLayout
                tabs.setViewPager(pager);
                break;

            case R.id.german:
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesAlemania,Numboftabs, R.id.german);
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true);
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
                {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });

                tabs.setViewPager(pager);
                break;

            case R.id.francia:
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesFrancia,Numboftabs, R.id.francia);
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true);
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
                {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });

                tabs.setViewPager(pager);
                break;

            case R.id.italia:
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesItalia,Numboftabs, R.id.italia);
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true);
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
                {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });

                tabs.setViewPager(pager);
                break;

            case R.id.portugal:
                //Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show();
                //vista al iniciar VIEWPAGER
                // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesPortugal,Numboftabs,R.id.portugal);

                // Assigning ViewPager View and setting the adapter
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);

                // Assiging the Sliding Tab Layout View
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

                // Setting Custom Color for the Scroll bar indicator of the Tab View
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });


                // Setting the ViewPager For the SlidingTabsLayout
                tabs.setViewPager(pager);
                break;

            case R.id.holanda:
                adapter =  new ViewPagerAdapter(getSupportFragmentManager(),TitlesHolanda,Numboftabs, R.id.holanda);
                pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(adapter);
                tabs = (SlidingTabLayout) findViewById(R.id.tabs);
                tabs.setDistributeEvenly(true);
                tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
                {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.tabsScrollColor);
                    }
                });

                tabs.setViewPager(pager);
                break;

        }

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commitAllowingStateLoss();



    }
}
