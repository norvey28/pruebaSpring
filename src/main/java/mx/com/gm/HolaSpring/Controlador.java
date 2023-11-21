package mx.com.gm.HolaSpring;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author NORVEY
 */
@Controller
@Slf4j
public class Controlador {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Adios con Thymeleaf";
        
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@gmail.com");
        persona.setTelefono("3108177002");
        
        var persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Perez");
        persona2.setEmail("jperez@gmail.com");
        persona2.setTelefono("3108177002");
        
        List<Persona> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona2);
        
        log.info("Ejecutando controlador MVC 2");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
