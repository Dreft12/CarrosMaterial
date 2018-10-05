package com.carros.carrosmaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrosAdapter extends RecyclerView.Adapter<CarrosAdapter.CarroViewHolder>{
    private ArrayList<Carros> carros;
    private Context contexto;
    public CarrosAdapter(ArrayList<Carros> carros, Context context){
        this.contexto = context;
        this.carros = carros;
    }
    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_carro,parent, false);
        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarrosAdapter.CarroViewHolder holder, int position) {
        Carros c = carros.get(position);
        holder.fotos.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.marca.setText(contexto.getResources().getStringArray(R.array.lstMarca)[c.getMarca()]);
        holder.color.setText(contexto.getResources().getStringArray(R.array.lsColor)[c.getColor()]);
        holder.precio.setText(""+c.getPrecio());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotos;
        private TextView marca;
        private TextView color;
        private TextView precio;
        private TextView placa;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;
            fotos = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            precio =v.findViewById(R.id.lblPrecio);
            color = v.findViewById(R.id.lblColor);
        }
    }
}
