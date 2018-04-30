package com.communitytax.directory.adapters;

/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.communitytax.directory.R;
import com.communitytax.directory.models.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private static final String TAG = "EmployeeAdapter";
    private List<Datum> items = null;
    private ArrayList<Datum> copyItems;

    public EmployeeAdapter(List<Datum> items) {
        this.items = items;
        copyItems = new ArrayList<Datum>();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;
        private final TextView name;
        private final TextView email;
        private final TextView job_title;
        private final TextView location;
        private final TextView ext;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });

            icon      = (ImageView) v.findViewById(R.id.item_icon);
            name      = (TextView)  v.findViewById(R.id.item_name);
            email     = (TextView)  v.findViewById(R.id.item_email);
            job_title = (TextView)  v.findViewById(R.id.item_job_title);
            location  = (TextView)  v.findViewById(R.id.item_location);
            ext       = (TextView)  v.findViewById(R.id.item_ext);
        }

        public ImageView getIconView() {
            return icon;
        }
        public TextView getNameView() {
            return name;
        }
        public TextView getEmailView() {
            return email;
        }
        public TextView getJobTitleView() {
            return job_title;
        }
        public TextView getLocationView() {
            return location;
        }
        public TextView getExtView() {
            return ext;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        //viewHolder.getTextView().setText(mDataSet[position]);
        TextDrawable drawable = TextDrawable.builder().buildRound("AB", Color.RED);
        viewHolder.getIconView().setImageDrawable(drawable);
        viewHolder.getNameView().setText(items.get(position).getName());
        viewHolder.getEmailView().setText(items.get(position).getEmail());
        viewHolder.getJobTitleView().setText(items.get(position).getJobTitle());
        viewHolder.getLocationView().setText(items.get(position).getLocation());
        viewHolder.getExtView().setText(items.get(position).getExt());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filter(String charText) {
        if( copyItems.isEmpty() ) {
            this.copyItems.addAll(items);
        }

        charText = charText.toLowerCase();
        items.clear();
        if (charText.length() == 0) {
            items.addAll(copyItems);
        }
        else
        {
            for (Datum wp : copyItems)
            {
                if (wp.getName().toLowerCase().contains(charText))
                {
                    items.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}