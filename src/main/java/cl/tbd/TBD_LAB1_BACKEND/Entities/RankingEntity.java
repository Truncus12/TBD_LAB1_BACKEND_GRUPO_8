package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class RankingEntity {
    private Long id;
    private Integer puntaje;
    private boolean flag_invitado;
    private boolean flag_participa;
    private Long id_tarea;
    private Long id_voluntario;

    public RankingEntity() {
    }

    public RankingEntity(Integer puntaje, boolean flag_invitado, boolean flag_participa, Long id_tarea, Long id_voluntario) {
        this.puntaje = puntaje;
        this.flag_invitado = flag_invitado;
        this.flag_participa = flag_participa;
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public boolean isFlag_invitado() {
        return flag_invitado;
    }

    public void setFlag_invitado(boolean flag_invitado) {
        this.flag_invitado = flag_invitado;
    }

    public boolean isFlag_participa() {
        return flag_participa;
    }

    public void setFlag_participa(boolean flag_participa) {
        this.flag_participa = flag_participa;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
}
