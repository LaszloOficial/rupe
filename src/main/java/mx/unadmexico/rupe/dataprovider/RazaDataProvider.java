package mx.unadmexico.rupe.dataprovider;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mx.unadmexico.rupe.converter.RazaEntityToRazaDtoConverter;
import mx.unadmexico.rupe.converter.RazaRequestToRazaEntityConverter;
import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.dto.request.RazaRequest;
import mx.unadmexico.rupe.repository.RazaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RazaDataProvider {

  private final RazaRepository repository;
  private final RazaEntityToRazaDtoConverter razaEntityToRazaDtoConverter;
  private final RazaRequestToRazaEntityConverter razaRequestToRazaEntityConverter;

  public RazaDto create(RazaRequest request) {
    return Optional.of(request)
        .map(razaRequestToRazaEntityConverter)
        .map(repository::saveAndFlush)
        .map(razaEntityToRazaDtoConverter)
        .orElseThrow();
  }

  public Page<RazaDto> getAll(Pageable pageable) {
    return repository.findAll(pageable).map(razaEntityToRazaDtoConverter);
  }

  public Optional<RazaDto> getById(Long id) {
    return repository.findById(id).map(razaEntityToRazaDtoConverter);
  }

  public Optional<RazaDto> update(Long id, RazaRequest request) {
    return repository
        .findById(id)
        .map(
            raza -> {
              raza.setNombre(request.nombre());
              raza.setDescripcion(request.descripcion());
              return raza;
            })
        .map(repository::save)
        .map(razaEntityToRazaDtoConverter);
  }

  public Optional<RazaDto> partialUpdate(Long id, RazaRequest request) {
    return repository
        .findById(id)
        .map(
            raza -> {
              if (isNotBlank(request.nombre())) {
                raza.setNombre(request.nombre());
              }
              if (isNotBlank(request.descripcion())) {
                raza.setDescripcion(request.descripcion());
              }
              return raza;
            })
        .map(repository::save)
        .map(razaEntityToRazaDtoConverter);
  }

  public void delete(Long id) {
    repository.findById(id).ifPresent(repository::delete);
  }
}
