package com.mydemo.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Employee")
public class EmployeeDto {

    @Schema(description = "Unique identifier of the employee", example = "1", required = true)
    private Integer employeeID;

    @Schema(description = "First name of the employee", example = "John", required = true)
    private String firstName;

    @Schema(description = "Last name of the employee", example = "Doe", required = true)
    private String lastName;

    @Schema(description = "Email address of the employee", example = "john.doe@example.com", required = true)
    private String email;

    @Schema(description = "Phone number of the employee", example = "012-3456789", required = true)
    private String phoneNumber;

    @Schema(description = "Hire date of the employee", example = "2023-01-01", required = true)
    private LocalDate hireDate;

    @Schema(description = "Job title of the employee", example = "Software Engineer", required = true)
    private String jobTitle;

    @Schema(description = "Salary of the employee", example = "75000.00", required = false)
    private BigDecimal salary;

    @Schema(description = "Branch ID of the employee", example = "101", required = false)
    private String branchID;

    @Schema(description = "Active status of the employee", example = "true", required = true)
    private Boolean isActive;
}
