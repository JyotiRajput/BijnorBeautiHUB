package com.beauti.experthp.bijnorbeautihub;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.beauti.experthp.bijnorbeautihub.DataBaseHelper.DataBaseHelper1;
import com.beauti.experthp.bijnorbeautihub.DataBaseModel.BeautiSubServices;
import com.beauti.experthp.bijnorbeautihub.Fragment.OneFragment;
import com.beauti.experthp.bijnorbeautihub.Fragment.ThreeFragment;
import com.beauti.experthp.bijnorbeautihub.Fragment.TwoFragment;
import com.beauti.experthp.bijnorbeautihub.Model.BeautiPoints;
import com.beauti.experthp.bijnorbeautihub.Model.BeautyServices;

import java.util.ArrayList;
import java.util.List;

public class SelectionTab1 extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public int id_Point;
    private String[] point_Name;
    public Bundle bundle;
    private String title;
    private  int initial_Value=1;
   DataBaseHelper1 dataBaseHelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_tab1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dataBaseHelper1=new DataBaseHelper1(this);
        point_Name=getResources().getStringArray(R.array.beautipoint_title);
        id_Point = getIntent().getExtras().getInt("point_Id");
        title=point_Name[id_Point];
        id_Point=id_Point+initial_Value;
        setTitle(title);

Log.d("value of pointid", "is" + id_Point);
        Log.d("value of pointid", "is" + id_Point);
        Log.d("Beauty Points","Count is:  "+dataBaseHelper1.getALLPoint().size());
        Log.d("Beauty Points", "Count is:  " + dataBaseHelper1.getALLServices().size());
        Log.d("Beauty Points","Count is:  "+dataBaseHelper1.getSuService_Count());

/*
        dataBaseHelper1.delete_AllPoints();
        Log.d("Beauty Points","Count is:  "+dataBaseHelper1.getALLPoint().size());
        dataBaseHelper1.delete_Service();
        dataBaseHelper1.delete_Sub_Service();
        dataBaseHelper1.closeDB();*/

