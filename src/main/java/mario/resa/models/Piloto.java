package mario.resa.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pilotos")
public class Piloto {
    private UUID id = UUID.randomUUID();
    private String nombre;
    private String planetaOrigen;
    private LocalDate fechaIncorporacion;
    private int experiencia;

    private Nave navePilotada;

    private boolean Capitan;

    private Batalla batalla;

    public Piloto() {
    }

    public Piloto(String nombre, String planetaOrigen, LocalDate fechaIncorporacion, boolean capitan) {
        this.nombre = nombre;
        this.planetaOrigen = planetaOrigen;
        this.fechaIncorporacion = fechaIncorporacion;
        experiencia = LocalDate.now().minusYears(fechaIncorporacion.getYear()).getYear();
        Capitan = capitan;
    }

    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "planeta_origen")
    public String getPlanetaOrigen() {
        return planetaOrigen;
    }

    public void setPlanetaOrigen(String planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    @Column(name = "fecha_incorporacion")
    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @OneToOne
    @JoinColumn(name = "nave_pilotada", referencedColumnName = "id", nullable = true)
    public Nave getNavePilotada() {
        return navePilotada;
    }

    public void setNavePilotada(Nave navePilotada) {
        this.navePilotada = navePilotada;
    }

    public boolean isCapitan() {
        return Capitan;
    }

    public void setCapitan(boolean capitan) {
        Capitan = capitan;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = true)
    public Batalla getBatalla() {
        return batalla;
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", planetaOrigen='" + planetaOrigen + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", experiencia=" + experiencia +
                ", navePilotada=" + navePilotada +
                ", Capitan=" + Capitan +
                ", batalla=" + batalla +
                '}';
    }
}
