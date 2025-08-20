package com.graphql.project.Graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeGraphQLController {

private final EmployeeRepository repository;

    public EmployeeGraphQLController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public List<Employee> employees() {
        return repository.findAll();
    }

    @QueryMapping
    public Employee employeeById(@Argument Long id) {
        return repository.findById(id).orElse(null);
    }

    @MutationMapping
    public Employee addEmployee(@Argument String name, @Argument String role) {
        return repository.save(new Employee(null, name, role));
    }


}
