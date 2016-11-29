package com.javacodegeeks.examples.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by solocal-suresh on 29/11/2016.
 */
@Controller
@RequestMapping("emp")
public class EmployeeController {

    List<Employee> empList = new ArrayList<Employee>();

    @ResponseBody
    @RequestMapping(value = "employeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Employee>> getEmployeeList(){
        return new HttpEntity<List<Employee>>(buildEmployeeList());
    }

    @ResponseBody
    @RequestMapping(value = "deleteEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Employee>> deleteEmployee(@RequestParam(value = "empId") int empId){

        System.out.println("Emp Id-->"+empId);
        Iterator<Employee> employeeIterator = empList.iterator();
        while (employeeIterator.hasNext()){
            if(employeeIterator.next().getId() == empId) {
                employeeIterator.remove();
                break;
            }
        }

        System.out.println("Size of Emp List-->"+empList.size());
        return new HttpEntity<List<Employee>>(empList);
    }

    @ResponseBody
    @RequestMapping(value="addNewEmployee", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void addEmployee(@RequestParam (value= "empId") int empId, @RequestParam (value= "empName") String empName,
                            @RequestParam( value="description") String description){
        empList.add(new Employee(empId, empName , description));
    }

    @ResponseBody
    @RequestMapping(value = "addEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Employee>> AddEmployee(){
        return new HttpEntity<List<Employee>>(buildEmployeeList());
    }

    private List<Employee> buildEmployeeList(){
        empList.add(new Employee(1,"AAA", "aaaaaaaaaaaaaaaaa"));
        empList.add(new Employee(2,"BBB", "bbbbbbbbbbbbbbbbb"));
        empList.add(new Employee(3,"CCC", "ccccccccccccccccc"));
        empList.add(new Employee(4,"DDD", "ddddddddddddddddd"));
        empList.add(new Employee(5,"EEE", "eeeeeeeeeeeeeeeee"));
        return empList;
    }


}


class Employee {

    int id;
    String name;
    String designation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }
}
