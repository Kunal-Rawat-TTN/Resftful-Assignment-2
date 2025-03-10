package com.kunalTTNAssignment.RestfulAssignment2.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @GetMapping
    public List<String> getAllTopics() {
        return Arrays.asList("Spring Boot", "HATEOAS", "REST APIs");
    }
}
