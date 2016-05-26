package com.beauti.experthp.bijnorbeautihub.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beauti.experthp.bijnorbeautihub.DataBaseModel.BeautiSubServices;
import com.beauti.experthp.bijnorbeautihub.Model.BeautyServices;
import com.beauti.experthp.bijnorbeautihub.R;

import java.util.List;
import java.util.Locale;

/**
 * Created by expert on 5/4/2016.
 */
public class BeautyServicesAdapter extends RecyclerView.Adapter<BeautyServicesAdapter.MyServiceViewHolder> {
    List<BeautiSubServices> beautySubServices;
    BeautyServicesAdapter(){}
    Context context;
    int cost;
    public class MyServiceViewHolder extends RecyclerView.ViewHolder{
        TextView Name,price;


        public MyServiceViewHolder(View itemView) {
            super(itemView);
            Name=(TextView) itemView.findViewById(R.id.name);
            price=(TextView) itemView.findViewById(R.id.price);
        }

       }
    public BeautyServicesAdapter(List<BeautiSubServices> beautySubServices,Context context) {
        this.beautySubServices=beautySubServices;
        this.context=context;
    }

        @Override
    public MyServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.beauti_services_list_row,parent,false);

        return new MyServiceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyServiceViewHolder holder, int position) {
        BeautiSubServices subService = beautySubServices.get(position);
            holder.Name.setText(subService.getSubService_Name());
        //cost=beautySubServices.get(position).getPrice();
            holder.price.setText(String.valueOf(subService.getPrice())+ " INR  ");
       // int a=9;
        //String ch= String.valueOf(a);
        //Log.d("checking avlye AA", "is :" + ch);
    }

    @Override
    public int getItemCount() {
        return beautySubServices.size();
    }

    @Override
    public String toString() {
        return "Price: "+cost+" INR";
    }
}
