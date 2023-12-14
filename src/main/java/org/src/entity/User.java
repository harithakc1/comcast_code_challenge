package org.src.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    private Long id;

    private String name;

    private Address address;
}
