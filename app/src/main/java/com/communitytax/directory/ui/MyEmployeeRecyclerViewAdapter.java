package com.communitytax.directory.ui;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.communitytax.directory.R;
import com.communitytax.directory.models.Datum;
import com.communitytax.directory.ui.EmployeeFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MyEmployeeRecyclerViewAdapter extends RecyclerView.Adapter<MyEmployeeRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Datum> imageModelArrayList;
    private ArrayList<Datum> arraylist;
    private final OnListFragmentInteractionListener mListener;

    public MyEmployeeRecyclerViewAdapter(ArrayList<Datum> items, OnListFragmentInteractionListener listener) {
        this.imageModelArrayList = items;
        this.arraylist = new ArrayList<Datum>();
        this.arraylist.addAll(EmployeeFragment.items);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = imageModelArrayList.get(position);

        TextDrawable drawable = TextDrawable.builder().buildRound("AB", Color.RED);
        holder.icon.setImageDrawable(drawable);

        holder.name.setText(imageModelArrayList.get(position).getName());
        holder.email.setText(imageModelArrayList.get(position).getEmail());
        holder.job_title.setText(imageModelArrayList.get(position).getJobTitle());
        holder.location.setText(imageModelArrayList.get(position).getLocation());
        holder.ext.setText(imageModelArrayList.get(position).getExt());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView icon;
        public final TextView name;
        public final TextView email;
        public final TextView job_title;
        public final TextView location;
        public final TextView ext;
        public Datum mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            icon      = (ImageView) view.findViewById(R.id.item_icon);
            name      = (TextView)  view.findViewById(R.id.item_name);
            email     = (TextView)  view.findViewById(R.id.item_email);
            job_title = (TextView)  view.findViewById(R.id.item_job_title);
            location  = (TextView)  view.findViewById(R.id.item_location);
            ext       = (TextView)  view.findViewById(R.id.item_ext);
        }
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase();
        EmployeeFragment.items.clear();
        if (charText.length() == 0  ) {
            EmployeeFragment.items.addAll(arraylist);
        } else {
            for (Datum wp : arraylist) {
                if (wp.getName().toLowerCase().contains(charText)) {
                    EmployeeFragment.items.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
