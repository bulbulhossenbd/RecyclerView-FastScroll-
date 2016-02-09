package com.example.appsd.recyclerview_fastscroll_;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaredrummler.fastscrollrecyclerview.FastScrollRecyclerView;

import java.util.Locale;

/**
 * Created by appsd on 2/10/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
        implements FastScrollRecyclerView.SectionedAdapter {

    private final String[] countries;

    public RecyclerAdapter(String[] countries) {
        this.countries = countries;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(countries[position]);
    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return countries[position].substring(0, 1).toUpperCase(Locale.ENGLISH);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }


    }

}