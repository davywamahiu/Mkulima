package com.example.mkulima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.ViewHolder> {

    private List<Buyersmkulima>listData;

    public SupportAdapter(List<Buyersmkulima> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_support,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Buyersmkulima ld=listData.get(position);
        holder.txtid.setText(ld.getCounty());
        holder.txtname.setText(ld.getFirstname());
        holder.txtmovie.setText(ld.getLastname());
        holder.txtwho.setText(ld.getPhone());
        holder.textme.setText(ld.getCategory());
        holder.txtselling.setText(ld.getSelling());
        holder.txtkununua.setText(ld.getKununua());
        holder.txtuuzaji.setText(ld.getUuzaji());
        holder.txtemail.setText(ld.getEmail());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid,txtname,txtmovie, txtwho, textme, txtemail, txtuuzaji, txtkununua, txtselling;
        public ViewHolder(View itemView) {
            super(itemView);
            txtid=itemView.findViewById(R.id.textView3);
            txtname=itemView.findViewById(R.id.textView2);
            txtmovie=itemView.findViewById(R.id.textView5);
            textme=itemView.findViewById(R.id.textView6);
            txtwho=itemView.findViewById(R.id.textView7);
            txtemail=itemView.findViewById(R.id.textView8);
            txtuuzaji=itemView.findViewById(R.id.textView9);
            txtkununua=itemView.findViewById(R.id.textView10);
            txtselling=itemView.findViewById(R.id.textView11);
        }
    }
}