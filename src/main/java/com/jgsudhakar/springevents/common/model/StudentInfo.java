package com.jgsudhakar.springevents.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.producer.api.StudentInfo
 * Date    : 26-03-2023
 * Version : 1.0
 **************************************/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo  {

    private String studentId;

    private String studentName;

    private String studentMobileNo;

    private String studentEmailId;

    private String studentAddress;

    private String studentClass;

    private String studentClassYear;

    private String studentClassBranch;

    private String uniqueId;

}
