package mx.unadmexico.rupe.converter;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import java.util.Collection;
import java.util.function.Function;
import org.springframework.core.convert.converter.Converter;

@FunctionalInterface
public interface RupeConverter<T, U> extends Converter<T, U>, Function<T, U> {

  @Override
  default U apply(T t) {
    return convert(t);
  }

  default Collection<U> apply(Collection<T> ts) {
    return convert(ts);
  }

  default Collection<U> convert(Collection<T> ts) {
    return emptyIfNull(ts).stream().map(this).toList();
  }
}
