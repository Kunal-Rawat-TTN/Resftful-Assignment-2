package com.kunalTTNAssignment.RestfulAssignment2.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public UserDTO(User user) {
        this.age = user.getAge();
        this.id = user.getId();
        String name= user.getName();
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ").length > 1 ? name.split(" ")[1] : "";
        this.password = user.getPassword();
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonIgnore
    private String password;
}
