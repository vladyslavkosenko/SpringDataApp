package com.example.SpringDataApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringDataAppApplication {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public SpringDataAppApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    void init() {

        Employee employee1 = new Employee("a", 7);
        Employee employee2 = new Employee("b", 8);
        employeeRepository.saveAll(Arrays.asList(employee1, employee2));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAppApplication.class, args);
    }

}
