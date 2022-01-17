package com.example.project3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.WordViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<String> mNumbers;
    private LinkedList<String> mNumberFacts;
    private Context context;



public NumbersAdapter(Context context, LinkedList<String> numbers, LinkedList<String> numberFacts) {
        mInflater = LayoutInflater.from(context);
        mNumbers = numbers;
        mNumberFacts = numberFacts;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.numbers_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mNumbers.get(position);
        holder.mNumbersView.setText(mCurrent);
        mCurrent = mNumberFacts.get(position);
        holder.mNumberFactsView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNumbersView;
        private TextView mNumberFactsView;
        private NumbersAdapter adapter;

        public WordViewHolder(View itemView, NumbersAdapter adapter) {
            super(itemView);
            mNumbersView = itemView.findViewById(R.id.number);
            mNumberFactsView = itemView.findViewById(R.id.fact);

            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, NumbersDetailActivity.class);
            context.startActivity(intent);
        }

    }

}