package mario.resa.controllers;

import mario.resa.enums.TipoNave;
import mario.resa.models.Batalla;
import mario.resa.models.Nave;
import mario.resa.models.Piloto;
import mario.resa.repository.BatallaRepository;
import mario.resa.repository.NaveRepository;
import mario.resa.repository.PilotoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ExamenControllerTest {

    @Mock
    private final NaveRepository naveRepository;

    @Mock
    private final PilotoRepository pilotoRepository;

    @Mock
    private final BatallaRepository batallaRepository;

    @InjectMocks
    private ExamenController examenController;

    @Autowired
    public ExamenControllerTest(NaveRepository naveRepository, PilotoRepository pilotoRepository, BatallaRepository batallaRepository) {
        this.naveRepository = naveRepository;
        this.pilotoRepository = pilotoRepository;
        this.batallaRepository = batallaRepository;
    }

    private final Nave nave = new Nave(TipoNave.T_FIGHTER, false);
    private final Piloto piloto = new Piloto("TEST", "TEST_PLANET", LocalDate.now().minusYears(10), false);
    private final Batalla batalla = new Batalla("TEST_PLANET_2", LocalDate.now().minusYears(10));


    @Test
    void getNaves() {
        Mockito.when(naveRepository.findAll()).thenReturn(List.of(nave));

        List<Nave> response = examenController.getNaves();

        assertAll(
                () -> assertTrue(response.size() > 0)
        );
    }

    @Test
    void createNave() {
        Mockito.when(naveRepository.save(any())).thenReturn(nave);

        Nave response = examenController.createNave(nave);

        assertAll(
                () -> assertEquals(response.isSaltoHiperEspacial(), nave.isSaltoHiperEspacial())
        );

        Mockito.verify(naveRepository).save(any());
    }

    @Test
    void getNaveById() {
        Mockito.when(naveRepository.findById(any())).thenReturn(Optional.of(nave));

        Nave response = examenController.getNaveById(nave.getId());

        assertAll(
                () -> assertEquals(response.isSaltoHiperEspacial(), nave.isSaltoHiperEspacial())
        );

        Mockito.verify(naveRepository).findById(any());
    }

    @Test
    void updateNave() {
        Mockito.when(naveRepository.save(any())).thenReturn(nave);

        Nave response = examenController.updateNave(nave);

        assertAll(
                () -> assertEquals(response.isSaltoHiperEspacial(), nave.isSaltoHiperEspacial())
        );

        Mockito.verify(naveRepository).save(any());
    }

    @Test
    void deleteNave() {
        Mockito.when(naveRepository.findById(any())).thenReturn(Optional.of(nave));

        Boolean response = examenController.deleteNave(nave);

        assertAll(
                () -> assertEquals(response, true)
        );

        Mockito.verify(naveRepository).delete(any());
    }

    @Test
    void getPilotos() {
        Mockito.when(pilotoRepository.findAll()).thenReturn(List.of(piloto));

        List<Piloto> response = examenController.getPilotos();

        assertAll(
                () -> assertTrue(response.size() > 0)
        );
    }

    @Test
    void createPiloto() {
        Mockito.when(pilotoRepository.save(any())).thenReturn(piloto);

        Piloto response = examenController.createPiloto(piloto);

        assertAll(
                () -> assertEquals(response.isCapitan(), piloto.isCapitan())
        );

        Mockito.verify(pilotoRepository).save(any());
    }

    @Test
    void getPilotoById() {
        Mockito.when(pilotoRepository.findById(any())).thenReturn(Optional.of(piloto));

        Piloto response = examenController.getPilotoById(piloto.getId());

        assertAll(
                () -> assertEquals(response.isCapitan(), piloto.isCapitan())
        );

        Mockito.verify(pilotoRepository).findById(any());
    }

    @Test
    void updatePiloto() {
        Mockito.when(pilotoRepository.save(any())).thenReturn(piloto);

        Piloto response = examenController.updatePiloto(piloto);

        assertAll(
                () -> assertEquals(response.isCapitan(), piloto.isCapitan())
        );

        Mockito.verify(pilotoRepository).save(any());
    }

    @Test
    void deletePiloto() {
        Mockito.when(pilotoRepository.findById(any())).thenReturn(Optional.of(piloto));

        Boolean response = examenController.deletePiloto(piloto);

        assertAll(
                () -> assertEquals(response, true)
        );

        Mockito.verify(pilotoRepository).delete(any());
    }

    @Test
    void getBatallas() {
        Mockito.when(batallaRepository.findAll()).thenReturn(List.of(batalla));

        List<Batalla> response = examenController.getBatallas();

        assertAll(
                () -> assertTrue(response.size() > 0)
        );
    }

    @Test
    void createBatalla() {
        Mockito.when(batallaRepository.save(any())).thenReturn(batalla);

        Batalla response = examenController.createBatalla(batalla);

        assertAll(
                () -> assertEquals(response.getPlaneta(), batalla.getPlaneta())
        );

        Mockito.verify(batallaRepository).save(any());
    }

    @Test
    void getBatallaById() {
        Mockito.when(batallaRepository.findById(any())).thenReturn(Optional.of(batalla));

        Batalla response = examenController.getBatallaById(batalla.getId());

        assertAll(
                () -> assertEquals(response.getPlaneta(), batalla.getPlaneta())
        );

        Mockito.verify(batallaRepository).findById(any());
    }

    @Test
    void updateBatalla() {
        Mockito.when(batallaRepository.save(any())).thenReturn(batalla);

        Batalla response = examenController.updateBatalla(batalla);

        assertAll(
                () -> assertEquals(response.getPlaneta(), batalla.getPlaneta())
        );

        Mockito.verify(batallaRepository).save(any());
    }

    @Test
    void deleteBatalla() {
        Mockito.when(batallaRepository.findById(any())).thenReturn(Optional.of(batalla));

        Boolean response = examenController.deleteBatalla(batalla);

        assertAll(
                () -> assertEquals(response, true)
        );

        Mockito.verify(batallaRepository).delete(any());
    }
}