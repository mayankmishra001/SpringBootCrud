package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentInt;
import com.example.demo.dto.StudentDTO;


@Service
@Transactional
public class StudentServiceImpl implements StudentServiceInt{

	
	@Autowired
	StudentInt dao;
	
	@Override
	public void add(StudentDTO dto) {
		System.out.println("Student service");
		dao.add(dto);
	}

	@Override
	public void update(StudentDTO dto) {

		dao.update(dto);
	}

	@Override
	public void delete(long id) {
		StudentDTO dto = findByPK(id);
		dao.delete(dto);
	}

	@Override
	public StudentDTO findByPK(long id) {
		StudentDTO dto = dao.findByPK(id);
		return dto;
	}

	@Override
	public List search(StudentDTO dto, int pageNo, int pageSize) {

		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}
	

}
