package mx.unadmexico.rupe.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mx.unadmexico.rupe.dataprovider.RazaDataProvider;
import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.dto.request.RazaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RazaService {

  private final RazaDataProvider dataProvider;

  public RazaDto create(RazaRequest request) {
    return dataProvider.create(request);
  }

  public Page<RazaDto> getAll(Pageable pageable) {
    return dataProvider.getAll(pageable);
  }

  public Optional<RazaDto> getById(Long id) {
    return dataProvider.getById(id);
  }

  public Optional<RazaDto> update(Long id, RazaRequest request) {
    return dataProvider.update(id, request);
  }

  public Optional<RazaDto> partialUpdate(Long id, RazaRequest request) {
    return dataProvider.partialUpdate(id, request);
  }

  public void delete(Long id) {
    dataProvider.delete(id);
  }
}
