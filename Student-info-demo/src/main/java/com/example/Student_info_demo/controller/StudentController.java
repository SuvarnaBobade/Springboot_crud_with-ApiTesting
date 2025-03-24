package com.example.Student_info_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_info_demo.entity.Student;
import com.example.Student_info_demo.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/insert-student-info")
	public String insertData(@RequestBody Student s) {
		String msg = service.insertData(s);
		return msg;
	}
	@GetMapping("/getSingelerecord")
	public Student getSingeleRecord(@RequestParam int id) {
		Student s = service.getSingeleRecord(id);
		return s;
	}
	@GetMapping("/getAllrecord")
	public List<Student> getAllRecord() {
		List<Student> list = service.getAllRecord();
		return list;
	}
	@PutMapping("/update")
	public String update( @RequestBody Student s, @RequestParam int id) {
		String msg = service.update(s, id);
		return msg;

	}
	@DeleteMapping("/deleterecord")
	public String deleteRecord( @RequestParam int id) {
		String msg = service.deleteRecord(id);
		return msg;
	}
}
