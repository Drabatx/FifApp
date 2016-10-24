package com.devtx.drabatx.fifapp.database;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class Eventos {
    private int id;
    private String workshop,
                   titulo,
                   ubicacion,
                    horaInicio,
                    horaFin,
                    fecha;

    public Eventos() {
    }

    public Eventos(int id, String workshop, String titulo, String ubicacion, String horaInicio, String horaFin, String fecha) {
        this.id = id;
        this.workshop = workshop;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
