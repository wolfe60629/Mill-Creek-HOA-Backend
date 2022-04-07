package com.example.millcreekhoa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdministrationController {

    @GetMapping(value = "/admin")
    public List<String> getAdminValues () {
        List<String> returnList = new ArrayList<>();

        returnList.add("Test 1");

        return returnList;
    }
}
