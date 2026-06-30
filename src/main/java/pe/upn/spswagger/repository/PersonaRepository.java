package pe.upn.spswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upn.spswagger.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByDni(String dni);
}
