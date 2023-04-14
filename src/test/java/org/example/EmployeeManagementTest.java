package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeManagementTest {
    @Mock
    private DatabaseInterface databaseInterface; //this is equivalent to
    //  DatabaseInterface databaseInterface = mock(DatabaseInterface.class);
    @Test
    public void getAverageSalaryTest(){
        //Given

        List<Employee> employees = new ArrayList<>(); //the preconfigure value
        employees.add(new Employee("Sara",20,"woman",2000));

        //when any specific method is called
        // then return preconfigure response

        //use the dummy value of database interface to use the method of employeeManagement

        EmployeeManagement employeeManagement = new EmployeeManagement(databaseInterface);
        //Instead of having the argument with the class employee we wrote
        // the interface that inhold the list of employees and mock it to avoid manipulation with the database

        when(databaseInterface.getEmployees()).thenReturn(employees);

        //When
double averageSalary =employeeManagement.getAverageSalary();
        //Then
assertEquals(2000,averageSalary);
verify(databaseInterface).getEmployees();
//verify(databaseInterface,times(1)).getEmployees();

    }


    @Test
    public void getAverageSalaryByGenderTest(){
        //Given
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Viktor",33,"Man",3000));
        employees.add(new Employee("Sara",33,"Female",5000));
        employees.add(new Employee("Amr",33,"Man",4000));
        when(databaseInterface.getEmployees()).thenReturn(employees);
        EmployeeManagement employeeManagement = new EmployeeManagement(databaseInterface);
        //When
        double averageSalaryByGender = employeeManagement.getAverageSalaryByGender(employees.get(1).getGender());
        //Then
        assertEquals(5000,averageSalaryByGender);
        //we can use the verify() method to ensure that the getEmployees()
        // method of the mock object was called exactly once during the test.
        // In this case, we are expecting the method to be called once because
        // we only added one employee to the list.
        verify(databaseInterface,times(1)).getEmployees();
    }

    @Test
    public void getAverageAgeTest(){
        //Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Viktor",30,"Man",3000));
        employees.add(new Employee("Sara",40,"Female",5000));
        employees.add(new Employee("Elin",50,"Man",4000));
        when(databaseInterface.getEmployees()).thenReturn(employees);
        EmployeeManagement employeeManagement = new EmployeeManagement(databaseInterface);
        //When
        double ageAverage= employeeManagement.getAverageAge();
        //then
        assertEquals(40,ageAverage);
        verify(databaseInterface,times(1)).getEmployees();

    }
    @Test
    public void getTopPaidEmployeesTest(){
        //When
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Viktor",30,"Man",3000));
        employees.add(new Employee("Sara",40,"Female",5000));
        employees.add(new Employee("Taliah",50,"Man",20000));
        employees.add(new Employee("Nelly",30,"Man",30000));
        employees.add(new Employee("Ulf",40,"Female",5000));
        employees.add(new Employee("Elin",50,"female",40000));
        employees.add(new Employee("Alina",30,"Man",3000));
        employees.add(new Employee("younis",40,"Female",5000));
        employees.add(new Employee("Kim",50,"Man",4000));
        when(databaseInterface.getEmployees()).thenReturn(employees);
        EmployeeManagement employeeManagement = new EmployeeManagement(databaseInterface);

        List<Employee> employeesExpected = new ArrayList<>();
        employeesExpected.add(new Employee("Elin",50,"female",40000));
        employeesExpected.add(new Employee("Nelly",30,"Man",30000));




        //when
        List<Employee> subEmployees = employeeManagement.getTopPaidEmployees();

        //Then
        assertEquals(employeesExpected,subEmployees);
        verify(databaseInterface,times(1)).getEmployees();
    }




}