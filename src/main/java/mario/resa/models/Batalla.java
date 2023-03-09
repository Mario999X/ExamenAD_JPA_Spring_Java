package mario.resa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "batallas")
public class Batalla {
    private UUID id = UUID.randomUUID();
    private String planeta;
    private LocalDate fecha;

    public Batalla() {
    }

    public Batalla(String planeta, LocalDate fecha) {
        this.planeta = planeta;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Batalla{" +
                "id=" + id +
                ", planeta='" + planeta + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
