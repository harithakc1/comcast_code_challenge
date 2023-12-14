package org.src.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Setter
@Getter
@Entity
@Data
public class Address {

    @Id
    private Long Id;

    private Long apartmentNo;

    private String apartmentName;

    private String streetName;

    private String city;

    private Long pincode;
}
