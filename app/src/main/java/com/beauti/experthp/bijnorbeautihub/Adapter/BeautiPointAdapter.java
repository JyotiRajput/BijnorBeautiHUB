package com.beauti.experthp.bijnorbeautihub.Adapter;

/**
 * Created by expert HP on 22/04/2016.
 */

    import android.app.Fragment;
    import android.content.Context;
    import android.content.Intent;
    import android.support.v7.widget.RecyclerView;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.Switch;
    import android.widget.TextView;

    import com.beauti.experthp.bijnorbeautihub.CardCollection;
    import com.beauti.experthp.bijnorbeautihub.Fragment.OneFragment;
    import com.beauti.experthp.bijnorbeautihub.Model.BeautiPoints;
    import com.beauti.experthp.bijnorbeautihub.R;
    import com.beauti.experthp.bijnorbeautihub.SelectionTab1;

    import java.util.List;

    public class BeautiPointAdapter extends RecyclerView.Adapter<BeautiPointAdapter.MyViewHolder> {

        private List<BeautiPoints> beautiPointList;
        Context context;
//        private String[] address_list;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, contact,address;
            public ImageView image;

            public MyViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.name);
                contact = (TextView) view.findViewById(R.id.contact);
                address = (TextView) view.findViewById(R.id.address);
                image = (ImageView) view.findViewById(R.id.image);
              //final String string="jyoti";
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(context, SelectionTab1.class);
                        //intent.putExtra("point_Address",address_list[getAdapterPosition()]);
                        intent.putExtra("point_Id",getAdapterPosition());

                        context.startActivity(intent);
                    }

                });
            }
        }


        public BeautiPointAdapter(List<BeautiPoints> beautiPointList,Context context) {
            this.beautiPointList = beautiPointList;
            this.context=context;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.beautipoint_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            BeautiPoints points = beautiPointList.get(position);
            holder.title.setText(points.getName());
            holder.contact.setText(points.getContact());
            holder.address.setText(points.getAddress());
            holder.image.setImageResource(points.getImage());
        }

        @Override
        public int getItemCount() {
            return beautiPointList.size();
        }


    }



