package com.aht.angularApi.controller;

import com.aht.angularApi.model.Employee;
import com.aht.angularApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity getAllEmp(){
        return new ResponseEntity(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity getEmpById(@PathVariable int id){
        return new ResponseEntity(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/employee/type")
    public ResponseEntity getEmpByType(@Param("type")int type){
        return new ResponseEntity(employeeService.getEmpByType(type),HttpStatus.OK);
    }

    @GetMapping("/employee/sex")
    public ResponseEntity getEmpBySex(@Param("sex")int sex){
        return new ResponseEntity(employeeService.getEmpBySex(sex),HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity addEmp(@RequestBody Employee employee){
        employeeService.addEmp(employee);
        return new ResponseEntity("Added!", HttpStatus.CREATED);
    }

    @PostMapping("/employee/multi")
    public ResponseEntity addEmps(@RequestBody List<Employee> employeeList){
        employeeService.addEmps(employeeList);
        return new ResponseEntity("Added "+employeeList.size()+" employee!", HttpStatus.CREATED);
    }

    @DeleteMapping("/employee")
    public ResponseEntity deleteEmp(@Param("id") int id){
        employeeService.removeEmpById(id);
        return new ResponseEntity("Deleted!",HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity updateEmp(@PathVariable int id,@RequestBody Employee employee){
        employeeService.updateEmp(id,employee);
        return new ResponseEntity("Updated!",HttpStatus.OK);
    }
}
