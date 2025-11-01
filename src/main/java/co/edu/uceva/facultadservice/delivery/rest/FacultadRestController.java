package co.edu.uceva.facultadservice.delivery.rest;

import co.edu.uceva.facultadservice.domain.exception.FacultadNoEncontradaException;
import co.edu.uceva.facultadservice.domain.exception.NoHayFacultadException;
import co.edu.uceva.facultadservice.domain.exception.PaginaSinFacultadException;
import co.edu.uceva.facultadservice.domain.services.IFacultadService;
import jakarta.validation.Valid;
import co.edu.uceva.facultadservice.domain.exception.ValidationException;
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
        List<Facultad> facultades = facultadService.findAll();
        if (facultades.isEmpty()) {
            throw new NoHayFacultadException();
        }
        Map<String, Object> response = new HashMap<>();
        response.put(FACULTADES, facultades);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/facultad/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Facultad> alojamientos = facultadService.findAll(pageable);
        if (alojamientos.isEmpty()) {
            throw new PaginaSinFacultadException(page);
        }
        return ResponseEntity.ok(alojamientos);
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


    @PutMapping("/facultades")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Facultad facultad, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        facultadService.findById(facultad.getId())
                .orElseThrow(() -> new FacultadNoEncontradaException(facultad.getId()));
        Map<String, Object> response = new HashMap<>();
        Facultad facultadActualizado = facultadService.update(facultad);
        response.put(MENSAJE, "La facultad ha sido actualizada con éxito!");
        response.put(FACULTAD, facultadActualizado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/facultades/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Facultad facultad = facultadService.findById(id)
                .orElseThrow(() -> new FacultadNoEncontradaException(id));
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "La facultad ha sido encontrada con éxito!");
        response.put(FACULTAD, facultad);
        return ResponseEntity.ok(response);
    }

}
