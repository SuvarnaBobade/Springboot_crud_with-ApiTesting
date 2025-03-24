package com.example.Student_info_demo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student_info_demo.dao.StudentDao;
import com.example.Student_info_demo.entity.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public String insertData(Student s) {
		String msg = dao.insertData(s);
		return msg;
	}

	public Student getSingeleRecord(int id) {
		Student s = dao.getSingeleRecord(id);
		return s;
	}

	public List<Student> getAllRecord() {
		List<Student> list = dao.getAllRecord();
		return list;
	}

	public String update(Student s, int id) {
		String msg = dao.update(s, id);
		return msg;

	}

	public String deleteRecord(int id) {
		String msg = dao.deleteRecord(id);
		return msg;
	}
}
