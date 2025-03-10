package com.kunalTTNAssignment.RestfulAssignment2.Service;

import com.kunalTTNAssignment.RestfulAssignment2.Controller.TopicController;
import com.kunalTTNAssignment.RestfulAssignment2.DTO.UserDTO;
import com.kunalTTNAssignment.RestfulAssignment2.DTO.UserDTOImplementation;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserVersioningService {

    UserRepository userRepository;
    UserDTOImplementation userDTOImplementation;

    @Autowired
    UserVersioningService(UserRepository userRepository, UserDTOImplementation userDTOImplementation)
    {
        this.userDTOImplementation=userDTOImplementation;
        this.userRepository=userRepository;
    }

    public User getUserByIdV1(Integer id)
    {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public UserDTO getUserByIdV2(Integer id)
    {
        return userDTOImplementation.getUserById(id);
    }
}
