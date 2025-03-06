package com.kunalTTNAssignment.RestfulAssignment2.Model;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name = "id", example = "1", required = false)
    Integer id;

    @Schema(name = "name", example = "Kunal Rawat", required = true)
    String name;

    @Schema(name = "age", example = "22", required = true)
    Integer age;
}

