package org.src.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

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
