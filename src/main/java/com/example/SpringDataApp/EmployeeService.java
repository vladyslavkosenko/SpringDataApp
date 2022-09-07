package com.example.SpringDataApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostConstruct
    void init() {
        Employee employee1 = new Employee("Adam", 25);
        Employee employee2 = new Employee("Eve", 24);
        employeeRepository.saveAll(Arrays.asList(employee1, employee2));
    }
}
