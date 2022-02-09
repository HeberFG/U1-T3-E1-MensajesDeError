package mx.edu.utez.mensajeserror.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_tortilla", nullable = false)
    private String tipo_tortilla;

    @Column(name = "costo", nullable = false)
    private Double costo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

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

    public String getTipo_tortilla() {
        return tipo_tortilla;
    }

    public void setTipo_tortilla(String tipo_tortilla) {
        this.tipo_tortilla = tipo_tortilla;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Taco" + id + " de " + nombre + " con tortilla de " + tipo_tortilla + "\nCosto: " + costo + "\nEstado: "
                + estado;
    }
}
