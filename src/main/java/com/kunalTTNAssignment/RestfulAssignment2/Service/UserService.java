package com.kunalTTNAssignment.RestfulAssignment2.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kunalTTNAssignment.RestfulAssignment2.Controller.TopicController;
import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import com.kunalTTNAssignment.RestfulAssignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {
    MessageSource messageSource;
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, MessageSource messageSource)
    {
        this.userRepository=userRepository;
        this.messageSource = messageSource;
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUserList()
    {
        return userRepository.findAll();
    }

    public EntityModel<User> getUserById(Integer id)
    {
        User user=userRepository.findById(id).orElseThrow(NullPointerException::new);
        EntityModel<User> entityModel= EntityModel.of(user);
        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(methodOn(TopicController.class).getAllTopics());
        entityModel.add(link.withRel("all-topics"));
        return entityModel;
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

    public String getInternationalizedMessage(String username)
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", null, "Default Message", locale)+" "+username;
    }
}
