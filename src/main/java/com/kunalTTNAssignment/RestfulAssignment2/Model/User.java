package com.kunalTTNAssignment.RestfulAssignment2.Model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonFilter("passwordFilter")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name = "id", example = "1", required = true)
    Integer id;

    @Schema(name = "name", example = "Kunal Rawat", required = true)
    String name;

    @Schema(name = "age", example = "22", required = true)
    Integer age;

//    @JsonIgnore
    String password;
}

