package com.beauti.experthp.bijnorbeautihub.Fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beauti.experthp.bijnorbeautihub.Adapter.BeautyServicesAdapter;
import com.beauti.experthp.bijnorbeautihub.CardCollectionDecorate;
import com.beauti.experthp.bijnorbeautihub.DataBaseHelper.DataBaseHelper1;
import com.beauti.experthp.bijnorbeautihub.DataBaseModel.BeautiSubServices;
import com.beauti.experthp.bijnorbeautihub.R;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment {
    private long point_Id, tab_id;
    private List<BeautiSubServices> beautiSubServicesList;
    RecyclerView recycleview;
    BeautyServicesAdapter beautyServicesAdapter;

    DataBaseHelper1 dataBaseHelper1;


    public OneFragment() {}
    public static final OneFragment newInstance(int point_Id,int tab_id){
        OneFragment oneFragment=new OneFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("Point_id",point_Id);
        bundle.putInt("Tab_id", tab_id);
        oneFragment.setArguments(bundle);
        Log.d("reachedd","one fragment instance method");
        return oneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        point_Id=getArguments().getInt("Point_id");
        tab_id=getArguments().getInt("Tab_id");
        dataBaseHelper1= new DataBaseHelper1(getActivity());
        beautiSubServicesList= PrepaireData();
        /*
        for(int i=0;i<beautiSubServicesList.size();i++)
        {
            String name=beautiSubServicesList.get(i).getSubService_Name();
            Log.d("Name is--"+name,"price --"+String.valueOf(beautiSubServicesList.get(i).getPrice())+ "pointid::"+String.valueOf(beautiSubServicesList.get(i).getPoint_id())+ "serviceid::" +String.valueOf(beautiSubServicesList.get(i).getService_id()) );
        }*/
        Log.d("reachedd","one fragment prepare method"+beautiSubServicesList.size());

        dataBaseHelper1.closeDB();
        Log.d("reachedd", "one fragment closwdb method");

        beautyServicesAdapter=new BeautyServicesAdapter(beautiSubServicesList,getActivity());

        View rootView=inflater.inflate(R.layout.fragment_one, container, false);
        recycleview= (RecyclerView) rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mlayoutManager=new LinearLayoutManager(getActivity());
        recycleview.setLayoutManager(mlayoutManager);
        recycleview.addItemDecoration(new CardCollectionDecorate(getActivity()));
        recycleview.setAdapter(beautyServicesAdapter);
        return rootView;
    }
    private List<BeautiSubServices> PrepaireData(){
        return dataBaseHelper1.get_ALL_Sub_Service(point_Id,tab_id);
    }

}