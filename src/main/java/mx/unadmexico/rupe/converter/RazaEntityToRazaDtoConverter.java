package mx.unadmexico.rupe.converter;

import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.domain.entity.RazaEntity;
import org.springframework.stereotype.Component;

@Component
public class RazaEntityToRazaDtoConverter implements RupeConverter<RazaEntity, RazaDto> {

  @Override
  public RazaDto convert(RazaEntity entity) {
    return new RazaDto(entity.getId(), entity.getNombre(), entity.getDescripcion());
  }
}
