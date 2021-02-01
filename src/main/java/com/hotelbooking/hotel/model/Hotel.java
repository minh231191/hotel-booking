package com.hotelbooking.hotel.model;

import com.hotelbooking.common.model.AuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "hotel")
public class Hotel extends AuditableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
  @SequenceGenerator(name = "hotel_id_seq", allocationSize = 1)
  private Long id;

  private String name;
  private String code;
  private String shortDescription;
  @Column(length = 1000)
  private String description;
  private String address;
  private Double longtitude;
  private Double latitude;
  private Integer star;
  private String hotline;
  private String email;
  private String website;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      schema = "hotel",
      name = "hotel_amenity",
      joinColumns = @JoinColumn(name = "hotel_id"),
      inverseJoinColumns = @JoinColumn(name = "amenity_id")
  )
  private Set<Amenity> amenities = new HashSet<>();

}
