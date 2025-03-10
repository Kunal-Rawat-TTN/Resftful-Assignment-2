package com.kunalTTNAssignment.RestfulAssignment2.Controller;

import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "createUser", description = "Create a user using XML")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "404", description = "Not found - The user was not created")
    })
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @Operation(summary = "getUserList", description = "Returns a user list in XML")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }

    @Operation(summary = "getUserById", description = "Returns a user as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The user was not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@Parameter(name = "id", description = "User id", example = "1")
                                                @PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Operation(summary = "deleteUser", description = "Delete a user using user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not found - The user was not deleted")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@Parameter(name = "id", description = "User id", example = "1")
                                                     @PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User ID " + id + " deleted !", HttpStatus.OK);
    }

    @PostMapping("/staticPassword")
    public ResponseEntity<User> createUserWithStaticPassword(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.createUserWithPassword(user),HttpStatus.OK);
    }

    @PostMapping("/dynamicPassword")
    public ResponseEntity<MappingJacksonValue> createUserWithDynamicPassword(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.createUserWithDynamicPassword(user),HttpStatus.OK);
    }

}
