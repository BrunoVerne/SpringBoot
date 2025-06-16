package Spring.Proyecto.domain;

import jakarta.persistence.*;

@Entity
@Table(name="personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;
    @ManyToOne(cascade = CascadeType.ALL)
    PeliculaSerie asociada;

    public Personaje(){
    }

    public Personaje(String nombre, int edad, double peso, String historia, PeliculaSerie asociada) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.asociada = asociada;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public PeliculaSerie getAsociada() {
        return asociada;
    }

    public void setAsociada(PeliculaSerie asociada) {
        this.asociada = asociada;
    }


}
