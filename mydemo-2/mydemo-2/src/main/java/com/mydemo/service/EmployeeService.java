package com.mydemo.service;

import com.mydemo.model.data.BranchDto;
import com.mydemo.model.data.EmployeeDto;
import com.mydemo.model.data.EmployeeListDto;
import com.mydemo.model.entity.Employee;
import com.mydemo.model.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ApiService apiService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    public List<EmployeeListDto> getAllEmployees() {
        return employeeRepo.findAllEmployee();
    }

    public Page<EmployeeListDto> getAllEmployeesByPage(Pageable pageable) {
        try {
            return employeeRepo.findAllEmployeeByPage(pageable);
        } catch (Exception e) {
            logger.error("Error getting all employees by page: {}", e.getMessage());
            return Page.empty();
        }
    }

  @Transactional
  public Map<String, Object> getEmployeeById(Integer employeeID) {
    try {
        Employee employee = employeeRepo.findById(employeeID).orElseThrow(() -> new Exception("Employee not found"));
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhoneNumber(), employee.getHireDate(), employee.getJobTitle(), employee.getSalary(), employee.getBranchID(), employee.getIsActive());
        BranchDto branchDto = apiService.getBranch(employee.getBranchID());
        Map<String, Object> result = new HashMap<>();
        result.put("employee", employeeDto);
        result.put("branch", branchDto);

        return result;
    } catch (Exception e) {
        logger.error("Error getting employee by id: {}", e.getMessage());
        return Collections.emptyMap();
    }
}

    @Transactional
    public String saveEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee;
            if (employeeDto.getEmployeeID() != null) {
                employee = employeeRepo.findById(employeeDto.getEmployeeID()).orElseThrow(() -> new Exception("Employee not found"));

            } else {
                employee = new Employee();
                employee.setCreateDate(LocalDateTime.now());
            }
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employee.setHireDate(employeeDto.getHireDate());
            employee.setJobTitle(employeeDto.getJobTitle());
            employee.setSalary(employeeDto.getSalary());
            employee.setBranchID(employeeDto.getBranchID());
            employee.setIsActive(true);
            employeeRepo.save(employee);
            logger.info("Employee saved successfully");
            return "Employee saved successfully";
        } catch (Exception e) {
            logger.error("Failed to save employee: {}", e.getMessage());
            return "Failed to save employee";
        }
    }

    @Transactional
    public String deleteEmployee(Integer employeeID) {
        try {
            Employee employee = employeeRepo.findById(employeeID).orElseThrow(() -> new Exception("Employee not found"));
            employee.setIsActive(false);
            employee.setUpdateDate(LocalDateTime.now());
            employeeRepo.save(employee);
            logger.info("Employee deleted successfully");
            return "Employee deleted successfully";
        } catch (Exception e) {
            logger.error("Failed to delete employee: {}", e.getMessage());
            return "Failed to delete employee";
        }
    }



}
