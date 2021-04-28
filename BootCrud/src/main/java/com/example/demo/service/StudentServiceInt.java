package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDTO;


public interface StudentServiceInt {
	
	public void add(StudentDTO dto);

	public void update(StudentDTO dto);

	public void delete(long id);

	public StudentDTO findByPK(long id);
	
	public List search(StudentDTO dto,int pageNo,int pageSize);

}
