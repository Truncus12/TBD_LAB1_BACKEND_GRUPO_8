package cl.tbd.TBD_LAB1_BACKEND.DTOs;

import java.time.LocalDate;

public class DTOEmergenciaVista {
    public long id;
    public String nombre;
    public String descripcion;
    public LocalDate fecha_inicio;
    public LocalDate fecha_fin;
    public Long id_institucion;
    public double longitud;
    public double latitud;

    public DTOEmergenciaVista(long id, String nombre, String descripcion,
                              LocalDate fecha_inicio, LocalDate fecha_fin,
                              Long id_institucion, double longitud,
                              double latitud) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_institucion = id_institucion;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}
