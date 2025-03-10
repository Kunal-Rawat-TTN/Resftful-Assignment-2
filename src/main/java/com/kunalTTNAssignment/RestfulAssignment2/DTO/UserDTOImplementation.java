//package com.kunalTTNAssignment.RestfulAssignment2.DTO;
//
//import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
//import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDTOImplementation {
//    UserRepository userRepository;
//
//    @Autowired
//    UserDTOImplementation(UserRepository userRepository)
//    {
//        this.userRepository=userRepository;
//    }
//    public UserDTO getUserById(Integer id)
//    {
//        User user= userRepository.findById(id).orElseThrow(NullPointerException::new);
//        return new UserDTO(user.getId(),user.getName(), user.getAge(),user.getPassword());
//    }
//}
