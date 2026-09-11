package mx.unadmexico.rupe.domain.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Raza", schema = "rupe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RazaEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 25)
  private String nombre;

  @Column(nullable = false, unique = true, length = 100)
  private String descripcion;
}
