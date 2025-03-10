package com.kunalTTNAssignment.RestfulAssignment2.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    UserDTO(Integer id, String name, Integer age, String password) {
        this.age = age;
        this.id = id;
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ").length > 1 ? name.split(" ")[1] : "";
        this.password = password;
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonIgnore
    private String password;
}
