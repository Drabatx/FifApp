package com.devtx.drabatx.fifapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 23/10/2016.
 */
public class DataBaseSource {
    public static final String TABLA_EVENTOS = "Eventos";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";
    public static final String DOUBLE_TYPE = "double";
    public static final String NOTNULL_TYPE = "not null";
    public static class Columnas{
        public static final String idEvento              = "idEvento";
        public static final String workshop               = "workshop";
        public static final String titulo                 = "titulo";
        public static final String ubicacion              = "ubicacion";
        public static final String hora_inicio            = "hora_inicio";
        public static final String hora_fin               = "hora_fin";
        public static final String fecha                  = "fecha";

    }

    public static final String CREATE_EVENTO_SCRIPT =
            "create table " + TABLA_EVENTOS +"(" +
                    Columnas.idEvento                   +" "+INT_TYPE+" primary key,"+
                    Columnas.workshop                   +" "+STRING_TYPE+" "+NOTNULL_TYPE+","+
                    Columnas.titulo                     +" "+STRING_TYPE+" "+NOTNULL_TYPE+","+
                    Columnas.ubicacion                  +" "+STRING_TYPE+" "+NOTNULL_TYPE+","+
                    Columnas.hora_inicio                +" "+STRING_TYPE+","+
                    Columnas.hora_fin                   +" "+STRING_TYPE+","+
                    Columnas.fecha                      +" "+STRING_TYPE+")";

    String[] camposEvento = new String[]{
            Columnas.idEvento,
            Columnas.workshop,
            Columnas.titulo,
            Columnas.ubicacion,
            Columnas.hora_inicio,
            Columnas.hora_fin,
            Columnas.fecha
    };

    private DataBaseHelper openHelper;
    private SQLiteDatabase database;

    public DataBaseSource(Context ctx){
        openHelper  = new DataBaseHelper(ctx);
        database    = openHelper.getWritableDatabase();
    }

    public ArrayList<Eventos>getAllEventos(){
        ArrayList<Eventos> eventosArrayList = new ArrayList<>();
        String selectPersona = "select * from "+TABLA_EVENTOS;
        Cursor c = database.rawQuery(selectPersona,null);
        if (c.moveToFirst()){
            do {
                Eventos eventos = new Eventos(
                        c.getInt(0), //id persona
                        c.getString(1),//fistname
                        c.getString(2),//lastname
                        c.getString(3),//email
                        c.getString(4),//urlFoto
                        c.getString(5),//ocupacion
                        c.getString(6)//hometown
                );
                eventosArrayList.add(eventos);
            }while (c.moveToNext());
        }

        return eventosArrayList;
    }
    public Eventos getEvento(int id){
        Eventos eventos = new Eventos();
        String[] args = new String[]{""+id};
        Cursor c = database.query(TABLA_EVENTOS, camposEvento, Columnas.idEvento + "=?", args, null, null, null);
        if (c.moveToFirst()){
            eventos = new Eventos(
                    c.getInt(0), //id persona
                    c.getString(1),//fistname
                    c.getString(2),//lastname
                    c.getString(3),//email
                    c.getString(4),//urlFoto
                    c.getString(5),//ocupacion
                    c.getString(6)//hometown
            );
        }
        return eventos;
    }

    public long insertPersona(Eventos eventos){
        Log.d("FIFAPP","inster user "+eventos.getId());
        ContentValues values = new ContentValues();
        values.put(Columnas.idEvento,            eventos.getId());
        values.put(Columnas.workshop,            eventos.getWorkshop());
        values.put(Columnas.titulo,              eventos.getTitulo());
        values.put(Columnas.ubicacion,           eventos.getUbicacion());
        values.put(Columnas.hora_inicio,         eventos.getHoraInicio());
        values.put(Columnas.hora_fin,            eventos.getHoraFin());
        values.put(Columnas.fecha,               eventos.getFecha());
        long val = database.insert(TABLA_EVENTOS,null,values);
        if (val>-1) Log.d("DATABASE","se insertaron los datos");
        else Log.d("DATABASE","Error al insertar datos");
        return val;
    }
}
