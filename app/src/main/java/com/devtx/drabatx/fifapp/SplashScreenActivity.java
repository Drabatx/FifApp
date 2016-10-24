package com.devtx.drabatx.fifapp;

import android.content.Intent;
import android.database.SQLException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.devtx.drabatx.fifapp.database.DataBaseHelper;
import com.devtx.drabatx.fifapp.database.DataBaseSource;
import com.devtx.drabatx.fifapp.database.Eventos;

public class SplashScreenActivity extends AppCompatActivity implements Runnable{

    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        try {
            dataBaseHelper = new DataBaseHelper(getApplicationContext());

            DataBaseSource dataBaseSource = new DataBaseSource(getApplicationContext());
            dataBaseSource.insertPersona(new Eventos(1,"Rubén Martin",
                    "FOTOGRAFIA EDITORIAL, DEL ARTE  AL NEGOCIO",
                    "Galeria de Arte Complejo Cultural Universitario",
                    "8:00","15:00","Miercoles 21"));
            dataBaseSource.insertPersona(new Eventos(2,"Nirvana Paz",
                    "EDICION Y DETONANTES",
                    "Fundacion ESRU",
                    "8:00","15:00","Miercoles 21"));
            dataBaseSource.insertPersona(new Eventos(3,"Slavador Cisneros",
                    "FOTOGRAFIA DOCUMENTAL",
                    "Galeria Wandel",
                    "8:00","15:00","Miercoles 21"));
            dataBaseSource.insertPersona(new Eventos(4,"",
                    "PRESENTACION DE REVISTA BIMESTRAL MEXICO-ISRAEL",
                    "Provedora Escolar",
                    "16:30","18:00","Miercoles 21"));
            dataBaseSource.insertPersona(new Eventos(5,"",
                    "HAPPENING DE INAUGURACION",
                    "Barrio del Artista",
                    "19:30","","Miercoles 21"));

            dataBaseSource.insertPersona(new Eventos(6,"Conferencia",
                    "RELACION ENTRE EDUCACION Y PRODUCCION ARTISTICA Universiad del Tecnologico de Monterrey",
                    "Museo del Tecnologico de Monterrey",
                    "13:30","15:00","Jueves 22"));
            dataBaseSource.insertPersona(new Eventos(7,"",
                    "INAUGURACION EXPOSICION CONCEPTUAL-EDITORIAL",
                    "Fototeca Juan C. Mendez",
                    "16:00","16:30","Jueves 22"));
            dataBaseSource.insertPersona(new Eventos(8,"",
                    "INAUGURACION EXPOSICION CISNES GUERREROS",
                    "Fundacion ESRU",
                    "17:00","17:40","Jueves 22"));
            dataBaseSource.insertPersona(new Eventos(9,"Conferecnia Julian Marionov",
                    "DEL HOBBY FOTOGRAFICO A LA PROFESION",
                    "Galeria de Arte Complejo Cultural Universitario",
                    "18:30","20:00","Jueves 22"));
            dataBaseSource.insertPersona(new Eventos(10,"Conferencia Jvda Berra",
                    "COMO VENDERSE COMO FOTOGRAFICO DE MODA",
                    "Casa Nueve",
                    "18:30","20:00","Jueves 22"));


            dataBaseSource.insertPersona(new Eventos(11,"Julian Marionov",
                    "COMO CONVERTIR LA FOTOGRAFIA DE HOBBY A PROFESION",
                    "Cafe 19-40",
                    "08:00","15:00","Viernes 23"));

            dataBaseSource.insertPersona(new Eventos(12,"Paula Islas",
                    "RETRATO FOTOGRAFICO",
                    "Galeria Wandel",
                    "08:00","15:00","Viernes 23"));

            dataBaseSource.insertPersona(new Eventos(13,"Conferencia Jvda Berra",
                    "COMO VENDERSE COMO FOTOGRAFICO DE MODA",
                    "Fundacion ESRU",
                    "08:00","15:00","Viernes 23"));

            dataBaseSource.insertPersona(new Eventos(14,"",
                    "CLINICA FOTOGRAFICA",
                    "Galeria de Arte Complejo Cultural Universitario",
                    "09:30","15:00","Sabado 24"));

            dataBaseSource.insertPersona(new Eventos(15,"",
                    "Click Splash",
                    "Patio del Museo Taller Erasto Cortes",
                    "15:30","19:30","Sabado 24"));

            dataBaseSource.insertPersona(new Eventos(16,"Conferencia Jvda Berra",
                    "INAUGURACION EXPOSCIONO FOTOPERIODISMO Y DOCUMENTAL",
                    "Galeria abierta \"Entre Rejas\". Complejo Cultural Universitario",
                    "17:00","17:30","Sabado 24"));


            dataBaseSource.insertPersona(new Eventos(17,"",
                    "INAUGURACION EXPOSICION CLICK SPLASH",
                    "Hotel Gente de Más",
                    "16:30","17:00","Domingo 25"));

            dataBaseSource.insertPersona(new Eventos(18,"Conferencia Jvda Berra",
                    "HAPPENING DE CLAUSURA",
                    "Teatro de la ciudad",
                    "19:00","20:00","Domingo 25"));

        }catch (SQLException e){
            Log.d("SQLITEERROR",e.getMessage());
        }

        /*Se cambia de activity tras transcurrir 3 segundos*/
        Handler handler = new Handler();
        handler.postDelayed(this,3000);

    }

    @Override
    public void run() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
