package com.mydemo.controller;

import com.mydemo.model.data.EmployeeDto;
import com.mydemo.model.data.EmployeeListDto;
import com.mydemo.model.entity.Employee;
import com.mydemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    private final EmployeeService employeeService;


    @GetMapping("/")
    public String hello() {
        return "Hello, Guys!";
    }

    @GetMapping("/listAll")
    public List<EmployeeListDto> listAll() {
        logger.info("List all employees");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/listAllByPage")
    public Page<EmployeeListDto> listAllByPage(Pageable pageable) {
        logger.info("List all employees by page");
        return employeeService.getAllEmployeesByPage(pageable);
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(EmployeeDto employeeDto) {
        logger.info("Save employee");
        return employeeService.saveEmployee(employeeDto);

    }

    @PostMapping("/saveEmployee2")
    public ResponseEntity<Employee> saveEmployee2(@RequestBody EmployeeDto employeeDto) {
        // Add any validation if needed
        if (employeeDto.getEmail() == null || employeeDto.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Bad request if email is not provided
        }

        Employee savedEmployee = employeeService.saveEmployee2(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(Integer employeeID) {
        logger.info("Delete employee");
        return employeeService.deleteEmployee(employeeID);

    }

    @PostMapping("/getEmployeeById")
    public Map<String, Object> getEmployeeById(Integer employeeID) {
        logger.info("Get employee by id");
        logger.info("Request info:: " + employeeID);

        return employeeService.getEmployeeById(employeeID);
    }

}
