package cl.tbd.TBD_LAB1_BACKEND.Entities;

import java.time.LocalDate;

public class TareaEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private char estado_actual;
    private Long id_emergencia;

    public TareaEntity() {
    }

    public TareaEntity(String nombre,
                       String descripcion,
                       Integer cant_vol_requeridos,
                       Integer cant_vol_inscritos,
                       LocalDate fecha_inicio,
                       LocalDate fecha_fin,
                       char estado_actual,
                       Long id_emergencia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cant_vol_requeridos = cant_vol_requeridos;
        this.cant_vol_inscritos = cant_vol_inscritos;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado_actual = estado_actual;
        this.id_emergencia = id_emergencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCant_vol_requeridos() {
        return cant_vol_requeridos;
    }

    public void setCant_vol_requeridos(Integer cant_vol_requeridos) {
        this.cant_vol_requeridos = cant_vol_requeridos;
    }

    public Integer getCant_vol_inscritos() {
        return cant_vol_inscritos;
    }

    public void setCant_vol_inscritos(Integer cant_vol_inscritos) {
        this.cant_vol_inscritos = cant_vol_inscritos;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public char getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(char estado_actual) {
        this.estado_actual = estado_actual;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}