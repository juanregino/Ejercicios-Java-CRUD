package entity;

public class Pasajero {
    private String id;
    private String name;
    private String apellido;
    private  String documentoIdentidad;

    public Pasajero() {
    }

    public Pasajero(String id, String name, String apellido, String documentoIdentidad) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                '}';
    }
}
