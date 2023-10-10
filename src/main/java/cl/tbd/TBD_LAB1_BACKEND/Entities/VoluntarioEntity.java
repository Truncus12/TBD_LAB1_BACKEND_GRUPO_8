package cl.tbd.TBD_LAB1_BACKEND.Entities;


public class VoluntarioEntity {

    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;


    public VoluntarioEntity() {
    }


    public VoluntarioEntity(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
