package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManagement {

    private DatabaseInterface database;

    public EmployeeManagement(DatabaseInterface database) {
        this.database = database;
    }
    public double getAverageSalary() {
        List<Employee> employees = database.getEmployees();
        double sum = 0.0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }


    public double getAverageSalaryByGender(String gender) {
        List<Employee> employees = database.getEmployees();
        double sum = 0.0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getGender().equals(gender)) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

    public double getAverageAge() {
        List<Employee > employees = database.getEmployees();
        double average =0;
        int sum =0;

        for (Employee employee:employees){
            sum += employee.getAge();

        }
        return sum/employees.size();
    }
    public List<Employee> getTopPaidEmployees(){
        List<Employee > employees = database.getEmployees();
        List <Employee> TopPaid = new ArrayList<>(employees);
        Collections.sort(TopPaid, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });


return  TopPaid.subList(0,2);

    }

}
