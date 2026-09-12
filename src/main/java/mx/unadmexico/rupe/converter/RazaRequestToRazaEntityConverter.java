package mx.unadmexico.rupe.converter;

import mx.unadmexico.rupe.domain.entity.RazaEntity;
import mx.unadmexico.rupe.dto.request.RazaRequest;
import org.springframework.stereotype.Component;

@Component
public class RazaRequestToRazaEntityConverter implements RupeConverter<RazaRequest, RazaEntity> {

  @Override
  public RazaEntity convert(RazaRequest request) {
    return new RazaEntity(null, request.nombre(), request.descripcion());
  }
}
