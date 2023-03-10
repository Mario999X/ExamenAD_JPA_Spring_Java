package mario.resa.controllers;

import mario.resa.models.Batalla;
import mario.resa.models.Nave;
import mario.resa.models.Piloto;
import mario.resa.repository.BatallaRepository;
import mario.resa.repository.NaveRepository;
import mario.resa.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ExamenController {

    private final NaveRepository naveRepository;
    private final PilotoRepository pilotoRepository;
    private final BatallaRepository batallaRepository;

    @Autowired
    public ExamenController(NaveRepository naveRepository, PilotoRepository pilotoRepository, BatallaRepository batallaRepository) {
        this.naveRepository = naveRepository;
        this.pilotoRepository = pilotoRepository;
        this.batallaRepository = batallaRepository;
    }

    // -- NAVES --
    public List<Nave> getNaves() {
        System.out.println("\t -> Obteniendo naves");
        return naveRepository.findAll();
    }

    public Nave createNave(Nave nave) {
        System.out.println("\t -> Insertando: " + nave);
        return naveRepository.save(nave);
    }

    public Nave getNaveById(UUID id) {
        System.out.println("\t -> Buscando nave con id: " + id);
        return naveRepository.findById(id).orElse(null); // Asi se parece a Kotlin en vez de usar Optional, luego
        // Habra que controlar el null con un if, por ejemplo, donde se ejecute el metodo
    }

    public Nave updateNave(Nave nave) {
        System.out.println("\t -> Actualizando: " + nave);
        return naveRepository.save(nave);
    }

    public Boolean deleteNave(Nave nave) {
        System.out.println("\t -> Borrando: " + nave);
        naveRepository.delete(nave);
        return true;
    }

    // -- PILOTOS --
    public List<Piloto> getPilotos() {
        System.out.println("\t -> Obteniendo pilotos");
        return pilotoRepository.findAll();
    }

    public Piloto createPiloto(Piloto piloto) {
        System.out.println("\t -> Insertando: " + piloto);
        return pilotoRepository.save(piloto);
    }

    public Piloto getPilotoById(UUID id) {
        System.out.println("\t -> Buscando piloto con id: " + id);
        return pilotoRepository.findById(id).orElse(null);
    }

    public Piloto updatePiloto(Piloto piloto) {
        System.out.println("\t -> Actualizando: " + piloto);
        return pilotoRepository.save(piloto);
    }

    public Boolean deletePiloto(Piloto piloto) {
        System.out.println("\t -> Borrando: " + piloto);
        pilotoRepository.delete(piloto);
        return true;
    }

    // -- BATALLAS --
    public List<Batalla> getBatallas() {
        System.out.println("\t -> Obteniendo batallas");
        return batallaRepository.findAll();
    }

    public Batalla createBatalla(Batalla batalla) {
        System.out.println("\t -> Insertando: " + batalla);
        int capitan = pilotoRepository.findAll().stream().filter(it -> it.getBatalla() == batalla).filter(Piloto::isCapitan).toList().size();

        if (capitan >= 2) {
            System.err.println("Error en la creacion de " + batalla + " | Exceso de capitanes " + capitan);
        } else batallaRepository.save(batalla);

        return batalla;
    }

    public Batalla getBatallaById(UUID id) {
        System.out.println("\t -> Buscando batalla con id: " + id);
        return batallaRepository.findById(id).orElse(null);
    }

    public Batalla updateBatalla(Batalla batalla) {
        System.out.println("\t -> Actualizando: " + batalla);
        int capitan = pilotoRepository.findAll().stream().filter(it -> it.getBatalla() == batalla).filter(Piloto::isCapitan).toList().size();

        if (capitan >= 2) {
            System.err.println("Error en la actualizacion de " + batalla + " | Exceso de capitanes " + capitan);
        } else batallaRepository.save(batalla);

        return batalla;
    }

    public Boolean deleteBatalla(Batalla batalla) {
        System.out.println("\t -> Borrando: " + batalla);
        batallaRepository.delete(batalla);
        return true;
    }
}
