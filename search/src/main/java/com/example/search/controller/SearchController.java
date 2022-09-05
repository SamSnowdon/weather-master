package com.example.search.controller;

import com.example.search.exception.NotFoundException;
import com.example.search.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final EmployeeService employeeService;

    public SearchController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @HystrixCommand(fallbackMethod = "fallbackError")
    @GetMapping("/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        try {
            return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
        }catch (NotFoundException ne){
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<String> fallbackError(){
        return new ResponseEntity<>("Service Unavailable", HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
