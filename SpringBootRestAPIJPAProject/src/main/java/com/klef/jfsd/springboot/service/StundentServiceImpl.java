package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;


@Service
public class StundentServiceImpl implements StudentServcie
{
	@Autowired
	private StudentRepository repository;

	@Override
	public String addStudent(Student s) {
		repository.save(s);
		return "Stundent added successfully";
	}

	@Override
	public String updateStudent(Student s) {
		
		Optional<Student> obj =   repository.findById(s.getId());
		
		if(obj.isPresent()) {
			
			Student student = obj.get();
			
			student.setGender(s.getGender());
			student.setName(s.getName());
			student.setAge(s.getAge());
			student.setEmail(s.getEmail());
			student.setContact(s.getContact());
			student.setDepartment(s.getDepartment());
			
			repository.save(student);
			
			return "Student updated successfully";
			
		}else {
		return "id not found";
		}
		
	}

	@Override
	public String deleteStudent(int sid) {
		Optional<Student> obj = repository.findById(sid);
		String msg = null;
		
		if(obj.isPresent()) {
			Student s = obj.get();
			repository.delete(s);
			msg = "Student deleted Successfully";
			
		}else {
			msg = "Student id not found";
		}
		
		return msg;
	}

	@Override
	public List<Student> displayAllStundents() {
		
		return (List<Student>) repository.findAll();
	}

	@Override
	public Student displayStudentByID(int sid) {
		
		return repository.findById(sid).get();
	}

}
