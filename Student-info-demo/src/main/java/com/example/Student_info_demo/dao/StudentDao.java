package com.example.Student_info_demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Student_info_demo.entity.Student;


@Repository
public class StudentDao {
	@Autowired
	SessionFactory sf;
	String msg;

	public String insertData(Student s) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlquery = " insert into Student(s_name,l_name,email)values(:fname,:lname,:email)";
		MutationQuery query = ss.createMutationQuery(hqlquery);
		query.setParameter("fname", s.getS_name());
		query.setParameter("lname", s.getL_name());
		query.setParameter("email", s.getEmail());
		query.executeUpdate();
		msg = "Data inserted sucessfully.....!";
		tr.commit();
		ss.close();

		return msg;
	}

	public Student getSingeleRecord(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Student s;
		String hqlquery = " from Student where id=:id";
		Query<Student> query = ss.createQuery(hqlquery ,Student.class);
		query.setParameter("id", id);
		s = query.getSingleResult();
		tr.commit();
		ss.close();

		return s;
	}

	public List<Student> getAllRecord() {
		List<Student> list = null;
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = "from Student ";
		Query<Student> query = ss.createQuery(hqlquery ,Student.class);
		list = query.list();
		tr.commit();
		ss.close();
		return list;
	}
	public String update(Student s, int id) {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlquery = "update Student set s_name=:fname,l_name=:lname,email=:email where id=:id ";
		MutationQuery query = ss.createMutationQuery(hqlquery);
		query.setParameter("id", id);
		query.setParameter("fname", s.getS_name());
		query.setParameter("lname", s.getL_name());
		query.setParameter("email", s.getEmail());
		query.executeUpdate();
		msg = "updated sucessfully..........!";
		tr.commit();
		ss.close();
		return msg;

	}
	public String deleteRecord(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = " delete from Student where id=:id";
		Query<Student> query = ss.createQuery(hqlquery ,Student.class);
		query.setParameter("id", id);
		query.executeUpdate();
		msg="deleted sucessfully........!";
		tr.commit();
		ss.close();

		return msg;
	}



}
