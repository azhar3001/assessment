package com.mydemo.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchDto {

    private String branchName;
    private String branchCity;
    private String branchPic;

}
