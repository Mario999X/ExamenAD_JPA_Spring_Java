package mario.resa.repository;

import mario.resa.models.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, UUID> {
}
