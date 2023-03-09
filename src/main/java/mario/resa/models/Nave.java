package mario.resa.models;

import jakarta.persistence.*;
import mario.resa.enums.TipoNave;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "naves")
public class Nave {
    private UUID id = UUID.randomUUID();
    private TipoNave tipoNave;
    private LocalDate fechaAlta = LocalDate.now();
    private int misilesProtonicos;
    private boolean saltoHiperEspacial;

    public Nave() {
    }

    public Nave(TipoNave tipoNave, boolean saltoHiperEspacial) {
        this.tipoNave = tipoNave;
        this.misilesProtonicos = (int) (10 + Math.random() * 20);
        this.saltoHiperEspacial = saltoHiperEspacial;
    }

    @Id
    @GeneratedValue
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "tipo_nave")
    public TipoNave getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(TipoNave tipoNave) {
        this.tipoNave = tipoNave;
    }

    @Column(name = "fecha_alta")
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Column(name = "misiles_protonicos")
    public int getMisilesProtonicos() {
        return misilesProtonicos;
    }

    public void setMisilesProtonicos(int misilesProtonicos) {
        this.misilesProtonicos = misilesProtonicos;
    }

    @Column(name = "salto_hiper_espacial")
    public boolean isSaltoHiperEspacial() {
        return saltoHiperEspacial;
    }

    public void setSaltoHiperEspacial(boolean saltoHiperEspacial) {
        this.saltoHiperEspacial = saltoHiperEspacial;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id=" + id +
                ", tipoNave=" + tipoNave +
                ", fechaAlta=" + fechaAlta +
                ", misilesProtonicos=" + misilesProtonicos +
                ", saltoHiperEspacial=" + saltoHiperEspacial +
                '}';
    }
}

