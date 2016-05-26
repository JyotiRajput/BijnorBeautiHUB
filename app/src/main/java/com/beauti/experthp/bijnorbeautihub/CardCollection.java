package com.beauti.experthp.bijnorbeautihub;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.beauti.experthp.bijnorbeautihub.Adapter.BeautiPointAdapter;
import com.beauti.experthp.bijnorbeautihub.Model.BeautiPoints;

import java.util.ArrayList;
import java.util.List;

public class CardCollection extends AppCompatActivity {
    private List<BeautiPoints> BeautiPointList = new ArrayList<>();
    private RecyclerView recyclerView;
    private static final int VERTICAL_ITEM_SPACE = 48;
    private BeautiPointAdapter mAdapter;
    private TypedArray imageList;
    private String[] title;
    private String address[];
    private String contact[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        imageList=getResources().obtainTypedArray(R.array.beatipoint_image);
        title=getResources().getStringArray(R.array.beautipoint_title);
        address=getResources().getStringArray(R.array.beauty_addresses);
        contact=getResources().getStringArray(R.array.contact);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        prepareMovieData();
        mAdapter = new BeautiPointAdapter(BeautiPointList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new CardCollectionDecorate(this));
        recyclerView.setAdapter(mAdapter);




    }
private void prepareMovieData(){
BeautiPoints beautiPoints1= new BeautiPoints(title[0],contact[0],imageList.getResourceId(0,-1),address[0]);
    BeautiPointList.add(beautiPoints1);
    BeautiPoints beautiPoints2= new BeautiPoints(title[1],contact[1],imageList.getResourceId(1,-1),address[1]);
    BeautiPointList.add(beautiPoints2);
    BeautiPoints beautiPoints3= new BeautiPoints(title[2],contact[2],imageList.getResourceId(2,-1),address[2]);
    BeautiPointList.add(beautiPoints3);
    BeautiPoints beautiPoints4= new BeautiPoints(title[3],contact[3],imageList.getResourceId(3,-1),address[3]);
    BeautiPointList.add(beautiPoints4);
    BeautiPoints beautiPoints5= new BeautiPoints(title[4],contact[4],imageList.getResourceId(4,-1),address[4]);
    BeautiPointList.add(beautiPoints5);
    BeautiPoints beautiPoints6= new BeautiPoints(title[5],contact[5],imageList.getResourceId(5,-1),address[5]);
    BeautiPointList.add(beautiPoints6);
    BeautiPoints beautiPoints7= new BeautiPoints(title[6],contact[6],imageList.getResourceId(6,-1),address[6]);
    BeautiPointList.add(beautiPoints7);
    BeautiPoints beautiPoints8= new BeautiPoints(title[7],contact[7],imageList.getResourceId(7,-1),address[7]);
    BeautiPointList.add(beautiPoints8);
    BeautiPoints beautiPoints9= new BeautiPoints(title[8],contact[8],imageList.getResourceId(8,-1),address[8]);
    BeautiPointList.add(beautiPoints9);
    BeautiPoints beautiPoints10= new BeautiPoints(title[9],contact[9],imageList.getResourceId(9,-1),address[9]);
    BeautiPointList.add(beautiPoints10);
    BeautiPoints beautiPoints11= new BeautiPoints(title[10],contact[10],imageList.getResourceId(10,-1),address[10]);
    BeautiPointList.add(beautiPoints11);
    BeautiPoints beautiPoints12= new BeautiPoints(title[11],contact[11],imageList.getResourceId(11,-1),address[11]);
    BeautiPointList.add(beautiPoints12);
}
}
