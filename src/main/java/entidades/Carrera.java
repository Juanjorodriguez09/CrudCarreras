package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "carreras")
public class Carrera {
    public Carrera() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private int id;

    private String nombre;
    private int tipo;

    @Column(name = "idfacultad", nullable = false)
    private int idFacultad;

    // Constructor con todos los campos
    public Carrera(int id, String nombre, int tipo, int idFacultad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.idFacultad = idFacultad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    // Sobrescribimos el método toString para una salida legible
    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", idFacultad=" + idFacultad +
                '}';
    }
}
