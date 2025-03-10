package com.kunalTTNAssignment.RestfulAssignment2.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    public User createUserWithPassword(User user)
    {
        return userRepository.save(user);
    }
    public MappingJacksonValue createUserWithDynamicPassword(User user)
    {
        User newUser = userRepository.save(user);
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(newUser);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "age");
        FilterProvider filters= new SimpleFilterProvider().addFilter("passwordFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
