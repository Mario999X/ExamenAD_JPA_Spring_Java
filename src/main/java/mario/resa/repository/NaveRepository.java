package mario.resa.repository;

import mario.resa.models.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NaveRepository extends JpaRepository<Nave, UUID> {
}
