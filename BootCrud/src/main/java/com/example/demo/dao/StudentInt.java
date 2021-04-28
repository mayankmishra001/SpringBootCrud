package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.StudentDTO;

public interface StudentInt {
	
	public void add(StudentDTO dto);
	
	public void update(StudentDTO dto);
	
	public void delete(StudentDTO dto);

	public StudentDTO findByPK(long id);
	
	public List search (StudentDTO dto,int pageNo, int pageSize);
}
