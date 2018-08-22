package com.example.android.materialdesignapp;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PastOrdersAdapter extends RecyclerView.Adapter<PastOrdersAdapter.ViewHolder>{
    private Context context;


    public PastOrdersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PastOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lisview, parent, false);
        PastOrdersAdapter.ViewHolder viewHolder = new PastOrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PastOrdersAdapter.ViewHolder holder, final int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
