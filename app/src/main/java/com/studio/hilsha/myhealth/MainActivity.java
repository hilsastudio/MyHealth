package com.studio.hilsha.myhealth;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();

        }
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragmentList(new BMI(), "BMI");
        adapter.addFragmentList(new IBW(), "IBW");
        adapter.addFragmentList(new BFP(),"BFP");
        adapter.addFragmentList(new WTHR(), "WTHR");
        viewPager.setAdapter(adapter);
        //viewPager.setOnPageChangeListener(mypageListener);
        ViewPager.OnPageChangeListener mypageListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    setActionBarTitle("Body Mass Index");
                }else if(position==1){
                    setActionBarTitle("Ideal Body Weight");
                }else if(position==2){
                    setActionBarTitle("Body Fat Percentage");
                }else if(position==3){
                    setActionBarTitle("Weist to Height Ratio");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.setOnPageChangeListener(mypageListener);
    }

    private void setActionBarTitle(String s) {
        getSupportActionBar().setTitle(s);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentlist = new ArrayList<Fragment>();
        private final List<String> fragmentTitleList = new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
          /*  if(position==0){
                setActionBarTitle("Body Mass Index");
            }else if(position==1){
                setActionBarTitle("Ideal Body Weight");
            }else if(position==2){
                setActionBarTitle("Body Fat Percentage");
            }else if(position==3){
                setActionBarTitle("Weist to Height Ratio");
            }
*/
            return fragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return fragmentlist.size();
        }
        public void addFragmentList(Fragment fm,String title){
            fragmentlist.add(fm);
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

                        return  fragmentTitleList.get(position);


        }
    }

}
