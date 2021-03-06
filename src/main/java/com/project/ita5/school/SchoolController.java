package com.project.ita5.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/school")
public class SchoolController {

    private SchoolServiceImpl schoolService;

    @Autowired
    public SchoolController(SchoolServiceImpl schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<String> fetchSchools() {
        return schoolService.fetchSchools();
    }

}
