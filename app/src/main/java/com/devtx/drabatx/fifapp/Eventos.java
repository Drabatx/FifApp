package com.devtx.drabatx.fifapp;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class Eventos {
    private int id;
    private int numDia;
    private String dia,
                    hora,
                    workshop,
                    titulo,
                    ubicacion;

    public Eventos(int id, int numDia, String dia, String hora, String workshop, String titulo, String ubicacion) {
        this.id = id;
        this.numDia = numDia;
        this.dia = dia;
        this.hora = hora;
        this.workshop = workshop;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumDia() {
        return numDia;
    }

    public void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
