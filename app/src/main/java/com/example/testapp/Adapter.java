package com.example.testapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
class IndividualDayAdapter extends RecyclerView.Adapter<IndividualDayAdapter.MyViewHolder>{
    ArrayList<EventModel> eventModelList;
    Context context;
    public IndividualDayAdapter(ArrayList<EventModel> eventModelList) {
        this.eventModelList = eventModelList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.recycler_individual_day, parent, false);
        return new MyViewHolder(view);
    }
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        EventModel event = eventModelList.get(position);
        System.out.println(event.title);
        System.out.println(event.timestamp);
        holder.title.setText(event.title);
        holder.timestamp.setText(event.timestamp);
    }
    @Override
    public int getItemCount() {
        Log.d("Recycler.adapter", "item count is " + eventModelList.size());
        return eventModelList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, timestamp;
        CardView eventCard;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.event_display);
            timestamp = itemView.findViewById(R.id.time_display);
            eventCard = itemView.findViewById(R.id.event_card);
        }
    }
}