/*
    //create BeautyPoints
        BeautiPoints beautiPoint1=new BeautiPoints("AVI Beauty Parlor");
        BeautiPoints beautiPoint2=new BeautiPoints("Face to Face Beauty Parlor");
        BeautiPoints beautiPoint3=new BeautiPoints("Nisha Beauty Parlor");
        BeautiPoints beautiPoint4=new BeautiPoints("Saundarya Beauty Parlor");
        BeautiPoints beautiPoint5=new BeautiPoints("Mukta Beauty Parlor");
        BeautiPoints beautiPoint6=new BeautiPoints("Monika Beauty Parlor");
        BeautiPoints beautiPoint7=new BeautiPoints("Paras Beauty Parlor");
        BeautiPoints beautiPoint8=new BeautiPoints("Babe Beauty Parlor");
        BeautiPoints beautiPoint9=new BeautiPoints("Mahak Beauty Parlor");
        BeautiPoints beautiPoint10=new BeautiPoints("Bright Beauty Parlor");
        BeautiPoints beautiPoint11=new BeautiPoints("Niyati Beauty Parlor");
        BeautiPoints beautiPoint12=new BeautiPoints("Geeta Boutique and Beauty Parlor");
    //inserting BeautiPoint into db
        long beautiPointId_1= dataBaseHelper1.create_beauti_Point(beautiPoint1);
        long beautiPointId_2= dataBaseHelper1.create_beauti_Point(beautiPoint2);
        long beautiPointId_3= dataBaseHelper1.create_beauti_Point(beautiPoint3);
        long beautiPointId_4= dataBaseHelper1.create_beauti_Point(beautiPoint4);
        long beautiPointId_5= dataBaseHelper1.create_beauti_Point(beautiPoint5);
        long beautiPointId_6= dataBaseHelper1.create_beauti_Point(beautiPoint6);
        long beautiPointId_7= dataBaseHelper1.create_beauti_Point(beautiPoint7);
        long beautiPointId_8= dataBaseHelper1.create_beauti_Point(beautiPoint8);
        long beautiPointId_9= dataBaseHelper1.create_beauti_Point(beautiPoint9);
        long beautiPointId_10= dataBaseHelper1.create_beauti_Point(beautiPoint10);
        long beautiPointId_11= dataBaseHelper1.create_beauti_Point(beautiPoint11);
        long beautiPointId_12= dataBaseHelper1.create_beauti_Point(beautiPoint12);
        Log.d("Beauty Points","Count is:  "+dataBaseHelper1.getALLPoint().size());
        long [] beautiPointId_List=new long[]{beautiPointId_1,beautiPointId_2,beautiPointId_3,beautiPointId_4,beautiPointId_5,beautiPointId_6,beautiPointId_7,beautiPointId_8,beautiPointId_9,beautiPointId_10,beautiPointId_11,beautiPointId_12};
        
        //Create Beauty Services
        BeautyServices beautyService1=new BeautyServices("Hair Care");
        BeautyServices beautyService2=new BeautyServices("Skin Care");
        BeautyServices beautyService3=new BeautyServices("Hair Styling");
        BeautyServices beautyService4=new BeautyServices("Hand and Feet");
        BeautyServices beautyService5=new BeautyServices("Basic Care");
        BeautyServices beautyService6=new BeautyServices("Makeup");

    // Insert Beauty Services into db
        long beautyServiceId_1=dataBaseHelper1.create_beauti_Service(beautyService1);
        long beautyServiceId_2=dataBaseHelper1.create_beauti_Service(beautyService2);
        long beautyServiceId_3=dataBaseHelper1.create_beauti_Service(beautyService3);
        long beautyServiceId_4=dataBaseHelper1.create_beauti_Service(beautyService4);
        long beautyServiceId_5=dataBaseHelper1.create_beauti_Service(beautyService5);
        long beautyServiceId_6=dataBaseHelper1.create_beauti_Service(beautyService6);
        Log.d("Beauty Points","Count is:  "+dataBaseHelper1.getALLServices().size());
        long [] beautiServiceId_List=new long[]{beautyServiceId_1,beautyServiceId_2,beautyServiceId_3,beautyServiceId_4,beautyServiceId_5,beautyServiceId_6};

// Create Beauty SubServices_Haircare
         int[][] price_Array_HairCare=new int[12][];
        price_Array_HairCare[0]=new int[]{80,140,400,500,8000};
        price_Array_HairCare[1]=new int[]{60,150,430,510,7000};
        price_Array_HairCare[2]=new int[]{50,160,420,520,6000};
        price_Array_HairCare[3]=new int[]{40,170,400,530,5000};
        price_Array_HairCare[4]=new int[]{100,190,3600,540,4000};
        price_Array_HairCare[5]=new int[]{70,155,300,550,5500};
        price_Array_HairCare[6]=new int[]{87,145,330,515,6500};
        price_Array_HairCare[7]=new int[]{83,157,440,525,7500};
        price_Array_HairCare[8]=new int[]{92,185,440,535,6700};
        price_Array_HairCare[9]=new int[]{95,195,380,545,4400};
        price_Array_HairCare[10]=new int[]{85,165,370,4800,4700};
        price_Array_HairCare[11]=new int[]{84,157,399,490,6600};
        //price_Array_HairCare[12]=new int[]{86,166,357,499,6900};
        //inserting Beauty SubServices_Haircare into db
        for(int i=0;i<12;i++)
        {
            
                List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
                BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_HairCare[i][0],"Hair Wash");
                BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_HairCare[i][1],"Hair Color");
                BeautiSubServices beautiSubService3=new BeautiSubServices(price_Array_HairCare[i][2],"Hair Cut");
                BeautiSubServices beautiSubService4=new BeautiSubServices(price_Array_HairCare[i][3],"Hair Spa");
                BeautiSubServices beautiSubService5=new BeautiSubServices(price_Array_HairCare[i][4],"Hair Treatment");
                beautiSubServicesList.add(beautiSubService1);
                beautiSubServicesList.add(beautiSubService2);
                beautiSubServicesList.add(beautiSubService3);
                beautiSubServicesList.add(beautiSubService4);
                beautiSubServicesList.add(beautiSubService5);
                // Inserting beautiSubServicesList_HairCare into db
                long hair_care_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_1);
            Log.d("Beauty Points","Count is:  "+hair_care_RowId);
            
        }


// Create Beauty SubServices_Skincare
        int[][] price_Array_SkinCare=new int[12][];
        price_Array_SkinCare[0]=new int[]{80,140,400,500,8000};
        price_Array_SkinCare[1]=new int[]{60,150,430,510,7000};
        price_Array_SkinCare[2]=new int[]{50,160,420,520,6000};
        price_Array_SkinCare[3]=new int[]{40,170,400,530,5000};
        price_Array_SkinCare[4]=new int[]{100,190,3600,540,4000};
        price_Array_SkinCare[5]=new int[]{70,155,300,550,5500};
        price_Array_SkinCare[6]=new int[]{87,145,330,515,6500};
        price_Array_SkinCare[7]=new int[]{83,157,440,525,7500};
        price_Array_SkinCare[8]=new int[]{92,185,440,535,6700};
        price_Array_SkinCare[9]=new int[]{95,195,380,545,4400};
        price_Array_SkinCare[10]=new int[]{85,165,370,4800,4700};
        price_Array_SkinCare[11]=new int[]{84,157,399,490,6600};
        //price_Array_SkinCare[12]=new int[]{86,166,357,499,6900};
        //inserting Beauty SubServices_Skincare into db
        for(int i=0;i<12;i++)
        {

            List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
            BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_SkinCare[i][0],"Bleach");
            BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_SkinCare[i][1],"Clanup");
            BeautiSubServices beautiSubService3=new BeautiSubServices(price_Array_SkinCare[i][2],"Facial");
            BeautiSubServices beautiSubService4=new BeautiSubServices(price_Array_SkinCare[i][3],"Mask");
            BeautiSubServices beautiSubService5=new BeautiSubServices(price_Array_SkinCare[i][4],"Skin Treatment");
            beautiSubServicesList.add(beautiSubService1);
            beautiSubServicesList.add(beautiSubService2);
            beautiSubServicesList.add(beautiSubService3);
            beautiSubServicesList.add(beautiSubService4);
            beautiSubServicesList.add(beautiSubService5);
            // Inserting beautiSubServicesList_HairCare into db
            long Skin_care_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_2);

            Log.d("Beauty Points","Count is:  "+Skin_care_RowId);
        }

// Create Beauty SubServices_HairStyling
        int[][] price_Array_HairStyling=new int[12][];
        price_Array_HairStyling[0]=new int[]{80,140,400,500,8000};
        price_Array_HairStyling[1]=new int[]{60,150,430,510,7000};
        price_Array_HairStyling[2]=new int[]{50,160,420,520,6000};
        price_Array_HairStyling[3]=new int[]{40,170,400,530,5000};
        price_Array_HairStyling[4]=new int[]{100,190,3600,540,4000};
        price_Array_HairStyling[5]=new int[]{70,155,300,550,5500};
        price_Array_HairStyling[6]=new int[]{87,145,330,515,6500};
        price_Array_HairStyling[7]=new int[]{83,157,440,525,7500};
        price_Array_HairStyling[8]=new int[]{92,185,440,535,6700};
        price_Array_HairStyling[9]=new int[]{95,195,380,545,4400};
        price_Array_HairStyling[10]=new int[]{85,165,370,4800,4700};
        price_Array_HairStyling[11]=new int[]{84,157,399,490,6600};
        //price_Array_HairStyling[12]=new int[]{86,166,357,499,6900};

        //inserting Beauty SubServices_HairStyling into db
        for(int i=0;i<12;i++)
        {

            List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
            BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_HairStyling[i][0],"Hair Iron");
            BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_HairStyling[i][1],"Hair Straighting");
            BeautiSubServices beautiSubService3=new BeautiSubServices(price_Array_HairStyling[i][2],"Hair Smoothing");
            BeautiSubServices beautiSubService4=new BeautiSubServices(price_Array_HairStyling[i][3],"Hair Rebonding");
            BeautiSubServices beautiSubService5=new BeautiSubServices(price_Array_HairStyling[i][4],"Hair Tongs");
            beautiSubServicesList.add(beautiSubService1);
            beautiSubServicesList.add(beautiSubService2);
            beautiSubServicesList.add(beautiSubService3);
            beautiSubServicesList.add(beautiSubService4);
            beautiSubServicesList.add(beautiSubService5);
            // Inserting beautiSubServicesList_HairCare into db
            long hair_Style_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_3);

            Log.d("Beauty Points","Count is:  "+hair_Style_RowId);

        }

// Create Beauty SubServices_Hand_FeetCare
        int[][] price_Array_Hand_FeetCare=new int[12][];
        price_Array_Hand_FeetCare[0]=new int[]{80,140};
        price_Array_Hand_FeetCare[1]=new int[]{60,150};
        price_Array_Hand_FeetCare[2]=new int[]{50,160};
        price_Array_Hand_FeetCare[3]=new int[]{40,170};
        price_Array_Hand_FeetCare[4]=new int[]{100,190};
        price_Array_Hand_FeetCare[5]=new int[]{70,155};
        price_Array_Hand_FeetCare[6]=new int[]{87,145};
        price_Array_Hand_FeetCare[7]=new int[]{83,157};
        price_Array_Hand_FeetCare[8]=new int[]{92,185};
        price_Array_Hand_FeetCare[9]=new int[]{95,195};
        price_Array_Hand_FeetCare[10]=new int[]{85,165};
        price_Array_Hand_FeetCare[11]=new int[]{84,157};
        //price_Array_Hand_FeetCare[12]=new int[]{86,166,357,499,6900};

        //inserting Beauty SubServices_Hand_Feet_Care into db
        for(int i=0;i<12;i++)
        {

            List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
            BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_Hand_FeetCare[i][0],"Manicure");
            BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_Hand_FeetCare[i][1],"Padicure");
            beautiSubServicesList.add(beautiSubService1);
            beautiSubServicesList.add(beautiSubService2);
            // Inserting beautiSubServicesList_HairCare into db
            long hand_Deet_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_4);
Log.e("row ","id is: "+hand_Deet_RowId);
        }

// Create Beauty SubServices_BasicCare
        int[][] price_Array_Basic_Care=new int[12][];
        price_Array_Basic_Care[0]=new int[]{80,140};
        price_Array_Basic_Care[1]=new int[]{60,150};
        price_Array_Basic_Care[2]=new int[]{50,160};
        price_Array_Basic_Care[3]=new int[]{40,170};
        price_Array_Basic_Care[4]=new int[]{100,190};
        price_Array_Basic_Care[5]=new int[]{70,155};
        price_Array_Basic_Care[6]=new int[]{87,145};
        price_Array_Basic_Care[7]=new int[]{83,157};
        price_Array_Basic_Care[8]=new int[]{92,185};
        price_Array_Basic_Care[9]=new int[]{95,195};
        price_Array_Basic_Care[10]=new int[]{85,165};
        price_Array_Basic_Care[11]=new int[]{84,157};
        //price_Array_Basic_Care[12]=new int[]{86,166,357,499,6900};

        //inserting Beauty SubServices_BasicCare into db
        for(int i=0;i<12;i++)
        {

            List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
            BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_Basic_Care[i][0],"Threading");
            BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_Basic_Care[i][1],"Waxing");
            beautiSubServicesList.add(beautiSubService1);
            beautiSubServicesList.add(beautiSubService2);
            // Inserting beautiSubServicesList_HairCare into db
            long Basic_care_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_5);
            Log.e("row ","id is: "+Basic_care_RowId);
        }


// Create Beauty SubServices_makeup
        int[][] price_Array_Makeup=new int[12][];
        price_Array_Makeup[0]=new int[]{80,140};
        price_Array_Makeup[1]=new int[]{60,150};
        price_Array_Makeup[2]=new int[]{50,160};
        price_Array_Makeup[3]=new int[]{40,170};
        price_Array_Makeup[4]=new int[]{100,190};
        price_Array_Makeup[5]=new int[]{70,155};
        price_Array_Makeup[6]=new int[]{87,145};
        price_Array_Makeup[7]=new int[]{83,157};
        price_Array_Makeup[8]=new int[]{92,185};
        price_Array_Makeup[9]=new int[]{95,195};
        price_Array_Makeup[10]=new int[]{85,165};
        price_Array_Makeup[11]=new int[]{84,157};
        //price_Array_Makeup[12]=new int[]{86,166,357,499,6900};

        //inserting Beauty SubServices_BasicCare into db
        for(int i=0;i<12;i++)
        {

            List<BeautiSubServices> beautiSubServicesList=new ArrayList<>();
            BeautiSubServices beautiSubService1=new BeautiSubServices(price_Array_Makeup[i][0],"Bridal Makeup");
            BeautiSubServices beautiSubService2=new BeautiSubServices(price_Array_Makeup[i][1],"Party Touchup");
            beautiSubServicesList.add(beautiSubService1);
            beautiSubServicesList.add(beautiSubService2);
            // Inserting beautiSubServicesList_HairCare into db
            long makeup_RowId= dataBaseHelper1.create_table_SubService(beautiSubServicesList,beautiPointId_List[i],beautyServiceId_6);
            Log.e("row ","id is: "+makeup_RowId);
        }
//closing DB Connection
       dataBaseHelper1.closeDB();
        Log.d("reachedd", "Selectiontab db closed method");
*/
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter;
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        OneFragment fragment1=OneFragment.newInstance(id_Point,1);
        adapter.addFragment(fragment1, "Hair Care");

        OneFragment fragment2=OneFragment.newInstance(id_Point,2);
        adapter.addFragment(fragment2, "Skin Care");

        OneFragment fragment3=OneFragment.newInstance(id_Point,3);
        adapter.addFragment(fragment3, "Hair Styling");

        OneFragment fragment4=OneFragment.newInstance(id_Point,4);
        adapter.addFragment(fragment4, "Hand and Feet");

        OneFragment fragment5=OneFragment.newInstance(id_Point,5);
        adapter.addFragment(fragment5, "Basic Care");

        OneFragment fragment6=OneFragment.newInstance(id_Point,6);
        adapter.addFragment(fragment6, "Makeup");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }



