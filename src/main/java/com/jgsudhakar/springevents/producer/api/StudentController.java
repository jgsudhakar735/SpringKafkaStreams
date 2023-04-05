package com.jgsudhakar.springevents.producer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jgsudhakar.springevents.common.model.StudentInfo;
import com.jgsudhakar.springevents.producer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*************************************
 * This Class is used to Author : Sudhakar Tangellapalli File :
 * com.jgsudhakar.springevents.producer.api.StudentController Date : 26-03-2023
 * Version : 1.0
 **************************************/

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public StudentInfo save(@RequestBody StudentInfo studentInfo) throws JsonProcessingException {
		return studentService.register(studentInfo);
	}
}
