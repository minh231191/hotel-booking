package com.hotelbooking.hotel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "hotel")
public class Amenity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amenity_id_seq")
  @SequenceGenerator(name = "amenity_id_seq", allocationSize = 1)
  private Long id;

  private String name;
  private String code;
  private String iconLink;
  private String description;
  private Integer amenityOrder = 0;

  @ManyToMany(mappedBy = "amenities")
  private Set<Room> rooms;

  @ManyToMany(mappedBy = "amenities")
  private Set<Hotel> hotel;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Amenity amenity = (Amenity) o;
    return Objects.equals(id, amenity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
