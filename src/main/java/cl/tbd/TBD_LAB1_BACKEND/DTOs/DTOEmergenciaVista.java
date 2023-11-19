package cl.tbd.TBD_LAB1_BACKEND.DTOs;

import java.time.LocalDate;

public class DTOEmergenciaVista {
    public long id;
    public String nombre;
    public String descripcion;
    public LocalDate fecha_inicio;
    public LocalDate fecha_fin;
    public double longitud;
    public double latitud;
    public int coordinador_asociado;

    public DTOEmergenciaVista(long id, String nombre, String descripcion,
                              LocalDate fecha_inicio, LocalDate fecha_fin,
                              int coordinador_asociado, double longitud,
                              double latitud) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.coordinador_asociado = coordinador_asociado;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}
