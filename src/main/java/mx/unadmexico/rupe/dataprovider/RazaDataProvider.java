package mx.unadmexico.rupe.dataprovider;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mx.unadmexico.rupe.converter.RazaToRazaDtoConverter;
import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.domain.entity.Raza;
import mx.unadmexico.rupe.dto.request.RazaRequest;
import mx.unadmexico.rupe.repository.RazaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RazaDataProvider {

  private final RazaRepository repository;
  private final RazaToRazaDtoConverter razaToRazaDtoConverter;

  public RazaDto create(RazaRequest request) {
    return Optional.of(request)
        .map(r -> new Raza(null, r.nombre(), r.descripcion()))
        .map(repository::saveAndFlush)
        .map(razaToRazaDtoConverter)
        .orElseThrow();
  }

  public Page<RazaDto> getAll(Pageable pageable) {
    return repository.findAll(pageable).map(razaToRazaDtoConverter);
  }

  public Optional<RazaDto> getById(Long id) {
    return repository.findById(id).map(razaToRazaDtoConverter);
  }

  public Optional<RazaDto> update(Long id, RazaRequest request) {
    return repository
        .findById(id)
        .map(
            r -> {
              r.setNombre(request.nombre());
              r.setDescripcion(request.descripcion());
              return r;
            })
        .map(repository::save)
        .map(razaToRazaDtoConverter);
  }

  public Optional<RazaDto> partialUpdate(Long id, RazaRequest request) {
    return repository
        .findById(id)
        .map(
            r -> {
              if (isNotBlank(request.nombre())) {
                r.setNombre(request.nombre());
              }

              if (isNotBlank(request.descripcion())) {
                r.setDescripcion(request.descripcion());
              }
              return r;
            })
        .map(repository::save)
        .map(razaToRazaDtoConverter);
  }

  public void delete(Long id) {
    repository.findById(id).ifPresent(repository::delete);
  }
}
