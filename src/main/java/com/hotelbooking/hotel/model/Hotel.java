package com.hotelbooking.hotel.model;

import com.hotelbooking.common.model.AuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
  private String description;
  private String address;
  private Double longtitude;
  private Double latitude;
  private Integer star;
  private String hotline;
  private String email;
  private String website;

}
