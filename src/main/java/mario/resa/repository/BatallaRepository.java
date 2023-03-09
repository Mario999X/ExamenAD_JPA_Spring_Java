package mario.resa.repository;

import mario.resa.models.Batalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BatallaRepository extends JpaRepository<Batalla, UUID> {
}
