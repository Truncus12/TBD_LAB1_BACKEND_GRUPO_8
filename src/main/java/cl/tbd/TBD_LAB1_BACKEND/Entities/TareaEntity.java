package cl.tbd.TBD_LAB1_BACKEND.Entities;

import java.time.LocalDate;

public class TareaEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer cant_vol_req;
    private Integer cant_vol_ins;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private char estado_actual;
    private Long id_emergencia;

    public TareaEntity() {
    }

    public TareaEntity(String nombre,
                       String descripcion,
                       Integer cant_vol_req,
                       Integer cant_vol_ins,
                       LocalDate fecha_inicio,
                       LocalDate fecha_fin,
                       char estado_actual,
                       Long id_emergencia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cant_vol_req = cant_vol_req;
        this.cant_vol_ins = cant_vol_ins;
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

    public Integer getCant_vol_req() {
        return cant_vol_req;
    }

    public void setCant_vol_req(Integer cant_vol_req) {
        this.cant_vol_req = cant_vol_req;
    }

    public Integer getCant_vol_ins() {
        return cant_vol_ins;
    }

    public void setCant_vol_ins(Integer cant_vol_ins) {
        this.cant_vol_ins = cant_vol_ins;
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