package org.src.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.src.UserInputDTO;

@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    private Long id;

    private String name;

    private Address address;

    public UserInputDTO toConvertUserDTO() {
        UserInputDTO dto = new UserInputDTO();
        setId(dto.getId());
        setName(dto.getName());
        setAddress(dto.getAddress());
        return dto;
    }

}
