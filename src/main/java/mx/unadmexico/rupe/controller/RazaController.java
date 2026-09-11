package mx.unadmexico.rupe.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.dto.request.RazaRequest;
import mx.unadmexico.rupe.service.RazaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/raza")
@RequiredArgsConstructor
public class RazaController {

  private final RazaService service;

  @PostMapping
  public ResponseEntity<RazaDto> create(@RequestBody RazaRequest request) {
    final var raza = service.create(request);
    return ResponseEntity.created(URI.create("/api/raza/%d".formatted(raza.id()))).body(raza);
  }

  @GetMapping
  public ResponseEntity<Page<RazaDto>> getAll(Pageable pageable) {
    return ResponseEntity.ok(service.getAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RazaDto> getById(@PathVariable Long id) {
    return ResponseEntity.of(service.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<RazaDto> update(@PathVariable Long id, @RequestBody RazaRequest request) {
    return ResponseEntity.of(service.update(id, request));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<RazaDto> partialUpdate(
      @PathVariable Long id, @RequestBody RazaRequest request) {
    return ResponseEntity.of(service.partialUpdate(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
