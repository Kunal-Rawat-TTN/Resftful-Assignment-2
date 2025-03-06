package com.kunalTTNAssignment.RestfulAssignment2.Service;

import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUserList()
    {
        return userRepository.findAll();
    }

    public User getUserById(Integer id)
    {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void deleteUserById(Integer id)
    {
        userRepository.deleteById(id);
    }
}
