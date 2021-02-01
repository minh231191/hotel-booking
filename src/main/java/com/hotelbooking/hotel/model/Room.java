package com.hotelbooking.hotel.model;

import com.hotelbooking.common.model.AuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "hotel")
public class Room extends AuditableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id_seq")
  @SequenceGenerator(name = "room_id_seq", allocationSize = 1)
  private Long id;

  private String name;
  private String code;
  @Column(length = 1000)
  private String description;
  private String shortDescription;
  private Double area;
  private Integer maxOccupancy;
  private Integer defaultOccupancy;
  private Integer maxAdult;
  private Integer maxChild;
  private boolean isActive = true;

  @ManyToOne(fetch = FetchType.LAZY)
  private Hotel hotel;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      schema = "hotel",
      name = "room_amenity",
      joinColumns = @JoinColumn(name = "room_id"),
      inverseJoinColumns = @JoinColumn(name = "amenity_id")
  )
  private Set<Amenity> amenities = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room room = (Room) o;
    return Objects.equals(id, room.id);
  }

  @Override
  public int hashCode() {
    return this.getClass().hashCode();
  }
}
