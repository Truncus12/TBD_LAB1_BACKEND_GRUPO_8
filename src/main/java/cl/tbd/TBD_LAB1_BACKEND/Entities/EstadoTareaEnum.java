package cl.tbd.TBD_LAB1_BACKEND.Entities;

public enum EstadoTareaEnum {
    PENDIENTE(1), 
    TERMINADA(2), 
    CANCELADA(3);

    public final int id;

    private EstadoTareaEnum(int id){
        this.id = id;
    }
}
