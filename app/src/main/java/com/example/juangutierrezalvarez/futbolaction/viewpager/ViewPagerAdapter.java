package com.example.juangutierrezalvarez.futbolaction.viewpager;

/**
 * Created by Juan Gutierrez on 24/06/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.juangutierrezalvarez.futbolaction.R;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragment;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragment2;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentBundesliga;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentLigue1;
import com.example.juangutierrezalvarez.futbolaction.fragments.ClasificacionListFragmentPremier;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    int idView;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, int idView) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.idView = idView;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();
        switch (idView)
        {
            case R.id.espana:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment tab1 = new ClasificacionListFragment();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.english:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentPremier tab1 = new ClasificacionListFragmentPremier();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.german:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentBundesliga tab1 = new ClasificacionListFragmentBundesliga();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.francia:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentLigue1 tab1 = new ClasificacionListFragmentLigue1();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.italia:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentLigue1 tab1 = new ClasificacionListFragmentLigue1();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.portugal:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentLigue1 tab1 = new ClasificacionListFragmentLigue1();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;

            case R.id.holanda:
                if(position == 0) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragmentLigue1 tab1 = new ClasificacionListFragmentLigue1();
                    fragment = tab1;
                }
                if(position == 1) // if the position is 0 we are returning the First tab
                {
                    ClasificacionListFragment2 tab2 = new ClasificacionListFragment2();
                    fragment = tab2;
                }
                break;



        }

       return fragment;


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}