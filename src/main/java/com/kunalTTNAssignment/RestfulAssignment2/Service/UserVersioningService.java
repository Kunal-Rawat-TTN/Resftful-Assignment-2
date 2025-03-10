package com.kunalTTNAssignment.RestfulAssignment2.Service;


import com.kunalTTNAssignment.RestfulAssignment2.DTO.UserDTO;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserVersioningService {

    UserRepository userRepository;

    @Autowired
    UserVersioningService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User getUserByIdV1(Integer id)
    {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public UserDTO getUserByIdV2(Integer id)
    {
        return new UserDTO(userRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
