package com.mydemo.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeListDto {

    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
}
