package br.com.dnoda.winelog_app.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.dnoda.winelog_app.R;
import br.com.dnoda.winelog_app.model.Wine;

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.WineViewHolder>{

    private List<Wine> wines;
    public Activity activity;

    public class WineViewHolder extends RecyclerView.ViewHolder
                                implements View.OnClickListener, View.OnCreateContextMenuListener{

        public TextView tvName, tvReview;

        public WineViewHolder(View view){
​​           super(view);
​           tvName = (TextView) view.findViewById(R.id.tvName);
​           tvReview = (TextView) view.findViewById(R.id.tvReview);
           view.setOnClickListener(this);
​           view.setOnCreateContextMenuListener(this);
​       }

        @Override
        public void onClick(View view) {
            activity.openContextMenu(view);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }

    @Override
​    public int getItemCount(){
        return wines.size();
​    }

    @Override
    public WineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.wine_list_row, parent,false);

        return new WineViewHolder(itemView);
    }
}
