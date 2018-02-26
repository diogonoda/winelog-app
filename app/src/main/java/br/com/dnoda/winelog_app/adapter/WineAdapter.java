package br.com.dnoda.winelog_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.dnoda.winelog_app.R;
import br.com.dnoda.winelog_app.model.Wine;

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.WineViewHolder>{
    private List<Wine> wines;
    private int rowLayout;
    private Context context;

    public WineAdapter(List<Wine> wines, int rowLayout, Context context){
        this.wines = wines;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public static class WineViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cardWine;
        TextView tvName, tvReview;

        public WineViewHolder(View view) {
            super(view);

            cardWine = (LinearLayout) view.findViewById(R.id.card_wine);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvReview = (TextView) view.findViewById(R.id.tv_review);
        }
    }

    public void setWines(List<Wine> wines){
        this.wines = wines;
    }

    @Override
    public WineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(rowLayout, parent, false);

        return new WineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WineViewHolder holder, int position) {
        Wine wine = wines.get(position);
        holder.tvName.setText(wine.getName());
        holder.tvReview.setText(wine.getReview());
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }
}
