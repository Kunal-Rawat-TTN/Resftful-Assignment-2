package com.kunalTTNAssignment.RestfulAssignment2.Controller;

import com.kunalTTNAssignment.RestfulAssignment2.DTO.UserDTO;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Service.UserVersioningService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserVersioningController {
    UserVersioningService userVersioningService;

    @Autowired
    UserVersioningController(UserVersioningService userVersioningService)
    {
        this.userVersioningService=userVersioningService;
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<User> getUserByIdV1(@Parameter @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV1(id), HttpStatus.OK);
    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<UserDTO> getUserByIdV2(@Parameter @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV2(id), HttpStatus.OK);
    }
}
