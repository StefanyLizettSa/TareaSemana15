package pe.upn.spswagger.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upn.spswagger.dto.PersonaDTO;
import pe.upn.spswagger.exception.RecursoNoEncontradoException;
import pe.upn.spswagger.exception.ReglaNegocioException;
import pe.upn.spswagger.model.Persona;
import pe.upn.spswagger.repository.PersonaRepository;
import pe.upn.spswagger.seeder.PersonaSeeder;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {
    
    private final PersonaRepository personaRepository;
    private final PersonaSeeder personaSeeder;
    
    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaSeeder personaSeeder) {
        this.personaRepository = personaRepository;
        this.personaSeeder = personaSeeder;
    }
    
    @Override
    public Page<PersonaDTO> listar(Pageable pageable) {
        return personaRepository.findAll(pageable).map(this::convertirADTO);
    }
    
    @Override
    public PersonaDTO obtenerPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe una persona con id " + id));
        return convertirADTO(persona);
    }
    
    @Override
    public PersonaDTO crear(PersonaDTO personaDTO) {
        if (personaRepository.existsByDni(personaDTO.getDni())) {
            throw new ReglaNegocioException("Ya existe una persona con el dni " + personaDTO.getDni());
        }
        Persona persona = convertirAEntidad(personaDTO);
        persona.setId(null);
        return convertirADTO(personaRepository.save(persona));
    }
    
    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO personaDTO) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe una persona con id " + id));
        
        // Validar que el DNI no esté siendo usado por otra persona
        if (!persona.getDni().equals(personaDTO.getDni()) 
                && personaRepository.existsByDni(personaDTO.getDni())) {
            throw new ReglaNegocioException("Ya existe una persona con el dni " + personaDTO.getDni());
        }
        
        persona.setDni(personaDTO.getDni());
        persona.setApepaterno(personaDTO.getApepaterno());
        persona.setApematerno(personaDTO.getApematerno());
        persona.setNombres(personaDTO.getNombres());
        persona.setCorreo(personaDTO.getCorreo());
        
        return convertirADTO(personaRepository.save(persona));
    }
    
    @Override
    public void eliminar(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe una persona con id " + id);
        }
        personaRepository.deleteById(id);
    }
    
    @Override
    public int sembrarDatosDemo() {
        int insertados = 0;
        for (Persona persona : personaSeeder.obtenerPersonasDemo()) {
            if (!personaRepository.existsByDni(persona.getDni())) {
                personaRepository.save(persona);
                insertados++;
            }
        }
        return insertados;
    }
    
    // Métodos de conversión
    private PersonaDTO convertirADTO(Persona persona) {
        return new PersonaDTO(
                persona.getId(),
                persona.getDni(),
                persona.getApepaterno(),
                persona.getApematerno(),
                persona.getNombres(),
                persona.getCorreo()
        );
    }
    
    private Persona convertirAEntidad(PersonaDTO dto) {
        return new Persona(
                dto.getId(),
                dto.getDni(),
                dto.getApepaterno(),
                dto.getApematerno(),
                dto.getNombres(),
                dto.getCorreo()
        );
    }
}
