package com.example.hotelsfan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.listHotelViewHolder> {
    Context context;
    ArrayList<Hotels> listHotels;

    public HotelsAdapter(Context context, ArrayList<Hotels> listHotels) {

        this.context = context;
        this.listHotels = listHotels;
    }

    @NonNull
    @Override
    public listHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View v =inflater.inflate(R.layout.item_hotels,parent,false);

        return new listHotelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull listHotelViewHolder holder, int position) {
        Hotels itemHotels =listHotels.get(position);

        holder.tvid.setText(itemHotels.getId());
        holder.tvtitle.setText(itemHotels.getTitle());
        holder.tvspot.setText(itemHotels.getSpot());
        holder.tvimage.setText(itemHotels.getImage());
        holder.tvtext.setText(itemHotels.getText());
        holder.tvservices_type.setText(itemHotels.getServices_type());
        holder.tvstatus.setText(itemHotels.getStatus());
        holder.tvcreated_at.setText(itemHotels.getCreated_at());
        holder.tvupdated_at.setText(itemHotels.getUpdated_at());



    }

    @Override
    public int getItemCount() {
        return listHotels.size();
    }


    public static class listHotelViewHolder extends RecyclerView.ViewHolder{
        TextView tvid,tvtitle,tvspot,tvimage,tvtext,tvservices_type,tvstatus,tvcreated_at,tvupdated_at;
        public listHotelViewHolder(View itemView){
            super(itemView);
            tvid=itemView.findViewById(R.id.tvid);
            tvtitle=itemView.findViewById(R.id.tvtitle);
            tvspot=itemView.findViewById(R.id.tvspot);
            tvimage=itemView.findViewById(R.id.tvimage);
            tvtext=itemView.findViewById(R.id.tvtext);
            tvservices_type=itemView.findViewById(R.id.tvservices_type);
            tvstatus=itemView.findViewById(R.id.tvstatus);
            tvcreated_at=itemView.findViewById(R.id.tvcreated_at);
            tvupdated_at=itemView.findViewById(R.id.tvupdated_at);



        }

    }
}
