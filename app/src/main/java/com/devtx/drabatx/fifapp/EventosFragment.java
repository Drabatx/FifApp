package com.devtx.drabatx.fifapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devtx.drabatx.fifapp.database.DataBaseSource;
import com.devtx.drabatx.fifapp.database.Eventos;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class EventosFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "SECTION";
    private static final int VERTICAL_ITEM_SPACE = 5;

    private ArrayList<Eventos> eventos = new ArrayList<>();
    public EventosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.eventos_fragment, container, false);
/*
        for (int i=0;i<10;i++){
            eventos.add(new Eventos(i,"Lunes",""+String.valueOf(13+i)+":00","Juan Perez","Eventos","Ubicacion"));
        }*/
        DataBaseSource dataBaseSource = new DataBaseSource(getActivity().getApplicationContext());
        eventos=dataBaseSource.getAllEventos();

        int num = getArguments().getInt(ARG_SECTION_NUMBER);
        String dia ;
        switch (num){
            case 0: dia = "Miercoles 21";
                break;
            case 1: dia = "Jueves 22";
                break;
            case 2: dia = "Viernes 23";
                break;
            case 3: dia = "Sabado 24";
                break;
            case 4: dia = "Domingo 25";
                break;
            default:dia ="Miercoles 21";
        }


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recylerEventos);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new EventosAdapter(getSubArray(dia,eventos)));
        //recyclerView.setVisibility(View.INVISIBLE);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    private ArrayList getSubArray(String dia,ArrayList<Eventos> arrayList){
        ArrayList<Eventos> evento = new ArrayList<>();

        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getFecha().equals(dia)){
                evento.add(arrayList.get(i));
            }
        }
        return evento;
    }
}
