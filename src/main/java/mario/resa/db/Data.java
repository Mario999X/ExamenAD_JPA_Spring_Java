package mario.resa.db;

import mario.resa.models.Batalla;
import mario.resa.models.Nave;
import mario.resa.enums.TipoNave;
import mario.resa.models.Piloto;

import java.time.LocalDate;
import java.util.List;

public final class Data {
    public static List<Nave> getNavesInit() {
        return List.of(
                new Nave(TipoNave.T_FIGHTER, false),
                new Nave(TipoNave.T_FIGHTER, true),
                new Nave(TipoNave.X_WIND, true),
                new Nave(TipoNave.X_WIND, false)
        );
    }

    public static List<Piloto> getPilotosInit() {
        return List.of(
                new Piloto("Kratos", "Tierra", LocalDate.now().minusYears(2), false),
                new Piloto("Atreus", "Tierra", LocalDate.now().minusYears(1), false),
                new Piloto("Obi-Wan", "Desconocido", LocalDate.now(), true),
                new Piloto("Anakin", "Desconocido", LocalDate.now(), false)
        );
    }

    public static List<Batalla> getBatallasInit() {
        return List.of(
                new Batalla("Sturno", LocalDate.now().minusYears(2)),
                new Batalla("Plutan", LocalDate.now().minusYears(5))
        );
    }
}
