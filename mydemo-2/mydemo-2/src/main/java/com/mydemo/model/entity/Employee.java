package com.mydemo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
@Setter
@Getter
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Employee_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Hire_Date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "Job_Title", nullable = true)
    private String jobTitle;

    @Column(name = "Salary", nullable = true)
    private BigDecimal salary;

    @Column(name = "Branch_ID")
    private String branchID;

    @Column(name = "Is_Active", nullable = false)
    private Boolean isActive;

    @Column(name = "Create_Date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "Update_Date", nullable = true)
    private LocalDateTime updateDate;
}
