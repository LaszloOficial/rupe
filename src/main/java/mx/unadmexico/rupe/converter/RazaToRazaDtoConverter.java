package mx.unadmexico.rupe.converter;

import mx.unadmexico.rupe.domain.dto.RazaDto;
import mx.unadmexico.rupe.domain.entity.Raza;
import org.springframework.stereotype.Component;

@Component
public class RazaToRazaDtoConverter implements RupeConverter<Raza, RazaDto> {

  @Override
  public RazaDto convert(Raza raza) {
    return new RazaDto(raza.getId(), raza.getNombre(), raza.getDescripcion());
  }
}
