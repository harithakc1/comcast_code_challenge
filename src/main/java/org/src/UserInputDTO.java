package org.src;

import lombok.*;
import org.src.entity.Address;
import org.src.entity.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInputDTO {

    private Long id;

    private String name;

    private Address address;

    public User toConvertUserEntity() {
        User user = new User();
        setId(user.getId());
        setName(user.getName());
        setAddress(user.getAddress());
        return user;
    }

}