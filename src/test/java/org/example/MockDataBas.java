package org.example;

import java.util.List;

class DatabaseStub implements DatabaseInterface {
    private List<Employee> employees;

    public DatabaseStub(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}