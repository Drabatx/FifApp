package com.devtx.drabatx.fifapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class EventosAdapter  extends RecyclerView.Adapter<EventosAdapter.EventosViewHolder>{
    ArrayList<Eventos> eventos;

    public EventosAdapter(ArrayList<Eventos> eventos) {
        this.eventos = eventos;
    }

    @Override
    public EventosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        //v.setOnClickListener(this);
        EventosViewHolder viewHolder = new EventosViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventosViewHolder holder, int position) {
        Eventos evento = eventos.get(position);
        holder.bindEvento(evento);
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public static class EventosViewHolder extends RecyclerView.ViewHolder{
        public TextView id,hora,ponente,titulo;
        public EventosViewHolder(View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.numElemento);
            hora = (TextView)itemView.findViewById(R.id.horaElement);
            ponente = (TextView)itemView.findViewById(R.id.ponenteElemnt);
            titulo = (TextView)itemView.findViewById(R.id.titleElement);
        }

        public void bindEvento(Eventos eventos){
            id.setText(String.valueOf(eventos.getNumDia()));
            hora.setText(eventos.getHora());
            ponente.setText(eventos.getWorkshop());
            titulo.setText(eventos.getTitulo());
        }
    }
}
