package com.example.weatherchekk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.weatherchekk.MainActivity.sharedPrefs;

public class CustomRecycleViewAdapter extends RecyclerView.Adapter<CustomRecycleViewAdapter.CustomViewHolder> {
    private ArrayList<Term> terms;
    private Context context;

    public CustomRecycleViewAdapter(ArrayList<Term> terms, Context context) {
        this.terms = terms;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecycleViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycle_display,null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new CustomViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecycleViewAdapter.CustomViewHolder holder, int position) {
        Term term = terms.get(position);
        holder.name.setImageResource(term.getName());
        holder.description.setText(term.getDescription());
    }

    @Override
    public int getItemCount() {
        if (terms != null){
            return terms.size();
        }
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView name;
        protected TextView description;

        public CustomViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.descriptionItem);

            String fontSizeChoice = sharedPrefs.getString("fontSize","18sp");
            switch (fontSizeChoice){
                case "18sp" :
                    description.setTextSize(18);
                    name.getLayoutParams().height = 200;
                    break;
                case "20sp" :
                    description.setTextSize(20);
                    name.getLayoutParams().height = 400;
                    break;
                case "24sp" :
                    description.setTextSize(24);
                    name.getLayoutParams().height = 600;
                    break;
            }
        }
    }
}
