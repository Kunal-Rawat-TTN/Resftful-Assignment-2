package com.kunalTTNAssignment.RestfulAssignment2.Controller;

import com.kunalTTNAssignment.RestfulAssignment2.DTO.UserDTO;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Service.UserVersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/version")
public class UserVersioningController {
    UserVersioningService userVersioningService;

    @Autowired
    UserVersioningController(UserVersioningService userVersioningService)
    {
        this.userVersioningService=userVersioningService;
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<User> getUserByIdV1(@PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV1(id), HttpStatus.OK);
    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<UserDTO> getUserByIdV2(@PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV2(id), HttpStatus.OK);
    }

    @GetMapping(path="/{id}",params = "version=1")
    public ResponseEntity<User> getUserByIdV1Params(@PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV1(id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}",params = "version=2")
    public ResponseEntity<UserDTO> getUserByIdV2Params( @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV2(id), HttpStatus.OK);
    }

    @GetMapping(path="/header/{id}",headers = "X-API-version=1")
    public ResponseEntity<User> getUserByIdV1Headers( @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV1(id), HttpStatus.OK);
    }

    @GetMapping(path = "/header/{id}",headers = "X-API-version=2")
    public ResponseEntity<UserDTO> getUserByIdV2Headers( @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV2(id), HttpStatus.OK);
    }

    @GetMapping(path="/accept/{id}",produces = "application/kunal.app-v1+json")
    public ResponseEntity<User> getUserByIdAcceptHeader( @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV1(id), HttpStatus.OK);
    }

    @GetMapping(path = "/accept/{id}",produces = "application/kunal.app-v2+json")
    public ResponseEntity<UserDTO> getUserByIdV2AcceptHeader( @PathVariable Integer id) {
        return new ResponseEntity<>(userVersioningService.getUserByIdV2(id), HttpStatus.OK);
    }
}
