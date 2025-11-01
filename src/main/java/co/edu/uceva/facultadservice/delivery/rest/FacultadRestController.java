package co.edu.uceva.facultadservice.delivery.rest;

import co.edu.uceva.facultadservice.domain.services.IFacultadService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/facultad-service")
public class FacultadRestController {

    private IFacultadService facultadService;
    private static final String ERROR = "error";
    private static final String MENSAJE = "mensaje";
    private static final String FACULTAD = "facultad";
    private static final String FACULTADES = "facultades";

    public FacultadRestController(IFacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping("/facultades")
    public ResponseEntity<Map<String, Object>> getFacultades() {

        Map<String, Object> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/facultad/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);

    }

    @PostMapping("/facultades")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Facultad facultad, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Map<String, Object> response = new HashMap<>();
        Facultad nuevoAlojamiento = facultadService.save(facultad);
        response.put(MENSAJE, "El alojamiento ha sido creado con éxito!");
        response.put(FACULTAD, nuevoAlojamiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/facultades")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Facultad facultad) {
        facultadService.findById(facultad.getId())
                .orElseThrow(() -> new FacultadNoEncontradaException(facultad.getId()));
        facultadService.delete(facultad);
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "La facultad ha sido eliminada con éxito!");
        response.put(FACULTAD, null);
        return ResponseEntity.ok(response);
    }


}
