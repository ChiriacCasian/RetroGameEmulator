package com.gameTutorial.gameApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        return Arrays.asList(
                new Course(1, "muie", "ahaa"),
                new Course(2, "muiEEEEmareee", "ahaa"),
                new Course(3, "muiEEEEmareee", "ahaa")
        ) ;
    }
}
