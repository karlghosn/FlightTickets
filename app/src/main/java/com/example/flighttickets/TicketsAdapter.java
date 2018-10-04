package com.example.flighttickets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.flighttickets.network.model.Ticket;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.MyViewHolder> {
    private final Context context;
    private List<Ticket> contactList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.airline_name)
        TextView airlineName;

        @BindView(R.id.logo)
        ImageView logo;

        @BindView(R.id.number_of_stops)
        TextView stops;

        @BindView(R.id.number_of_seats)
        TextView seats;

        @BindView(R.id.departure)
        TextView departure;

        @BindView(R.id.arrival)
        TextView arrival;

        @BindView(R.id.duration)
        TextView duration;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.loader)
        SpinKitView loader;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    TicketsAdapter(Context context, List<Ticket> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ticket_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Ticket ticket = contactList.get(position);

        Glide.with(context)
                .load(ticket.getAirline().getLogo())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.logo);

        holder.airlineName.setText(ticket.getAirline().getName());

        holder.departure.setText(ticket.getDeparture() + " Dep");
        holder.arrival.setText(ticket.getArrival() + " Dest");

        holder.duration.setText(ticket.getFlightNumber());
        holder.duration.append(", " + ticket.getDuration());
        holder.stops.setText(ticket.getNumberOfStops() + " Stops");

        if (!TextUtils.isEmpty(ticket.getInstructions())) {
            holder.duration.append(", " + ticket.getInstructions());
        }

        if (ticket.getPrice() != null) {
            holder.price.setText("₹" + String.format("%.0f", ticket.getPrice().getPrice()));
            holder.seats.setText(ticket.getPrice().getSeats() + " Seats");
            holder.loader.setVisibility(View.INVISIBLE);
        } else {
            holder.loader.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}

