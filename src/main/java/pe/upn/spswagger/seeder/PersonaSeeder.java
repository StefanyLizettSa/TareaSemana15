package pe.upn.spswagger.seeder;
import org.springframework.stereotype.Component;
import pe.upn.spswagger.model.Persona;
import java.util.List;

@Component
public class PersonaSeeder {
public List<Persona> obtenerPersonasDemo() {
        return List.of(
            new Persona(null, "00331277", "Escalante", "Toribio", "Sandro Selim", "sandro.escalante@upn.pe"),
            new Persona(null, "00353863", "Sanchez", "Lozano", "Mirko Emerson", "mirko.sanchez@upn.pe"),
            new Persona(null, "00352336", "Zelada", "Centurion", "Carlo Aron", "carlo.zelada@upn.pe"),
            new Persona(null, "00354224", "Castrejon", "Tongombol", "Jamer Alexander", "jamer.castrejon@upn.pe"),
            new Persona(null, "00309779", "Rivera", "Garcia", "Franco Orestes", "franco.rivera@upn.pe"),
            new Persona(null, "00297543", "Sanchez", "Montoya", "Stefany Lizett", "stefany.sanchez@upn.pe"),
            new Persona(null, "00271864", "Arana", "Narro", "Cesar Enrique", "cesar.arana@upn.pe"),
            new Persona(null, "00229225", "Guevara", "Flores", "Luis Miguel", "luis.guevara@upn.pe"),
            new Persona(null, "00342055", "Huaripata", "Terrones", "Wilmer Jhanpier", "wilmer.huaripata@upn.pe"),
            new Persona(null, "00294896", "Jaeger", "Vigo", "Alejandro", "alejandro.jaeger@upn.pe"),
            new Persona(null, "00349051", "Alva", "Alvarez", "Diego Yerson", "diego.alva@upn.pe"),
            new Persona(null, "00345033", "Cerna", "Sanchez", "Standy Omar Alexander", "standy.cerna@upn.pe"),
            new Persona(null, "00389195", "Cotrina", "Ocas", "Keila Carmen", "keila.cotrina@upn.pe"),
            new Persona(null, "00193987", "Boñon", "Fernandez", "Josue Samuel", "josue.bonon@upn.pe"),
            new Persona(null, "00329682", "Huangal", "Briones", "Gibson Belizario", "gibson.huangal@upn.pe"),
            new Persona(null, "00323490", "Llanos", "Mendoza", "Lenis Jhonatan", "lenis.llanos@upn.pe"),
            new Persona(null, "00313511", "Medina", "Atalaya", "Edmar Arlen", "edmar.medina@upn.pe"),
            new Persona(null, "00373056", "Aguilar", "Garcia", "Luis Fernando", "luis.aguilar@upn.pe"),
            new Persona(null, "00371991", "Cortez", "Aguilar", "Yersi", "yersi.cortez@upn.pe"),
            new Persona(null, "00371313", "Quisquiche", "Carrera", "Brayan Jhoel", "brayan.quisquiche@upn.pe")
        );
    }
}
