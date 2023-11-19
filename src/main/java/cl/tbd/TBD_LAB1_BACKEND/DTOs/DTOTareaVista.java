package cl.tbd.TBD_LAB1_BACKEND.DTOs;

import java.time.LocalDate;

public class DTOTareaVista {
    public int id;
    public String nombre;
    public String descripcion;
    public Integer cant_vol_requeridos;
    public Integer cant_vol_inscritos;
    public LocalDate fecha_inicio;
    public LocalDate fecha_fin;
    public String estado_actual;
    public Long id_emergencia;
    public Double longitud;
    public Double latitud;

    public DTOTareaVista(String nombre, String descripcion, Integer cant_vol_requeridos,
                         Integer cant_vol_inscritos, LocalDate fecha_inicio,
                         LocalDate fecha_fin, String estado_actual, Long id_emergencia,
                         Double longitud, Double latitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cant_vol_requeridos = cant_vol_requeridos;
        this.cant_vol_inscritos = cant_vol_inscritos;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado_actual = estado_actual;
        this.id_emergencia = id_emergencia;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}