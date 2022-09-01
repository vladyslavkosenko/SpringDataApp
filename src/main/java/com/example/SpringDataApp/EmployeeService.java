package com.example.SpringDataApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostConstruct
    void init() {

        Employee employee1 = new Employee("a", 7);
        Employee employee2 = new Employee("b", 8);
        employeeRepository.saveAll(Arrays.asList(employee1, employee2));
    }
}
