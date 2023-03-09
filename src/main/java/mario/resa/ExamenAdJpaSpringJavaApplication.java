package mario.resa;

import mario.resa.controllers.ExamenController;
import mario.resa.db.Data;
import mario.resa.models.Batalla;
import mario.resa.models.Nave;
import mario.resa.enums.TipoNave;
import mario.resa.models.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExamenAdJpaSpringJavaApplication implements CommandLineRunner {

    @Autowired
    ExamenController examenController;

    public static void main(String[] args) {
        SpringApplication.run(ExamenAdJpaSpringJavaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("\t -- Iniciando demostracion examen Spring JPA Java -- \n");

        // -- CRUD NAVES --
        Data.getNavesInit().forEach(it -> examenController.createNave(it));

        List<Nave> listadoNaves = examenController.getNaves();

        listadoNaves.forEach(System.out::println);

        Nave naveExample = listadoNaves.get(3);
        System.out.println("1.-> " + naveExample);

        //naveExample.setId(UUID.randomUUID()); // Si queremos que no encuentre esa nave

        Nave naveOptional = examenController.getNaveById(naveExample.getId());

        if (naveOptional != null) {
            System.out.println("2.-> " + naveOptional);

            naveOptional.setTipoNave(TipoNave.X_WIND);
            System.out.println("3.-> " + examenController.updateNave(naveOptional));

            examenController.deleteNave(naveOptional);

            examenController.getNaves().forEach(System.out::println);
        } else System.out.println("2.-> Nave no localizada");

        // -- CRUD PILOTOS --
        List<Piloto> pilotosInit = Data.getPilotosInit();
        pilotosInit.get(0).setNavePilotada(listadoNaves.get(0));
        pilotosInit.get(1).setNavePilotada(listadoNaves.get(1));
        pilotosInit.get(2).setNavePilotada(listadoNaves.get(2));

        pilotosInit.forEach(it -> examenController.createPiloto(it));

        List<Piloto> listadoPilotos = examenController.getPilotos();

        listadoPilotos.forEach(System.out::println);

        Piloto pilotoExample = listadoPilotos.get(3);
        System.out.println("1.-> " + pilotoExample);

        Piloto pilotoOptional = examenController.getPilotoById(pilotoExample.getId());

        System.out.println("2.-> " + pilotoOptional);

        pilotoOptional.setNavePilotada(null);
        System.out.println("3.-> " + examenController.updatePiloto(pilotoOptional));

        examenController.deletePiloto(pilotoOptional);

        List<Piloto> listadoPilotosUpdate = examenController.getPilotos();
        listadoPilotosUpdate.forEach(System.out::println);

        // -- CRUD BATALLAS --
        Data.getBatallasInit().forEach(it -> examenController.createBatalla(it));

        List<Batalla> listadoBatallas = examenController.getBatallas();

        listadoBatallas.forEach(System.out::println);

        Batalla batallaOptional = examenController.getBatallaById(listadoBatallas.get(0).getId());

        System.out.println("1.-> " + batallaOptional);

        batallaOptional.setPlaneta("MartoH");
        examenController.updateBatalla(batallaOptional);

        listadoPilotos.get(0).setBatalla(batallaOptional);
        System.out.println("2.-> " + examenController.updatePiloto(pilotoOptional));

        examenController.deleteBatalla(listadoBatallas.get(1));
        examenController.getBatallas().forEach(System.out::println);
    }
}
