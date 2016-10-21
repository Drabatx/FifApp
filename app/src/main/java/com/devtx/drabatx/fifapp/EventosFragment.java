package com.devtx.drabatx.fifapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class EventosFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int VERTICAL_ITEM_SPACE = 5;

    private ArrayList<Eventos> eventos = new ArrayList<>();
    public EventosFragment() {
    }

    public static EventosFragment newInstance(int sectionNumber) {
        EventosFragment fragment = new EventosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.eventos_fragment, container, false);

        for (int i=0;i<10;i++){
            eventos.add(new Eventos(i,i,"Lunes",""+String.valueOf(13+i)+":00","Juan Perez","Eventos","Ubicacion"));
        }

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recylerEventos);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new EventosAdapter(eventos));
        //recyclerView.setVisibility(View.INVISIBLE);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
}
