package pe.upn.spswagger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.upn.spswagger.dto.PersonaDTO;

public interface PersonaService {
    Page<PersonaDTO> listar(Pageable pageable);
    PersonaDTO obtenerPorId(Long id);
    PersonaDTO crear(PersonaDTO personaDTO);
    PersonaDTO actualizar(Long id, PersonaDTO personaDTO);
    void eliminar(Long id);
    int sembrarDatosDemo();
}
